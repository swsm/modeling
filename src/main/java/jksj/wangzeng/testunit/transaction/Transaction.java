package jksj.wangzeng.testunit.transaction;

import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * @author swsm
 * @date 2020/8/26
 */
public class Transaction {
    
    private static final long EXPIRED_TIMEMILLIS = 14 * 24 * 60 * 60 * 1000;
    
    private String id;
    private Long buyerId;
    private Long sellerId;
    private Long productId;
    private String orderId;
    private Long createTimestamp;
    private Double amount;
    private Status status;
    private String walletTransactionId;
    
    public Transaction(String preAssignedId, Long buyerId, Long sellerId, Long productId, String orderId) {
        if (preAssignedId != null && !preAssignedId.isEmpty()) {
            this.id = preAssignedId;
        } else {
            this.id = IdGenerator.generateTransactionId();
        }
        if (!this.id.startsWith("t_")) {
            this.id = "t_" + preAssignedId;
        }
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.orderId = orderId;
        this.status = Status.TO_BE_EXECUTD;
        this.createTimestamp = System.currentTimeMillis();
    }
    
    public boolean execute() throws InvalidArgumentException {
        if (buyerId == null || (sellerId == null || amount < 0.0)) {
            throw new InvalidArgumentException(new String[]{"..."});
        }
        if (status == Status.TO_BE_EXECUTD) {
            return true;
        }
        boolean isLocked = false;
        try {
            isLocked = RedisDistributedLock.getInstance().lockTransaction(id);
            if (!isLocked) {
                return false;
            }
            if (status == Status.EXECUTED) {
                return true;
            }
            long executionInvokedTimestamp = System.currentTimeMillis();
            if (executionInvokedTimestamp - createTimestamp > EXPIRED_TIMEMILLIS) {
                this.status = Status.EXPIRED;
                return false;
            }
            WalletRpcService walletRpcService = new WalletRpcService();
            String walletTransactionId = walletRpcService.moveMoney(id, buyerId, sellerId, amount);
            if (walletTransactionId != null) {
                this.walletTransactionId = walletTransactionId;
                this.status = Status.EXECUTED;
                return true;
            } else {
                this.status = Status.FAILED;
                return false;
            }
        } finally {
            if (isLocked) {
                RedisDistributedLock.getInstance().unlockTransaction(id);
            }
        }
        
        
        
    }
    
}
