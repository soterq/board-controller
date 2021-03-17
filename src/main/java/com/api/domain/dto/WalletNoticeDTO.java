package com.api.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WalletNoticeDTO {
    private Long id;
    private String note;
    private String date;
}
