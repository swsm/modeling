package jksj.wangzeng.performancecountsystem.three;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author swsm
 * @date 2020/8/23
 */
public class ConsoleReporter {
    
    private MetricsStorage metricsStorage;
    private ScheduledExecutorService executorService;
    private Aggregator aggregator;
    private StatViewer viewer;
    
    public ConsoleReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        this.metricsStorage = metricsStorage;
        this.executorService = Executors.newSingleThreadScheduledExecutor();
        this.aggregator = aggregator;
        this.viewer = viewer;
    }
    
    public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
        executorService.scheduleAtFixedRate(() -> {
            long durationInMillis = durationInSeconds * 1000;
            long endTimeInMillis = System.currentTimeMillis();
            long startTimeInMillis = endTimeInMillis - durationInMillis;
            Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
            Map<String, RequestStat> stats = aggregator.aggregate(requestInfos, durationInMillis);
            viewer.output(stats, startTimeInMillis, endTimeInMillis);
        }, 0, periodInSeconds, TimeUnit.SECONDS);
    }
    
}
