package com.microservices.accountservice.service;

import com.microservices.accountservice.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    public Account addAccount(Account account);
    public List<Account> getAllAccounts();
    public List<Account> getAccountByCustid(Long id);
}
