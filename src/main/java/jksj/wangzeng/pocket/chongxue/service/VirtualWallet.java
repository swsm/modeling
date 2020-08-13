package jksj.wangzeng.pocket.chongxue.service;

import java.math.BigDecimal;

/**
 * @author swsm
 * @date 2020/8/12
 */
public class VirtualWallet {
    
    private Long id;
    private Long createTime = System.currentTimeMillis();
    private BigDecimal balance = BigDecimal.ZERO;
    
    private boolean isAllowedOverdraft = true;
    private BigDecimal overdraftAmount = BigDecimal.ZERO;
    private BigDecimal frozenAmount = BigDecimal.ZERO;
    
    public VirtualWallet(Long preAllocatedId) {
        this.id = preAllocatedId;
    }
    
    public void freeze(BigDecimal amount) {
        this.frozenAmount = amount;
    }
    
    public void unFreeze(BigDecimal amount) {
        this.frozenAmount.subtract(amount);
    }
    
    public void increaseOverdraftAmount(BigDecimal amount) {
        this.overdraftAmount.add(amount);
    }
    
    public void decreateOverdraftAmount(BigDecimal amount) {
        this.overdraftAmount.subtract(amount);
    }
    
    public void closeOverdraft() {
        this.isAllowedOverdraft = false;
    }
    
    public void openOverdraft() {
        this.isAllowedOverdraft = true;
    }
    
    public BigDecimal getAvailableBalance() {
        BigDecimal totalAvaliableBalance = this.balance.subtract(this.frozenAmount);
        if (isAllowedOverdraft) {
            totalAvaliableBalance.add(this.overdraftAmount);
        }
        return totalAvaliableBalance;
    }
    
    
    
    public BigDecimal balance() {
        return this.balance;
    }
    
    public void debit(BigDecimal amount) {
        BigDecimal totalAvaliableBalance = getAvailableBalance();
        if (totalAvaliableBalance.compareTo(amount) < 0) {
            throw new RuntimeException("金额小于借出金额");
        }
        this.balance.subtract(amount);
    }
    
    public void credit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("贷进金额小于0");
        }
        this.balance.add(amount);
    }
    
    
}
