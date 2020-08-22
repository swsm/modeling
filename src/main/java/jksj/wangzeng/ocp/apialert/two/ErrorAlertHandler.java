package jksj.wangzeng.ocp.apialert.two;

/**
 * @author swsm
 * @date 2020/8/22
 */
public class ErrorAlertHandler extends AbstractAlertHandler {


    public ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatusInfo apiStatusInfo) {
        if (apiStatusInfo.getErrorCount() > rule.getMatchedRule(apiStatusInfo.getApi()).getMaxErrorCount()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, ".....");
        }
    }
}
