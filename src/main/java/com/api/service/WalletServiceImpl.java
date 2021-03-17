package com.api.service;

import com.api.domain.WalletNotice;
import com.api.domain.Wallet;
import com.api.repository.NoticeRepository;
import com.api.repository.WalletRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;
    private final NoticeRepository noticeRepository;


    public WalletServiceImpl(WalletRepository walletRepository, NoticeRepository noticeRepository) {
        this.walletRepository = walletRepository;
        this.noticeRepository = noticeRepository;
    }

    @Override
    public Wallet findWalletById(Long id) {
        return walletRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Wallet with id " + id + " not found"));
    }

    @Override
    public List<Wallet> findAllWallets() {
        return walletRepository.findAll();
    }

    @Override
    public Wallet saveWallet(Wallet wallet) {
        wallet = walletRepository.save(wallet);
        for (WalletNotice notice : wallet.getNoticeList()) {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            notice.setDate(formatter.format(date));
            notice.setWallet(wallet);
            noticeRepository.save(notice);
        }
        return wallet;
    }

    @Override
    public void deleteWallet(Long id) {
        walletRepository.deleteById(id);
    }
}
