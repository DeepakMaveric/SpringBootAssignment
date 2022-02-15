package com.custaccountdemo.customermicroservicedemo.service;

import com.custaccountdemo.customermicroservicedemo.model.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getAllCustomers();
    public Customer addCustomer(Customer customer);
    public Customer getCustomerById(Long id);
}
