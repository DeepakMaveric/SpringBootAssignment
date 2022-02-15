package com.custaccountdemo.customermicroservicedemo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customerdetails")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long custid;

    @Column(name = "cust_name", nullable = false)
    public String custname;

    @Column(name = "cust_add")
    public String custadd;

    public Customer(){

    }
}
