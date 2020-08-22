package jksj.wangzeng.ocp.messagequeue;

import jksj.wangzeng.ocp.apialert.two.Notification;

/**
 * @author swsm
 * @date 2020/8/22
 */
public class Demo {
    
    private MessageQueue messageQueue;
    public Demo(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    /**
     * MessageFormatter:多态 依赖注入
     * @param notification
     * @param messageFormatter
     */
    public void sendNotification(Notification notification, MessageFormatter messageFormatter) {
        
    }
    
}
