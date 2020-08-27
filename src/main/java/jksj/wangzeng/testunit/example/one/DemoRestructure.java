package jksj.wangzeng.testunit.example.one;

import java.util.Date;

/**
 * @author swsm
 * @date 2020/8/26
 */
public class DemoRestructure {

    public long caculateDelayDays(Date dueTime) {
        long currentTimestamp = getCurrentTimeMillis();
        if (dueTime.getTime() >= currentTimestamp) {
            return 0;
        }
        long delayTime = currentTimestamp - dueTime.getTime();
        long delayDays = delayTime / 86400 / 1000;
        return delayDays;
    }
    
    protected long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
    
}
