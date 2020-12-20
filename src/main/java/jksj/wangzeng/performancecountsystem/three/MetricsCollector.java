package jksj.wangzeng.performancecountsystem.three;

import org.apache.commons.lang3.StringUtils;

/**
 * @author swsm
 * @date 2020/8/23
 */
public class MetricsCollector {
    
    private MetricsStorage metricsStorage;
    
    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }
    
    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }
    
}
