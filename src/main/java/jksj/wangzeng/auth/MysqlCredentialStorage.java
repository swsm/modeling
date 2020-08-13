package jksj.wangzeng.auth;

/**
 * @author swsm
 * @date 2020/7/24
 */
public class MysqlCredentialStorage implements CredentialStorage {
    
    @Override
    public String getPasswordByAppId(String appId) {
        return "appId-password";
    }
    
}
