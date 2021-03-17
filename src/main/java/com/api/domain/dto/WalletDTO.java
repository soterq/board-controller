package com.api.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class WalletDTO {
    private Long id;
    private String name;
    private String currency;
    private Integer amount;
    List<WalletNoticeDTO> noticeList = new ArrayList<>();
}
