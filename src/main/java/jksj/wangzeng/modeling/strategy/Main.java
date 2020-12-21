package jksj.wangzeng.modeling.strategy;

import jksj.wangzeng.modeling.strategy.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author swsm
 * @date 2020/12/21
 */
public class Main {

    public static void main(String[] args) {
        ICreateOrder createOrder = new AliCreateOrder(new OrderRepository());
        List<Object> notifyList = new ArrayList<>();
        notifyList.add(new AliPayNotification());
        createOrder.setOrderCreateSuccessObserver(notifyList);
        Long order = createOrder.createOrder(new CreateOrderDto());
        System.out.println("ali订单生成了，订单号是" + order);

        ICreateOrder createOrder2 = new WechatCreateOrder(new OrderRepository());
        List<Object> notifyList2 = new ArrayList<>();
        notifyList2.add(new WechatPayNotification());
        createOrder2.setOrderCreateSuccessObserver(notifyList2);
        Long order1 = createOrder2.createOrder(new CreateOrderDto());
        System.out.println("wechat订单生成了，订单号是" + order);
    }
    
    
    
}
