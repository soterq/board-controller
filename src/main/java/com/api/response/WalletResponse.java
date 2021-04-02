package com.api.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class WalletResponse {
//    List<String> WalletsId = new ArrayList<>();
//    List<String> successfulWallets = new ArrayList<>();
    String WalletsId ;
    String successfulWallet;
    HashMap<String , List<String>> errorMap = new HashMap<>();
    Boolean isSuccess;
    int errorStatus;

    @JsonIgnore
    public boolean isSuccessful(){
        return errorMap.size()<=0 && isSuccess;
    }

}
