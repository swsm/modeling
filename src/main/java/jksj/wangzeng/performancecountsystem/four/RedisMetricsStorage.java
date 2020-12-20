package jksj.wangzeng.performancecountsystem.four;

import java.util.List;
import java.util.Map;

/**
 * @author swsm
 * @date 2020/8/23
 */
public class RedisMetricsStorage implements MetricsStorage {
    
    
    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {
        
    }

    @Override
    public List<RequestInfo> getRequestInfo(String apiName, long startTimeInMillis, long endTimeInMills) {
        return null;
    }

    @Override
    public Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMills, long endTimeInMills) {
        return null;
    }

}
