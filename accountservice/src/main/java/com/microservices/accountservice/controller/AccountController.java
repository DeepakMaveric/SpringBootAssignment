package com.microservices.accountservice.controller;

import com.microservices.accountservice.entity.Account;
import com.microservices.accountservice.entity.TransactionRequest;
import com.microservices.accountservice.service.AccountService;
import com.microservices.accountservice.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins = "http://localhost:8044")
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @PostMapping("/account")
    public ResponseEntity<Account> addNewAccount(@Valid @RequestBody Account account){
        account.setAccountid(sequenceGeneratorService.getSequenceNumber(Account.sequencename));
        return new ResponseEntity<Account>(accountService.addAccount(account), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts(){
        return new ResponseEntity<List<Account>> (accountService.getAllAccounts(),HttpStatus.OK);
    }

  @GetMapping(value = "custid/{id}")
    public ResponseEntity<List<Account>> getAccountForCust (@PathVariable("id") Long id){
        return new ResponseEntity<List<Account>>(accountService.getAccountByCustid(id),HttpStatus.OK);
    }

    @PutMapping(value = "{accountid}")
    public ResponseEntity<String> addWithdrawMoney (@PathVariable("accountid") int accountid,
                                                @RequestBody TransactionRequest transactionRequest){
        return new ResponseEntity<String>(accountService.addWithdrawMoney(accountid,transactionRequest),HttpStatus.OK);
    }

}

