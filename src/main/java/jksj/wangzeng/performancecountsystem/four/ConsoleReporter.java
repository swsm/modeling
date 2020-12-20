package jksj.wangzeng.performancecountsystem.four;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author swsm
 * @date 2020/8/23
 */
public class ConsoleReporter extends ScheduledReporter {
    
    private ScheduledExecutorService executorService;
    
    public ConsoleReporter() {
        this(new RedisMetricsStorage(), new Aggregator(), new ConsoleViewer());
    }
    
    public ConsoleReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        super(metricsStorage, aggregator, viewer);
        this.executorService = Executors.newSingleThreadScheduledExecutor();
    }
    
    public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
        executorService.scheduleAtFixedRate(() -> {
            super.doStatAndReport(new Date().getTime(), new Date().getTime() + durationInSeconds);
        }, 0, periodInSeconds, TimeUnit.SECONDS);
    }
    
}
