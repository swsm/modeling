package jksj.wangzeng.testunit.transaction;

/**
 * @author swsm
 * @date 2020/8/26
 */
public class RedisDistributedLock {
    
    private RedisDistributedLock() {
        
    }
    
    private static final RedisDistributedLock REDIS_DISTRIBUTED_LOCK = new RedisDistributedLock();
    
    public static RedisDistributedLock getInstance() {
        return REDIS_DISTRIBUTED_LOCK;
    }
    
    public boolean lockTransaction(String id) {
        return true;
    }

    public void unlockTransaction(String id) {
        
    }
}
