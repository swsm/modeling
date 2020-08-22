package jksj.wangzeng.ocp.apialert.two;

/**
 * 通知类
 * @author swsm
 * @date 2020/8/20
 */
public class Notification {
    
    public void notify(NotificationEmergencyLevel notificationEmergencyLevel, String msg) {
        System.out.println(String.format("预警程度是%s,预警信息是%s", notificationEmergencyLevel, msg));
    }
    
    
    
}
