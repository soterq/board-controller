package com.api.bootStrapData;

import com.api.domain.WalletNotice;
import com.api.domain.Wallet;
import com.api.repository.WalletRepository;
import org.springframework.boot.CommandLineRunner;

public class BootStrapData implements CommandLineRunner {
    private final WalletRepository walletRepository;

    public BootStrapData(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Wallet wallet = new Wallet("Test","MDL", 2000);
        WalletNotice notice = new WalletNotice("Test Notice");
        wallet.getNoticeList().add(notice);

        walletRepository.save(wallet);
    }
}
