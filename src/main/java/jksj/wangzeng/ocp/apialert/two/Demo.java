package jksj.wangzeng.ocp.apialert.two;

/**
 * @author swsm
 * @date 2020/8/22
 */
public class Demo {

    public static void main(String[] args) {
        ApiStatusInfo apiStatusInfo = new ApiStatusInfo();
        apiStatusInfo.setApi("/api/query");
        apiStatusInfo.setDurationOfSeconds(2);
        apiStatusInfo.setErrorCount(11);
        apiStatusInfo.setRequestCount(50);
        apiStatusInfo.setTimeoutCount(11);
        ApplicationContext.getInstance().getAlert().check(apiStatusInfo);
    }
    
}
