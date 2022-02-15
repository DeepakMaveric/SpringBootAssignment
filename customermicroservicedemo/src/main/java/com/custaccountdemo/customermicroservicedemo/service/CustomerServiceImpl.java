package com.custaccountdemo.customermicroservicedemo.service;

import com.custaccountdemo.customermicroservicedemo.Repository.CustomerRepository;
import com.custaccountdemo.customermicroservicedemo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepo;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepo.findById(id).get();
    }
}
