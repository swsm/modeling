package jksj.wangzeng.ocp.apialert.two;

/**
 * @author swsm
 * @date 2020/8/22
 */
public class TimeoutAlertHandler extends AbstractAlertHandler {

    public TimeoutAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatusInfo apiStatusInfo) {
        if (apiStatusInfo.getTimeoutCount() > rule.getMatchedRule(apiStatusInfo.getApi()).getTimeOutCount()) {
            notification.notify(NotificationEmergencyLevel.SERVER, "....");
        }
        
    }
}
