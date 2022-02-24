package com.microservices.accountservice.service;

import com.microservices.accountservice.entity.Account;
import com.microservices.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account addAccount(Account account) {
       return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> getAccountByCustid(Long custid) {

        List<Account> accountList   = accountRepository.findByCustid(custid);
        return accountList;

    }
}
