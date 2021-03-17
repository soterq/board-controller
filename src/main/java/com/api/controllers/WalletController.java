package com.api.controllers;

import com.api.domain.Wallet;
import com.api.domain.dto.WalletDTO;
import com.api.mappers.WalletMapper;
import com.api.service.WalletService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WalletController.BASE_URL)
@CrossOrigin
public class WalletController {
    public static final String BASE_URL = "/api/v1/wallets";
    private final WalletService walletService;
    private final WalletMapper walletMapper;

    public WalletController(WalletService walletService, WalletMapper walletMapper) {
        this.walletService = walletService;
        this.walletMapper = walletMapper;
    }


    @GetMapping
    public List<WalletDTO> getAllWallets() {
//        List<WalletDTO> wallets = new ArrayList<>();
//        for (Wallet wallet : walletService.findAllWallets()) {
//            wallets.add(walletMapper.toDto(wallet));
//        }
        List<WalletDTO> collect = walletService.findAllWallets().stream()
                .map(walletMapper::toDto)
                .collect(Collectors.toList());
        return collect;
    }

    @GetMapping(path = "/{id}")
    public WalletDTO getWalletById(@PathVariable("id") Long id) {
        return walletMapper.toDto(walletService.findWalletById(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('user:add')")
    public WalletDTO createWallet(@RequestBody WalletDTO walletDto) {
        return walletMapper.toDto(walletService.saveWallet(walletService.saveWallet(walletMapper.fromDto(walletDto))));
    }

    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('user:remove')")
    public void deleteWallet(@PathVariable Long id) {
        walletService.deleteWallet(id);

    }
}
