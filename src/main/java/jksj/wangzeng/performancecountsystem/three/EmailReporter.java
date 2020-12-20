package jksj.wangzeng.performancecountsystem.three;

import java.util.*;

/**
 * @author swsm
 * @date 2020/8/23
 */
public class EmailReporter {
    
    private static final Long DAY_HOURS_IN_SECONDS = 86400L;
    
    private MetricsStorage metricsStorage;
    private Aggregator aggregator;
    private StatViewer viewer;
    
    public EmailReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.viewer = viewer;
    }
    
    public void startDailyReport() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date firstTime = calendar.getTime();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMills = System.currentTimeMillis();
                long startTimeInMills = endTimeInMills - durationInMillis;
                Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMills, endTimeInMills);
                Map<String, RequestStat> stats = aggregator.aggregate(requestInfos, durationInMillis);
                viewer.output(stats, startTimeInMills, endTimeInMills);
            }
        }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
    }
    
}
