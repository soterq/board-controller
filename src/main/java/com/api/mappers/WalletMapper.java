package com.api.mappers;

import com.api.domain.Wallet;
import com.api.domain.dto.WalletDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface WalletMapper {

    Wallet fromDto(WalletDTO walletDto);

    WalletDTO toDto(Wallet Wallet);
}
