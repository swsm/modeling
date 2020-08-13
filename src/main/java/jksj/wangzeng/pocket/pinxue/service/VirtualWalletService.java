package jksj.wangzeng.pocket.pinxue.service;

import jksj.wangzeng.pocket.pinxue.bo.VirtualWalletBo;
import jksj.wangzeng.pocket.pinxue.entity.VirtualWalletEntity;
import jksj.wangzeng.pocket.pinxue.entity.VirtualWalletTransactionEntity;
import jksj.wangzeng.pocket.pinxue.enums.Status;
import jksj.wangzeng.pocket.pinxue.repo.VirtualWalletRepository;
import jksj.wangzeng.pocket.pinxue.repo.VirtualWalletTransactionRepository;

import java.math.BigDecimal;

/**
 * @author swsm
 * @date 2020/8/12
 */
public class VirtualWalletService {
    
    private VirtualWalletRepository virtualWalletRepository;
    private VirtualWalletTransactionRepository virtualWalletTransactionRepository;
    
    public VirtualWalletBo getVirtualWallet(Long walletId) {
        VirtualWalletEntity virtualWalletEntity = this.virtualWalletRepository.getVirtualWallet(walletId);
        VirtualWalletBo virtualWalletBo = convert(virtualWalletEntity);
        return virtualWalletBo;
    }

    private VirtualWalletBo convert(VirtualWalletEntity virtualWalletEntity) {
        return new VirtualWalletBo();
    }
    
    public BigDecimal getBalance(Long walletId) {
        return virtualWalletRepository.getBalance(walletId);
    }
    
    public void debit(Long walletId, BigDecimal amount) {
        VirtualWalletEntity walletEntity = this.virtualWalletRepository.getVirtualWallet(walletId);
        BigDecimal balance = walletEntity.getBalance();
        if (balance.compareTo(amount) < 0) {
            throw new RuntimeException("金额小于要借出的金额");
        }
        virtualWalletRepository.updateBalance(walletId, balance.subtract(amount));
    }
    
    public void credit(Long walletId, BigDecimal amount) {
        VirtualWalletEntity walletEntity = this.virtualWalletRepository.getVirtualWallet(walletId);
        BigDecimal balance = walletEntity.getBalance();
        virtualWalletRepository.updateBalance(walletId, balance.add(amount));
    }
    
    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
        VirtualWalletTransactionEntity transactionEntity = new VirtualWalletTransactionEntity();
        transactionEntity.setAmount(amount);
        transactionEntity.setCreateTime(System.currentTimeMillis());
        transactionEntity.setFromWalletId(fromWalletId);
        transactionEntity.setToWalletId(toWalletId);
        transactionEntity.setStatus(Status.TO_BE_EXECUTED.getVal());
        Long trasactionId = virtualWalletTransactionRepository.saveTransaction(transactionEntity);
        try {
            debit(fromWalletId, amount);
            credit(toWalletId, amount);
        } catch (Exception e) {
            virtualWalletTransactionRepository.updateStatus(trasactionId, Status.EXECUTED_FAILED.getVal());
            throw new RuntimeException("转账出现异常");
        }
        virtualWalletTransactionRepository.updateStatus(trasactionId, Status.EXECUTED_SUCCESS.getVal());
        
    }

}
