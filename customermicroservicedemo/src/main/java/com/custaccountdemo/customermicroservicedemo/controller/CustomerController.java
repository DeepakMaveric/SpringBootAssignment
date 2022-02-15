package com.custaccountdemo.customermicroservicedemo.controller;

import com.custaccountdemo.customermicroservicedemo.model.Account;
import com.custaccountdemo.customermicroservicedemo.model.Customer;
import com.custaccountdemo.customermicroservicedemo.model.CustomerAccountDetails;
import com.custaccountdemo.customermicroservicedemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    RestTemplate restTemplate;



    @PostMapping("/new")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(),HttpStatus.OK);
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<CustomerAccountDetails> getCustomerAccountInfo (@PathVariable("id") Long id){
        CustomerAccountDetails customerAccountDetails = new CustomerAccountDetails();
        Customer customer = customerService.getCustomerById(id);
        customerAccountDetails.setCustomer(customer);
        Account account = restTemplate.getForObject("http://localhost:8020/account/custid/"+ Long.toString(id),Account.class);
        customerAccountDetails.setAccount(account);
        return new ResponseEntity<CustomerAccountDetails>(customerAccountDetails,HttpStatus.OK);
    }
}
