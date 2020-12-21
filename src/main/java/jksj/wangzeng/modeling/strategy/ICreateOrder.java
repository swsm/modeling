package jksj.wangzeng.modeling.strategy;

import java.util.List;

/**
 * @author swsm
 * @date 2020/12/21
 */
public interface ICreateOrder {
    
    long createOrder(CreateOrderDto createOrderDto);
    
    void setOrderCreateSuccessObserver(List<Object> osList);
    
}
