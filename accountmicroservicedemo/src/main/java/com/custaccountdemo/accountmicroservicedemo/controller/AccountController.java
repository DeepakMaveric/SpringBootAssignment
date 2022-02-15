package com.custaccountdemo.accountmicroservicedemo.controller;

import com.custaccountdemo.accountmicroservicedemo.model.Account;
import com.custaccountdemo.accountmicroservicedemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "http://localhost:8020")
public class AccountController {

    @Autowired
    AccountService accountService;



    @PostMapping("/new")
    public ResponseEntity<Account>addNewAccount(@RequestBody Account account){
        return new ResponseEntity<Account>(accountService.addAccount(account), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Account>>  getAllAccounts(){
        return new ResponseEntity<List<Account>> (accountService.getAllAccounts(),HttpStatus.OK);
    }

    @GetMapping(value = "custid/{id}")
    public ResponseEntity<Account> getAccountForCust (@PathVariable("id") Long id){
        return new ResponseEntity<Account>(accountService.getAccountByCustid(id).get(0),HttpStatus.OK);
    }

}
