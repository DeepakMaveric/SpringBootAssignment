package com.custaccountdemo.customermicroservicedemo.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerAccountDetails {
   public Customer customer;
   public Account account;
}
