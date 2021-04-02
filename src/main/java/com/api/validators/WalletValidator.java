package com.api.validators;

import com.api.domain.dto.WalletDTO;
import com.api.enums.Currency;
import com.api.response.WalletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;

public class WalletValidator {

    public boolean supports(Class<?> aClass) {
        return WalletValidator.class.equals(aClass);
    }


    public WalletResponse validate(Object target, Errors errors) {
        WalletDTO walletDto = (WalletDTO) target;
        WalletResponse walletResponse = new WalletResponse();
        if( StringUtils.isBlank(walletDto.getName())){
            errors.rejectValue("name","field required","Error : Wallet name is required and cannot be empty ");
        }
        if( StringUtils.isBlank(walletDto.getCurrency()) ){
            errors.rejectValue("name","field required","Error : Invalid  currency is required and cannot be empty ");
        }else if(!Currency.isValid(walletDto.getCurrency())){
            errors.rejectValue("name","field required","Error : Non-existing currency pleas check acceptable values ");
        }
        if(walletDto.getAmount()== null){
            walletDto.setAmount(0);
        }
        if( StringUtils.isBlank(walletDto.getOwner())) {
            walletDto.setOwner("Guest");
        }
        return walletResponse;
    }
}
