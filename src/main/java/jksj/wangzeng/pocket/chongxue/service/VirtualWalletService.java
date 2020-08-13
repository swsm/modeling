package jksj.wangzeng.pocket.chongxue.service;

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

    public VirtualWallet getVirtualWallet(Long walletId) {
        VirtualWalletEntity virtualWalletEntity = this.virtualWalletRepository.getVirtualWallet(walletId);
        VirtualWallet virtualWallet = convert(virtualWalletEntity);
        return virtualWallet;
    }

    private VirtualWallet convert(VirtualWalletEntity virtualWalletEntity) {
        return new VirtualWallet(virtualWalletEntity.getId());
    }


    public BigDecimal getBalance(Long walletId) {
        return virtualWalletRepository.getBalance(walletId);
    }

    public void debit(Long walletId, BigDecimal amount) {
        VirtualWalletEntity walletEntity = this.virtualWalletRepository.getVirtualWallet(walletId);
        VirtualWallet wallet = convert(walletEntity);
        wallet.debit(amount);
        virtualWalletRepository.updateBalance(walletId, wallet.balance());
    }

    public void credit(Long walletId, BigDecimal amount) {
        VirtualWalletEntity walletEntity = this.virtualWalletRepository.getVirtualWallet(walletId);
        VirtualWallet wallet = convert(walletEntity);
        wallet.credit(amount);
        virtualWalletRepository.updateBalance(walletId, wallet.balance());
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
