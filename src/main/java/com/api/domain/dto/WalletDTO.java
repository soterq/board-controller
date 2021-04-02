package com.api.domain.dto;

import com.api.domain.Operation;
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
    private String owner;//login to user
    private String description;
    private String creationDate;
    List<Operation> operations = new ArrayList<>();
}
