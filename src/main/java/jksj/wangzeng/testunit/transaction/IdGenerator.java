package jksj.wangzeng.testunit.transaction;

import java.util.UUID;

/**
 * @author swsm
 * @date 2020/8/26
 */
public class IdGenerator {
    
    public static String generateTransactionId() {
        return UUID.randomUUID().toString();
    }
}
