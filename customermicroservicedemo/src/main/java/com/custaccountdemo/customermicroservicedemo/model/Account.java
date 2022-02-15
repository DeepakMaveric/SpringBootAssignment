package com.custaccountdemo.customermicroservicedemo.model;

import lombok.Data;
import org.springframework.stereotype.Component;



@Data
public class Account {
    public String accountnum;
    //public long custid;
    public String accounttype;
    public long accountbal;

    public Account(){

    }
}
