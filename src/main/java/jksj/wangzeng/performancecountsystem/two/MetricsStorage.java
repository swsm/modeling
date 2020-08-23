package jksj.wangzeng.performancecountsystem.two;

import java.util.List;
import java.util.Map;

/**
 * @author swsm
 * @date 2020/8/23
 */
public interface MetricsStorage {
    
    void saveRequestInfo(RequestInfo requestInfo);
    
    List<RequestInfo> getRequestInfo(String apiName, long startTimeInMillis, long endTimeInMills);
    
    Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMills, long endTimeInMills);
}
