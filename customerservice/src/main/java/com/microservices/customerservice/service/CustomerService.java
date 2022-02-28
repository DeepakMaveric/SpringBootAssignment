package com.microservices.customerservice.service;

import com.microservices.customerservice.entity.Account;
import com.microservices.customerservice.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getAllCustomers();
    public Customer addCustomer(Customer customer);
    public Customer getCustomerById(Long id);
    public String deleteCustomer(Long id);
    public String addAccount(Account account);
    public String addMoney(Double money);

}
