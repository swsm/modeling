package jksj.wangzeng.modeling.strategy;

import com.google.common.eventbus.Subscribe;

/**
 * @author swsm
 * @date 2020/12/21
 */
public class WechatPayNotification {

    @Subscribe
    public void notify(Long orderId) {
        System.out.println("订单号" + orderId + "要通过微信发送支付提醒");
    }
    
}
