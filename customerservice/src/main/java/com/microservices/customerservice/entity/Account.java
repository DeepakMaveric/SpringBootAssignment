package com.microservices.customerservice.entity;


import lombok.Data;

import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Data
@Component
public class Account {

    //@Id
    private int accountid;

    private Long custid;

    //@NotNull
    private AccountType accounttype;

    private LocalDate accountcreationdate;

    //@Min(1000)
    private Double accountbal;

    public Account(){

    }


}
