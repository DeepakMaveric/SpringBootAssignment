package com.microservices.customerservice.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CustomerAccountRequest {
   public Customer customer;
   public List<Account> accountList;
}
