package com.microservices.customerservice.service;

import com.microservices.customerservice.entity.Account;
import com.microservices.customerservice.entity.AccountType;
import com.microservices.customerservice.entity.Customer;
import com.microservices.customerservice.exception.CustomerIsNotActive;
import com.microservices.customerservice.exception.CustomerNotFoundException;
import com.microservices.customerservice.exception.DataIntegrityViolationException;
import com.microservices.customerservice.feign.AccountFeignClient;
import com.microservices.customerservice.repository.AddressRepository;
import com.microservices.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    AccountFeignClient accountFeignClient;

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
        Optional<Customer> cust = customerRepo.findById(id);
        if (cust.isPresent()){
            return cust.get();
        }
        else
            throw new CustomerNotFoundException("Customer not found. Please check customer id");

    }

    @Override
    public String deleteCustomer(Long id) {
        Customer cust = customerRepo.getById(id);
        if (Objects.isNull(cust))
            throw new CustomerNotFoundException("Customer not found. Please check customer id.");
        else {
            cust.setIsactive(false);
            customerRepo.save(cust);
            return "Customer successfully deleted.";
        }
    }

    @Override
    public String addAccount(Account account) {
        Customer customer = customerRepo.getById(account.getCustid());
        if(customer.isIsactive()){
            accountFeignClient.addAccount(account);
            return "Account successfully added!";
        }
        else
            throw new CustomerIsNotActive("Customer is inactive.");

    }
}

