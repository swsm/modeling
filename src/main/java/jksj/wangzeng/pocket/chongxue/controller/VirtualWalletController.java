package jksj.wangzeng.pocket.chongxue.controller;

import jksj.wangzeng.pocket.pinxue.service.VirtualWalletService;

import java.math.BigDecimal;

/**
 * @author swsm
 * @date 2020/8/12
 */
public class VirtualWalletController {
    
    private VirtualWalletService virtualWalletService;

    /**
     * 查询余额
     * @param walletId
     * @return
     */
    public BigDecimal getBalance(Long walletId) {
        return new BigDecimal(0);
    }

    /**
     * 出账
     * @param walletId
     * @param amount
     */
    public void debit(Long walletId, BigDecimal amount) {
        
    }

    /**
     * 入账
     * @param walletId
     * @param amount
     */
    public void credit(Long walletId, BigDecimal amount) {
        
    }

    /**
     * 转账
     * @param fromWalletId
     * @param toWalletId
     * @param amount
     */
    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
        
    }
    
}
