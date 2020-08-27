package jksj.wangzeng.testunit.transaction;

import java.util.UUID;

/**
 * @author swsm
 * @date 2020/8/26
 */
public class WalletRpcService {
    
    public String moveMoney(String id, Long buyerId, Long sellerId, Double amount) {
        return UUID.randomUUID().toString();
    }
}
