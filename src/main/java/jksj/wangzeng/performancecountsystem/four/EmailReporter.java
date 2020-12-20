package jksj.wangzeng.performancecountsystem.four;

import com.google.common.annotations.VisibleForTesting;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author swsm
 * @date 2020/8/23
 */
public class EmailReporter extends ScheduledReporter {
    
    private static final Long DAY_HOURS_IN_SECONDS = 86400L;
    
    public EmailReporter() {
        this(new RedisMetricsStorage(), new Aggregator(), new EmailViewer());
    }
    
    public EmailReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        super(metricsStorage, aggregator, viewer);
    }
    
    public void startDailyReport() {
        Calendar calendar = trimTimeFieldsToZeroOfNextDay(new Date());
        Date firstTime = calendar.getTime();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMills = System.currentTimeMillis();
                long startTimeInMills = endTimeInMills - durationInMillis;
                doStatAndReport(startTimeInMills, endTimeInMills);
            }
        }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
    }

    @VisibleForTesting
    protected Calendar trimTimeFieldsToZeroOfNextDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

}
