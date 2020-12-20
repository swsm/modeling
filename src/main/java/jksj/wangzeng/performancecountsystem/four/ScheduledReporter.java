package jksj.wangzeng.performancecountsystem.four;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author swsm
 * @date 2020/8/29
 */
public abstract class ScheduledReporter {
    
    private static final long MAX_STAT_DURATION_IN_MILLIS = 10 * 60 * 1000; // 10分钟
    
    protected MetricsStorage metricsStorage;
    protected Aggregator aggregator;
    protected StatViewer viewer;
    
    public ScheduledReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.viewer = viewer;
    }
    
    protected void doStatAndReport(long startTimeInMillis, long endTimeInMillis) {
        long durationInMillis = endTimeInMillis - startTimeInMillis;
        Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
        Map<String, RequestStat> requestStats = aggregator.aggregate(requestInfos, durationInMillis);
        viewer.output(requestStats, startTimeInMillis, endTimeInMillis);
    }
    
    private Map<String, RequestStat> doStat(long startTimeInMillis, long endTimeMillis) {
        Map<String, List<RequestStat>> segmentsStats = new HashMap<>();
        long segmentStartTimeMillis = startTimeInMillis;
        while (segmentStartTimeMillis < endTimeMillis) {
            long segmentEndTimeMillis = segmentStartTimeMillis + MAX_STAT_DURATION_IN_MILLIS;
            if (segmentEndTimeMillis > endTimeMillis) {
                segmentEndTimeMillis = endTimeMillis;
            }
            Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(segmentStartTimeMillis, segmentEndTimeMillis);
            if (requestInfos == null || requestInfos.isEmpty()) {
                continue;
            }
            Map<String, RequestStat> segmentStat = aggregator.aggregate(requestInfos, segmentEndTimeMillis - segmentStartTimeMillis);
            addStat(segmentsStats, segmentStat);
            segmentStartTimeMillis = segmentStartTimeMillis + MAX_STAT_DURATION_IN_MILLIS;
        }
        long durationInMillis = endTimeMillis - startTimeInMillis;
        Map<String, RequestStat> aggregatedStats = aggregateStats(segmentsStats, durationInMillis);
        return aggregatedStats;
    }

    private void addStat(Map<String, List<RequestStat>> segmentsStats, Map<String, RequestStat> segmentStat) {
        for (Map.Entry<String, RequestStat> entry : segmentStat.entrySet()) {
            String apiName = entry.getKey();
            RequestStat requestStat = entry.getValue();
            List<RequestStat> requestStats = segmentsStats.putIfAbsent(apiName, new ArrayList<>());
            requestStats.add(requestStat);
        }
    }

    private Map<String, RequestStat> aggregateStats(Map<String, List<RequestStat>> segmentsStats, long durationInMillis) {
        
        Map<String, RequestStat> aggregatedStats = new HashMap<>();
        for (Map.Entry<String, List<RequestStat>> entry : segmentsStats.entrySet()) {
            String apiName = entry.getKey();
            List<RequestStat> apiStats = entry.getValue();
            double maxRespTime = Double.MIN_VALUE;
            double minRespTime = Double.MAX_VALUE;
            long count = 0;
            double sumRespTime = 0;
            for (RequestStat apiStat : apiStats) {
                if (apiStat.getMaxResponseTime() > maxRespTime) maxRespTime = apiStat.getMaxResponseTime();
                if (apiStat.getMinResponseTime() < minRespTime) minRespTime = apiStat.getMinResponseTime();
                sumRespTime += apiStat.getAvgResponseTime() * apiStat.getCount();
                count += apiStat.getCount();
            }
            RequestStat aggregatedStat = new RequestStat(); 
            aggregatedStat.setMaxResponseTime(maxRespTime); 
            aggregatedStat.setMinResponseTime(minRespTime); 
            aggregatedStat.setAvgResponseTime(sumRespTime / count); 
            aggregatedStat.setCount(count); 
            aggregatedStat.setTps(count / durationInMillis * 1000); 
            aggregatedStats.put(apiName, aggregatedStat);
        }
        return aggregatedStats;
    }
    
}
