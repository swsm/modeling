package jksj.wangzeng.auth;

/**
 * @author swsm
 * @date 2020/7/24
 */
public class DefaultApiAuthenticator implements ApiAuthenticator {
    
    private CredentialStorage credentialStorage;
    
    
    public DefaultApiAuthenticator() {
        this.credentialStorage = new MysqlCredentialStorage();
    }
    
    public DefaultApiAuthenticator(CredentialStorage credentialStorage) {
        this.credentialStorage = credentialStorage;
    }
    
    @Override
    public void auth(String url) {
        ApiRequest apiRequest = ApiRequest.createFromFullUrl(url);
        auth(apiRequest);
    }

    @Override
    public void auth(ApiRequest apiRequest) {
        String appId = apiRequest.getAppId();
        String token = apiRequest.getToken();
        long timestamp = apiRequest.getTimestamp();
        
        AuthToken clientAuthToken = new AuthToken(token, timestamp);
        if (clientAuthToken.isExpired()) {
            throw new RuntimeException("token is expired");
        }

        String originalUrl = apiRequest.getBaseUrl();
        String password = this.credentialStorage.getPasswordByAppId(appId);
        try {
            AuthToken serverAuthToken = AuthToken.create(originalUrl, timestamp, appId, password);
            if (!serverAuthToken.match(clientAuthToken)) {
                throw new RuntimeException("token is not valid");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token is not valid");
        }
        System.out.println("验证token通过");


    }
}
