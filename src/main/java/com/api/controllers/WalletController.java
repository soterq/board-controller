package com.api.controllers;

import com.api.domain.Wallet;
import com.api.domain.dto.WalletDTO;
import com.api.mappers.WalletMapper;
import com.api.response.WalletResponse;
import com.api.service.WalletService;
import com.api.validators.WalletValidator;
import org.apache.commons.lang3.StringUtils;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WalletController.BASE_URL)
@CrossOrigin
public class WalletController {
    public static final String BASE_URL = "/api/v1/wallets";
    private final WalletService walletService;
    private final WalletMapper walletMapper;
    private static final int errorCode =601;
    private static final int successCode =200;

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
//    @PreAuthorize("hasAuthority('user:add')")
    public WalletResponse createWallet(@RequestBody WalletDTO walletDto) {
//    public WalletDTO createWallet(@RequestBody WalletDTO walletDto) {
        WalletResponse walletResponse= new WalletResponse();
        String successWallet = walletResponse.getSuccessfulWallet();
        HashMap<String,List<String>> errorMap = walletResponse.getErrorMap();
        BeanPropertyBindingResult walletError = new BeanPropertyBindingResult(walletDto,"createWallet");
        WalletValidator walletValidator = new WalletValidator();
        walletValidator.validate(walletDto,walletError);

        if(walletError.getAllErrors().size()>0){
          List<String> walletErrorList = new ArrayList<>();
            for (ObjectError error: walletError.getAllErrors()) {
                walletErrorList.add(error.getDefaultMessage());
            }
            if(walletErrorList.size()>0){
                errorMap.put(walletDto.getName(),walletErrorList);
            }
        }else {
            successWallet=walletDto.getName();
        }

        if(walletResponse.getErrorMap().size()>0){
            walletResponse.setIsSuccess(false);
            walletResponse.setErrorStatus(errorCode);
            walletResponse.setSuccessfulWallet(null);
        }else {
            walletResponse.setIsSuccess(true);
            walletResponse.setErrorStatus(successCode);
            walletMapper.toDto(walletService.saveWallet(walletService.saveWallet(walletMapper.fromDto(walletDto))));
        }
        return walletResponse;

    }

    @DeleteMapping(path = "/{id}")
//    @PreAuthorize("hasAuthority('user:remove')")
    public void deleteWallet(@PathVariable Long id) {
        walletService.deleteWallet(id);

    }
}
