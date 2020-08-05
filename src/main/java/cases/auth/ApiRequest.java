package cases.auth;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author swsm
 * @date 2020/7/24
 */
public class ApiRequest {

    private String baseUrl;

    private String token;


    private String appId;

    private long timestamp;

    public ApiRequest(String baseUrl, String token, String appId, long timestamp) {
        this.baseUrl = baseUrl;
        this.token = token;
        this.appId = appId;
        this.timestamp = timestamp;
    }

    public static ApiRequest createFromFullUrl(String url) {
        Map<String, String> map = getUrlPramNameAndValue(url);
        String baseUrl = url.substring(0, url.indexOf('?') == -1 ? url.length() : url.indexOf('?'));
        String token = map.get("token");
        String appId = map.get("appId");
        long timestamp = Long.valueOf(map.get("createTime"));
        return new ApiRequest(baseUrl, token, appId, timestamp);
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getToken() {
        return this.token;
    }

    public String getAppId() {
        return this.appId;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    /**
     * 2  * 获取URL中的参数名和参数值的Map集合
     * 3  * @param url
     * 4  * @return
     * 5
     */
    private static Map<String, String> getUrlPramNameAndValue(String url) {
        String regEx = "(\\?|&+)(.+?)=([^&]*)";//匹配参数名和参数值的正则表达式
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(url);
        // LinkedHashMap是有序的Map集合，遍历时会按照加入的顺序遍历输出
        Map<String, String> paramMap = new LinkedHashMap<String, String>();
        while (m.find()) {
            String paramName = m.group(2);//获取参数名
            String paramVal = m.group(3);//获取参数值
            paramMap.put(paramName, paramVal);
        }
        return paramMap;
    }

    public static void main(String[] args) {
        String url = "http://123.com?aa=123&bb=345&dd=qw";
        Map<String, String> urlPramNameAndValue = getUrlPramNameAndValue(url);
        System.out.println(urlPramNameAndValue);
    }

}
