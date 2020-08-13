package jksj.wangzeng.pocket.pinxue.repo;

import jksj.wangzeng.pocket.pinxue.entity.VirtualWalletEntity;

import java.math.BigDecimal;

/**
 * @author swsm
 * @date 2020/8/12
 */
public class VirtualWalletRepository {


    public VirtualWalletEntity getVirtualWallet(Long walletId) {
        return new VirtualWalletEntity();
    }

    public BigDecimal getBalance(Long walletId) {
        return new BigDecimal(0);
    }

    public void updateBalance(Long walletId, BigDecimal subtract) {
    }
}
