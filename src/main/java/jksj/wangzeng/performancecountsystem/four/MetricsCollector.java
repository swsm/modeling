package jksj.wangzeng.performancecountsystem.four;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.Executors;

/**
 * @author swsm
 * @date 2020/8/23
 */
public class MetricsCollector {
    
    private static final int DEFAULT_STORAGE_THREAD_POOL_SIZE = 20;
    
    private MetricsStorage metricsStorage;
    private EventBus eventBus;
    
    public class EventListener {
        
        @Subscribe
        public void saveRequestInfo(RequestInfo requestInfo) {
            metricsStorage.saveRequestInfo(requestInfo);
        }
    }
    
    public MetricsCollector(MetricsStorage metricsStorage, int threadNumToSaveData) {
        this.metricsStorage = metricsStorage;
        this.eventBus = new AsyncEventBus(Executors.newFixedThreadPool(threadNumToSaveData));
        this.eventBus.register(new EventListener());
    }
    
    public MetricsCollector() {
        this(new RedisMetricsStorage(), DEFAULT_STORAGE_THREAD_POOL_SIZE);
    }
    
    
    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
            return;
        }
        eventBus.post(requestInfo);
    }
    
}
