package jksj.wangzeng.modeling.strategy.repository;

import jksj.wangzeng.modeling.strategy.CreateOrderBo;
import jksj.wangzeng.modeling.strategy.Order;

import java.util.Random;

/**
 * @author swsm
 * @date 2020/12/21
 */
public class OrderRepository {
    public long saveOrder(Order order) {
        return new Random().nextLong();
    }

    public void saveDeliver(CreateOrderBo.Delivery delivery) {
    }

    public void savePay(CreateOrderBo.PayInfo payInfo) {
    }

    public void saveOrderPromoter(CreateOrderBo.OrderPromoter orderPromoter) {
    }
}
