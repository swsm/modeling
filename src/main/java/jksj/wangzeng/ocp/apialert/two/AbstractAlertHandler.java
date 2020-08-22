package jksj.wangzeng.ocp.apialert.two;

/**
 * 抽象的预警handler类
 * @author swsm
 * @date 2020/8/22
 */
public abstract class AbstractAlertHandler {
    
    protected AlertRule rule;
    protected Notification notification;
    
    

    public AbstractAlertHandler(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }
    
    public abstract void check(ApiStatusInfo apiStatusInfo);
}
