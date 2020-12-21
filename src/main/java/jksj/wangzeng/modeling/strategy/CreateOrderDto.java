package jksj.wangzeng.modeling.strategy;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author swsm
 * @date 2020/12/21
 */
public class CreateOrderDto {
    
    private String token;
    private List<Goods> goodsList;
    private Invoicer invoicer;
    private Reciver reciver;    
    
    static class Goods {
        private String name;
        private BigDecimal price;
        private Integer count;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }
    }
    
    
    static class Invoicer {
        private Integer type;

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }
    }
    
    static class Reciver {
        private String mobile;
        private String address;
        private BigDecimal freight;

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public BigDecimal getFreight() {
            return freight;
        }

        public void setFreight(BigDecimal freight) {
            this.freight = freight;
        }
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public Invoicer getInvoicer() {
        return invoicer;
    }

    public void setInvoicer(Invoicer invoicer) {
        this.invoicer = invoicer;
    }

    public Reciver getReciver() {
        return reciver;
    }

    public void setReciver(Reciver reciver) {
        this.reciver = reciver;
    }
}
