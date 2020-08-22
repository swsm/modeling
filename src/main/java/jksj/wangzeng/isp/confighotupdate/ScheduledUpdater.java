package jksj.wangzeng.isp.confighotupdate;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author swsm
 * @date 2020/8/22
 */
public class ScheduledUpdater {
    
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    
    private long initialDelayInSeconds;
    private long periodInSeconds;
    private Update update;
    
    public ScheduledUpdater(Update update, long initialDelayInSeconds, long periodInSeconds) {
        this.update = update;
        this.periodInSeconds = periodInSeconds;
        this.initialDelayInSeconds = initialDelayInSeconds;
    }
    
    public void run() {
        executorService.scheduleAtFixedRate(() -> {
            update.update();
        }, this.initialDelayInSeconds, this.periodInSeconds, TimeUnit.SECONDS);
    }
    
}
