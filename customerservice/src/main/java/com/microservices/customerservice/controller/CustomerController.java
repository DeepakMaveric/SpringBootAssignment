package com.microservices.customerservice.controller;

import com.microservices.customerservice.entity.*;
import com.microservices.customerservice.exception.CustomerNotFoundException;
import com.microservices.customerservice.feign.AccountFeignClient;
import com.microservices.customerservice.repository.AddressRepository;
import com.microservices.customerservice.repository.CustomerRepository;
import com.microservices.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    AddressRepository addressRepo;

    @Autowired
    AccountFeignClient accountFeignClient;

    @PostMapping("/new")
    public ResponseEntity<Customer> addCustomer(@Valid @RequestBody CustomerRequest custreq){
        Address address = new Address();
        address.setPincode(custreq.getPincode());
        address.setStreet(custreq.getStreet());
        address.setCity(custreq.getCity());
        address.setCountry(custreq.getCountry());
        addressRepo.save(address);
        Customer customer = new Customer();
        customer.setAddress(address);
        customer.setCustname(custreq.getCustname());
        customer.setCustage(custreq.getCustage());
        customer.setCustemail(custreq.getCustemail());
        customer.setCustmob(custreq.getCustmob());
        customer.setGender(custreq.getGender());
        customer.setIsactive(custreq.isIsactive());
        Customer newcustomer = customerService.addCustomer(customer);
        Account  defaultaccount = new Account();
        defaultaccount.setAccounttype(AccountType.CASH);
        defaultaccount.setAccountbal(1000.00);
        defaultaccount.setCustid(newcustomer.getCustid());
        accountFeignClient.addAccount(defaultaccount);
        return new ResponseEntity<Customer>(newcustomer, HttpStatus.CREATED);
    }

    @PostMapping("/addaccount")
    public ResponseEntity<String> addAccount(@Valid @RequestBody Account account){
        Customer customer = customerService.getCustomerById(account.getCustid());
        if(Objects.isNull(customer))
            //return new ResponseEntity<String>("Customer doesn't exists!",HttpStatus.BAD_REQUEST);
            throw new CustomerNotFoundException("Customer not found. Please check customer id");
        else
            return new ResponseEntity<String>(customerService.addAccount(account),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerAccountRequest> getCustomerAccountInfo (@PathVariable("id") Long id){
        CustomerAccountRequest customerAccountRequest = new CustomerAccountRequest();
        Customer customer = customerService.getCustomerById(id);
        customerAccountRequest.setCustomer(customer);
        List<Account> accountList = accountFeignClient.getIds(id);
        customerAccountRequest.setAccountList(accountList);
        return new ResponseEntity<CustomerAccountRequest>(customerAccountRequest,HttpStatus.OK);
    }



    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCustById(@PathVariable("id") Long id){
        return new ResponseEntity<String>(customerService.deleteCustomer(id),HttpStatus.OK);
    }
}
