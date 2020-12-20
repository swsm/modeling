package study2.alerm;

import java.util.List;

/**
 * @author swsm
 * @date 2020/11/4
 */
public class ApiInfo {
    
    // "get"  "post"
    private String methodType;
    
    private String url;
    
    private List<AlertTarget> alertTargets;


    public ApiInfo(String methodType, String url, List<AlertTarget> alertTargets) {
        this.methodType = methodType;
        this.url = url;
        this.alertTargets = alertTargets;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<AlertTarget> getAlertTargets() {
        return alertTargets;
    }

    public void setAlertTargets(List<AlertTarget> alertTargets) {
        this.alertTargets = alertTargets;
    }

}
class AlertTarget {
    int seconds;
    int count;
    // 1. 超时 2. 错误
    int type;

    // 达到后的预警方式
    AlertMethod alertMethod;

    public AlertTarget(int seconds, int count, int type, AlertMethod alertMethod) {
        this.seconds = seconds;
        this.count = count;
        this.type = type;
        this.alertMethod = alertMethod;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public AlertMethod getAlertMethod() {
        return alertMethod;
    }

    public void setAlertMethod(AlertMethod alertMethod) {
        this.alertMethod = alertMethod;
    }
}
