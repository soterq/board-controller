package com.api.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity

public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String currency;
    private Integer amount;
    @OneToMany(cascade = CascadeType.ALL)
    List<WalletNotice> noticeList = new ArrayList<>();

    public Wallet() {

    }

    public Wallet(String name, String currency, Integer amount) {

    }

    public Wallet(String name, String currency, Integer amount, List<WalletNotice> noticeList) {
        this.name = name;
        this.currency = currency;
        this.amount = amount;
        this.noticeList = noticeList;
    }
}
