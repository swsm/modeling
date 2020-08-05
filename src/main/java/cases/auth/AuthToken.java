package cases.auth;

/**
 * @author swsm
 * @date 2020/7/24
 */
public class AuthToken {
    
    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 1 * 60 * 1000;
    private String token;
    private Long createTime;
    private Long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;
    
    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }
    
    public AuthToken(String token, long createTime, long expiredTimeInterval) {
        this.token = token;
        this.createTime = createTime;
        this.expiredTimeInterval = expiredTimeInterval;
    }
    
    public static AuthToken create(String baseUrl, long creatTime, String appId, String password) {
        System.out.println(String.format("需要加密的字符串baseUrl=%s,creatTime=%d,appId=%s,password=%s", baseUrl, creatTime, appId, password));
        String encrypt = EncrypAES.parseByte2HexStr(EncrypAES.encrypt(baseUrl + creatTime + appId + password, "12345678"));
        System.out.println("加密后的token为" + encrypt);
        return new AuthToken(encrypt, creatTime);
    }
    
    public String getToken() {
        return this.token;
    }
    
    public boolean isExpired() {
        return System.currentTimeMillis() - createTime > this.expiredTimeInterval;
    }
    
    public boolean match(AuthToken authToken) {
        return this.token.equals(authToken.token);
    }
    
    
    
    
}
