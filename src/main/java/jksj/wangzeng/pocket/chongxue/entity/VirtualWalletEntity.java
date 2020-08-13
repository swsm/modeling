package jksj.wangzeng.pocket.chongxue.entity;

import java.math.BigDecimal;

/**
 * @author swsm
 * @date 2020/8/12
 */
public class VirtualWalletEntity {

    private Long id;
    private Long createTime;
    private BigDecimal balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
