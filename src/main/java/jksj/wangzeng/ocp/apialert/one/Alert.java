package jksj.wangzeng.ocp.apialert.one;

/**
 * 预警类
 * @author swsm
 * @date 2020/8/20
 */
public class Alert {
    
    private AlertRule alertRule;
    private Notification notification;
    
    public Alert(AlertRule alertRule, Notification notification) {
        this.alertRule = alertRule;
        this.notification = notification;
    }
    
    public void check(String api, long requestCount, long errorCount, long durationOfSeconds) {
        long tps = requestCount / durationOfSeconds;
        if (tps > alertRule.getMatchedRule(api).getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.SERVER, "。。。。");
        }
        if (errorCount > alertRule.getMatchedRule(api).getMaxErrorCount()) {
            notification.notify(NotificationEmergencyLevel.TRIVIAL, "....");
        }
    }
    
}
