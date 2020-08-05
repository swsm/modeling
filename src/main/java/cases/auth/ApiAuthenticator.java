package cases.auth;

/**
 * api权限鉴权接口
 * @author swsm
 * @date 2020/7/24
 */
public interface ApiAuthenticator {
    
    void auth(String url);
    
    void auth(ApiRequest apiRequest);
    
}
