package jksj.wangzeng.modeling.strategy;

import com.google.common.eventbus.EventBus;
import jksj.wangzeng.modeling.strategy.repository.OrderRepository;

/**
 * @author swsm
 * @date 2020/12/21
 */
public abstract class AbstractCreateOrder implements ICreateOrder {
    
    abstract  protected  void checkOrder(CreateOrderDto createOrderDto);
    
    abstract  protected  CreateOrderBo build(CreateOrderDto createOrderDto);
    
    private OrderRepository orderRepository;
    
    protected EventBus eventBus;
    
    
    protected AbstractCreateOrder(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        
    }

    protected void notify(Long orderId) {
        eventBus.post(orderId);
    }

    @Override
    public long createOrder(CreateOrderDto createOrderDto) {
        checkOrder(createOrderDto);
        CreateOrderBo createOrderBo = build(createOrderDto);
        Long orderId = transactonSaveCreateOrderBo(createOrderBo);
        notify(orderId);
        return orderId;
    }
    
    private Long transactonSaveCreateOrderBo(CreateOrderBo createOrderBo) {
        long orderId = orderRepository.saveOrder(createOrderBo.getOrder());
        orderRepository.saveDeliver(createOrderBo.getDelivery());
        orderRepository.savePay(createOrderBo.getPayInfo());
        orderRepository.saveOrderPromoter(createOrderBo.getOrderPromoter());
        return orderId;
    }
    
}
