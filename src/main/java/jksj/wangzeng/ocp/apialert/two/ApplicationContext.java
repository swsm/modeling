package jksj.wangzeng.ocp.apialert.two;

/**
 * @author swsm
 * @date 2020/8/22
 */
public class ApplicationContext {
    
    private AlertRule alertRule;
    private Notification notification;
    private Alert alert;
    
    
    private void initializeBeans() {
        alertRule = new AlertRule();
        notification = new Notification();
        alert = new Alert();
        alert.addAlertHandler(new TpsAlertHandler(alertRule, notification));
        alert.addAlertHandler(new ErrorAlertHandler(alertRule, notification));
        alert.addAlertHandler(new TimeoutAlertHandler(alertRule, notification));
    }
    
    public Alert getAlert() {
        return alert;    
    }
    
    private static final ApplicationContext instancce = new ApplicationContext();
    
    public ApplicationContext() {
        initializeBeans();
    }
    
    public static ApplicationContext getInstance() {
        return instancce;
    }
    
    
}
