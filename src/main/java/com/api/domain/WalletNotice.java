package com.api.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
public class WalletNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String note;
    private String date;
    @ManyToOne
    @JoinColumn(name = "wallet_id",referencedColumnName = "id")
    @EqualsAndHashCode.Exclude private Wallet wallet;


    public WalletNotice() {
    }

    public WalletNotice(String note) {
        this.note = note;
    }
}
