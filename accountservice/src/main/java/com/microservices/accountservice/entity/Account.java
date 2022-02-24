package com.microservices.accountservice.entity;


import lombok.Data;
import org.apache.tomcat.jni.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Document(collection = "account_details")
@Data
@Component
public class Account {

    @Transient
    public static final String sequencename="account_sequence";

    @Id
    private int accountid;

    private Long custid;

    @NotNull
    private AccountType accounttype;

    private LocalDate accountcreationdate = LocalDate.now();

    @Min(1000)
    private Double accountbal;

    public Account(){

    }


}
