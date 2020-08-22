package jksj.wangzeng.ocp.apialert.two;

/**
 * @author swsm
 * @date 2020/8/22
 */
public class ApiStatusInfo {

    /**
     * api 名称
     */
    private String api;
    
    /**
     * 请求书
     */
    private long requestCount;

    /**
     * 错误树
     */
    private long errorCount;

    /**
     * 间隔时间
     */
    private long durationOfSeconds;

    /**
     * 超时次数
     */
    private long timeoutCount;

    public ApiStatusInfo() {
    }

    /**
     * 构造方法
     * @param api api名称
     * @param requestCount 请求数
     * @param errorCount 错误数
     * @param durationOfSeconds 间隔时间
     */
    public ApiStatusInfo(String api, long requestCount, long errorCount, long durationOfSeconds, long timeoutCount) {
        this.api = api;
        this.requestCount = requestCount;
        this.errorCount = errorCount;
        this.durationOfSeconds = durationOfSeconds;
        this.timeoutCount = timeoutCount;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public long getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(long requestCount) {
        this.requestCount = requestCount;
    }

    public long getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(long errorCount) {
        this.errorCount = errorCount;
    }

    public long getDurationOfSeconds() {
        return durationOfSeconds;
    }

    public void setDurationOfSeconds(long durationOfSeconds) {
        this.durationOfSeconds = durationOfSeconds;
    }

    public long getTimeoutCount() {
        return timeoutCount;
    }

    public void setTimeoutCount(long timeoutCount) {
        this.timeoutCount = timeoutCount;
    }
}
