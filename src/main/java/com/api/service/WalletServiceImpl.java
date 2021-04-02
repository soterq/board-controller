package com.api.service;

import com.api.domain.Wallet;
import com.api.repository.WalletRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;


    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
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
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            wallet.setCreationDate(formatter.format(date));
        return wallet;
    }

    @Override
    public void deleteWallet(Long id) {
        walletRepository.deleteById(id);
    }
}
