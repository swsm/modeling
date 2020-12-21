package jksj.wangzeng.modeling.strategy;

import com.google.common.eventbus.AsyncEventBus;
import jksj.wangzeng.modeling.strategy.repository.OrderRepository;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * @author swsm
 * @date 2020/12/21
 */
public class AliCreateOrder extends AbstractCreateOrder {

    public AliCreateOrder(OrderRepository orderRepository) {
        super(orderRepository);
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(20));
    }

    @Override
    public void setOrderCreateSuccessObserver(List<Object> osList) {
        for (Object o : osList) {
            eventBus.register(o);
        }
    }
    
    @Override
    protected void checkOrder(CreateOrderDto createOrderDto) {
        System.out.println("我是ali 的订单，我检查完订单了");
    }

    @Override
    protected CreateOrderBo build(CreateOrderDto createOrderDto) {
        System.out.println("我是ali 的订单，我构建完可以直接保存的订单了");
        return new CreateOrderBo();
    }

    

}
