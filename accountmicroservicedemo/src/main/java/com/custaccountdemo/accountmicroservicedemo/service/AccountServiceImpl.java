package com.custaccountdemo.accountmicroservicedemo.service;

import com.custaccountdemo.accountmicroservicedemo.model.Account;
import com.custaccountdemo.accountmicroservicedemo.repository.AccountRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepo accountRepo;

    @Override
    public Account addAccount(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }

    @Override
    public List<Account> getAccountByCustid(Long id) {

        return accountRepo.findAccountbyCustid(id);

    }
}
