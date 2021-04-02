package com.api.domain;

import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@CrossOrigin
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String currency;
    private Integer amount;
    private String description;
    private String creationDate;
    private String owner;//login to user

    @OneToMany(cascade = CascadeType.ALL)
    List<Operation> operations = new ArrayList<>();
    public Wallet() {

    }

    public Wallet(String name, String currency, Integer amount) {

    }


}
