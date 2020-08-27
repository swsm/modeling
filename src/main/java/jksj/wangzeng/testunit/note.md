## 1.测试用例
1. 正常情况下，交易执行成功，回填用于对账（交易与钱包的交易流水）用的 walletTransactionId，交易状态设置为 EXECUTED，函数返回 true。
2. buyerId、sellerId 为 null、amount 小于 0，返回 InvalidTransactionException。
3. 交易已过期（createTimestamp 超过 14 天），交易状态设置为 EXPIRED，返回 false。
4.交易已经执行了（status==EXECUTED），不再重复执行转钱逻辑，返回 true。
5. 钱包（WalletRpcService）转钱失败，交易状态设置为 FAILED，函数返回 false。
6. 交易正在执行着，不会被重复执行，函数直接返回 false

以上的测试用例，只有2比较好测试，其余的都不好测试

- 如果要让这个单元测试能够运行，我们需要搭建 Redis 服务和 Wallet RPC 服务。搭建和维护的成本比较高。
- 我们还需要保证将伪造的 transaction 数据发送给 Wallet RPC 服务之后，能够正确返回我们期望的结果，然而 Wallet RPC 服务有可能是第三方（另一个团队开发维护的）的服务，并不是我们可控的。换句话说，并不是我们想让它返回什么数据就返回什么。
- Transaction 的执行跟 Redis、RPC 服务通信，需要走网络，耗时可能会比较长，对单元测试本身的执行性能也会有影响。
- 网络的中断、超时、Redis、RPC 服务的不可用，都会影响单元测试的执行。


我们回到单元测试的定义上来看一下。单元测试主要是测试程序员自己编写的代码逻辑的正确性，并非是端到端的集成测试，它不需要测试所依赖的外部系统（分布式锁、Wallet RPC 服务）的逻辑正确性。所以，如果代码中依赖了外部系统或者不可控组件，比如，需要依赖数据库、网络通信、文件系统等，那我们就需要将被测代码与外部系统解依赖，而这种解依赖的方法就叫作“mock”。所谓的 mock 就是用一个“假”的服务替换真正的服务。mock 的服务完全在我们的控制之下，模拟输出我们想要的数据。

那如何来 mock 服务呢？mock 的方式主要有两种，手动 mock 和利用框架 mock。利用框架 mock 仅仅是为了简化代码编写，每个框架的 mock 方式都不大一样。我们这里只展示手动 mock。我们通过继承 WalletRpcService 类，并且重写其中的 moveMoney() 函数的方式来实现 mock。具体的代码实现如下所示。通过 mock 的方式，我们可以让 moveMoney() 返回任意我们想要的数据，完全在我们的控制范围内，并且不需要真正进行网络通信


```java
public class MockWalletRpcServiceOne extends WalletRpcService { 
    public String moveMoney(Long id, Long fromUserId, Long toUserId, Double amount) { return "123bac";} 
}

public class MockWalletRpcServiceTwo extends WalletRpcService { 
    public String moveMoney(Long id, Long fromUserId, Long toUserId, Double amount) { return null; } 
}
```


现在我们再来看，如何用 MockWalletRpcServiceOne、MockWalletRpcServiceTwo 来替换代码中的真正的 WalletRpcService 呢？
因为 WalletRpcService 是在 execute() 函数中通过 new 的方式创建的，我们无法动态地对其进行替换。也就是说，
Transaction 类中的 execute() 方法的可测试性很差，需要通过重构来让其变得更容易测试。该如何重构这段代码呢？

依赖注入是实现代码可测试性的最有效的手段。我们可以应用依赖注入，
将 WalletRpcService 对象的创建反转给上层逻辑，在外部创建好之后，再注入到 Transaction 类中。重构之后的
 Transaction 类的代码如下所示：
 
 ```java

public class Transaction {
  //...
  // 添加一个成员变量及其set方法
  private WalletRpcService walletRpcService;
  
  public void setWalletRpcService(WalletRpcService walletRpcService) {
    this.walletRpcService = walletRpcService;
  }
  // ...
  public boolean execute() {
    // ...
    // 删除下面这一行代码
    // WalletRpcService walletRpcService = new WalletRpcService();
    // ...
  }
}
```

现在，我们就可以在单元测试中，非常容易地将 WalletRpcService 替换成 MockWalletRpcServiceOne 或 WalletRpcServiceTwo 了。重构之后的代码对应的单元测试如下所示：
```java
public void testExecute() {
  Long buyerId = 123L;
  Long sellerId = 234L;
  Long productId = 345L;
  Long orderId = 456L;
  Transction transaction = new Transaction(null, buyerId, sellerId, productId, orderId);
  // 使用mock对象来替代真正的RPC服务
  transaction.setWalletRpcService(new MockWalletRpcServiceOne()):
  boolean executedResult = transaction.execute();
  assertTrue(executedResult);
  assertEquals(STATUS.EXECUTED, transaction.getStatus());
}
```

WalletRpcService 的 mock 和替换问题解决了，我们再来看 RedisDistributedLock。
它的 mock 和替换要复杂一些，主要是因为 RedisDistributedLock 是一个单例类。
单例相当于一个全局变量，我们无法 mock（无法继承和重写方法），也无法通过依赖注入的方式来替换。

如果 RedisDistributedLock 是我们自己维护的，可以自由修改、重构，那我们可以将其改为非单例的模式，
或者定义一个接口，比如 IDistributedLock，让 RedisDistributedLock 实现这个接口。
这样我们就可以像前面 WalletRpcService 的替换方式那样，替换 RedisDistributedLock 为 MockRedisDistributedLock 了。但如果 RedisDistributedLock 不是我们维护的，
我们无权去修改这部分代码，这个时候该怎么办呢？

我们可以对 transaction 上锁这部分逻辑重新封装一下。具体代码实现如下所示：
```java

public class TransactionLock {
  public boolean lock(String id) {
    return RedisDistributedLock.getSingletonIntance().lockTransction(id);
  }
  
  public void unlock() {
    RedisDistributedLock.getSingletonIntance().unlockTransction(id);
  }
}

public class Transaction {
  //...
  private TransactionLock lock;
  
  public void setTransactionLock(TransactionLock lock) {
    this.lock = lock;
  }
 
  public boolean execute() {
    //...
    try {
      isLocked = lock.lock();
      //...
    } finally {
      if (isLocked) {
        lock.unlock();
      }
    }
    //...
  }
}
```

针对重构过的代码，我们的单元测试代码修改为下面这个样子。这样，
我们就能在单元测试代码中隔离真正的 RedisDistributedLock 分布式锁这部分逻辑了。

```java

public void testExecute() {

  Long buyerId = 123L;
  Long sellerId = 234L;
  Long productId = 345L;
  Long orderId = 456L;
  
  TransactionLock mockLock = new TransactionLock() {
    public boolean lock(String id) {
      return true;
    }
  
    public void unlock() {}
  };
  
  Transction transaction = new Transaction(null, buyerId, sellerId, productId, orderId);
  transaction.setWalletRpcService(new MockWalletRpcServiceOne());
  transaction.setTransactionLock(mockLock);
  boolean executedResult = transaction.execute();
  assertTrue(executedResult);
  assertEquals(STATUS.EXECUTED, transaction.getStatus());
}
```
至此，测试用例 1 就算写好了。我们通过依赖注入和 mock，让单元测试代码不依赖任何不可控的外部服务。
你可以照着这个思路，自己写一下测试用例 4、5、6。
现在，我们再来看测试用例 3：交易已过期（createTimestamp 超过 14 天），交易状态设置为 EXPIRED，
返回 false。针对这个单元测试用例，我们还是先把代码写出来，然后再来分析。

上面的代码看似没有任何问题。我们将 transaction 的创建时间 createdTimestamp 设置为 14 天前，也就是说，当单元测试代码运行的时候，transaction 一定是处于过期状态。但是，如果在 Transaction 类中，
并没有暴露修改 createdTimestamp 成员变量的 set 方法（也就是没有定义 setCreatedTimestamp() 函数）呢？
你可能会说，如果没有 createTimestamp 的 set 方法，我就重新添加一个呗！实际上，这违反了类的封装特性。
在 Transaction 类的设计中，createTimestamp 是在交易生成时（也就是构造函数中）自动获取的系统时间，
本来就不应该人为地轻易修改，所以，暴露 createTimestamp 的 set 方法，虽然带来了灵活性，
但也带来了不可控性。因为，我们无法控制使用者是否会调用 set 方法重设 createTimestamp，而重设 createTimestamp 并非我们的预期行为。那如果没有针对 createTimestamp 的 set 方法，
那测试用例 3 又该如何实现呢？实际上，这是一类比较常见的问题，就是代码中包含跟“时间”有关的“未决行为”逻辑。
我们一般的处理方式是将这种未决行为逻辑重新封装。针对 Transaction 类，我们只需要将交易是否过期的逻辑，
封装到 isExpired() 函数中即可，具体的代码实现如下所示

```java

public class Transaction {

  protected boolean isExpired() {
    long executionInvokedTimestamp = System.currentTimestamp();
    return executionInvokedTimestamp - createdTimestamp > 14days;
  }
  
  public boolean execute() throws InvalidTransactionException {
    //...
      if (isExpired()) {
        this.status = STATUS.EXPIRED;
        return false;
      }
    //...
  }
}
```

```java
public void testExecute_with_TransactionIsExpired() {
  Long buyerId = 123L;
  Long sellerId = 234L;
  Long productId = 345L;
  Long orderId = 456L;
  Transction transaction = new Transaction(null, buyerId, sellerId, productId, orderId) {
    protected boolean isExpired() {
      return true;
    }
  };
  boolean actualResult = transaction.execute();
  assertFalse(actualResult);
  assertEquals(STATUS.EXPIRED, transaction.getStatus());
}
```
通过重构，Transaction 代码的可测试性提高了。之前罗列的所有测试用例，现在我们都顺利实现了。
不过，Transaction 类的构造函数的设计还有点不妥。为了方便你查看，我把构造函数的代码重新 copy 了一份贴到这里。

```java

  public Transaction(String preAssignedId, Long buyerId, Long sellerId, Long productId, String orderId) {
    if (preAssignedId != null && !preAssignedId.isEmpty()) {
      this.id = preAssignedId;
    } else {
      this.id = IdGenerator.generateTransactionId();
    }
    if (!this.id.startWith("t_")) {
      this.id = "t_" + preAssignedId;
    }
    this.buyerId = buyerId;
    this.sellerId = sellerId;
    this.productId = productId;
    this.orderId = orderId;
    this.status = STATUS.TO_BE_EXECUTD;
    this.createTimestamp = System.currentTimestamp();
  }
```

我们发现，构造函数中并非只包含简单赋值操作。交易 id 的赋值逻辑稍微复杂。我们最好也要测试一下，
以保证这部分逻辑的正确性。为了方便测试，我们可以把 id 赋值这部分逻辑单独抽象到一个函数中，
具体的代码实现如下所示：
```java

  public Transaction(String preAssignedId, Long buyerId, Long sellerId, Long productId, String orderId) {
    //...
    fillTransactionId(preAssignId);
    //...
  }
  
  protected void fillTransactionId(String preAssignedId) {
    if (preAssignedId != null && !preAssignedId.isEmpty()) {
      this.id = preAssignedId;
    } else {
      this.id = IdGenerator.generateTransactionId();
    }
    if (!this.id.startWith("t_")) {
      this.id = "t_" + preAssignedId;
    }
  }
```

## 2. 其它常见 Anti-Patterns
1. 未决行为
所谓的未决行为逻辑就是，代码的输出是随机或者说不确定的，比如，跟时间、随机数有关的代码。对于这一点，
在刚刚的实战案例中我们已经讲到，你可以利用刚才讲到的方法，试着重构一下下面的代码，并且为它编写单元测试。
```java

// 处理结果见  DemoRestructure
public class Demo {
  public long caculateDelayDays(Date dueTime) {
    long currentTimestamp = System.currentTimeMillis();
    if (dueTime.getTime() >= currentTimestamp) {
      return 0;
    }
    long delayTime = currentTimestamp - dueTime.getTime();
    long delayDays = delayTime / 86400;
    return delayDays;
  }
}

```

2. 全局变量

3. 静态方法

4. 复杂继承

5. 高耦合代码




