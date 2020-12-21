package jksj.wangzeng.modeling.strategy;

import com.google.common.eventbus.Subscribe;

/**
 * @author swsm
 * @date 2020/12/21
 */
public class AliPayNotification {
    
    @Subscribe
    public void notify(Long orderId) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("订单号" + orderId + "要通过钉钉发送支付提醒");
    }
    
}
