package jksj.wangzeng.modeling.strategy;

import com.google.common.eventbus.EventBus;
import jksj.wangzeng.modeling.strategy.repository.OrderRepository;

import java.util.List;

/**
 * @author swsm
 * @date 2020/12/21
 */
public class WechatCreateOrder extends AbstractCreateOrder {
    
    public WechatCreateOrder(OrderRepository orderRepository) {
        super(orderRepository);
        eventBus = new EventBus();
    }

    @Override
    public void setOrderCreateSuccessObserver(List<Object> osList) {
        for (Object o : osList) {
            eventBus.register(o);
        }
    }
    
    @Override
    protected void checkOrder(CreateOrderDto createOrderDto) {
        System.out.println("我是wechat 的订单，我检查完订单了");
    }

    @Override
    protected CreateOrderBo build(CreateOrderDto createOrderDto) {
        System.out.println("我是wechat 的订单，我构建完可以直接保存的订单了");
        return new CreateOrderBo();
    }


}
