package com.custaccountdemo.accountmicroservicedemo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;


@Document(collection = "accountdetails")
@Data
@Component
public class Account {
    public String accountnum;
    public long custid;
    public String accounttype;
    public long accountbal;

    public Account(){

    }
}
