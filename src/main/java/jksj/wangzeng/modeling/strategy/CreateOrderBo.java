package jksj.wangzeng.modeling.strategy;

/**
 * @author swsm
 * @date 2020/12/21
 */
public class CreateOrderBo {

    private Order order;
    
    private OrderPromoter orderPromoter;
    
    private PayInfo payInfo;
    
    private Delivery delivery;
    
    public static class OrderPromoter {
        
    }

    public static class PayInfo {
        
    }

    public static class Delivery {
        
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderPromoter getOrderPromoter() {
        return orderPromoter;
    }

    public void setOrderPromoter(OrderPromoter orderPromoter) {
        this.orderPromoter = orderPromoter;
    }

    public PayInfo getPayInfo() {
        return payInfo;
    }

    public void setPayInfo(PayInfo payInfo) {
        this.payInfo = payInfo;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}
