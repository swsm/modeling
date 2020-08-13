package jksj.wangzeng.auth;

/**
 * @author swsm
 * @date 2020/7/24
 */
public interface CredentialStorage {
    
    
    String getPasswordByAppId(String appId);
}
