package com.api.service;

import com.api.domain.Wallet;

import java.util.List;

public interface WalletService {
    Wallet findWalletById(Long id);

    List<Wallet> findAllWallets();

    Wallet saveWallet(Wallet wallet);

    void deleteWallet(Long id);
}
