package com.microservices.accountservice.entity;


import lombok.Data;

@Data
public class TransactionRequest {

    //int transactionid;
    public TransactionType transactiontype;
    public Double amount;
}
