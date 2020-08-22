package jksj.wangzeng.ocp.apialert.two;

/**
 * @author swsm
 * @date 2020/8/22
 */
public class TpsAlertHandler extends AbstractAlertHandler {

    public TpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatusInfo apiStatusInfo) {
        long tps = apiStatusInfo.getRequestCount() / apiStatusInfo.getDurationOfSeconds();
        if (tps > rule.getMatchedRule(apiStatusInfo.getApi()).getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.SERVER, "....");
        }
        
    }
    
    
}
