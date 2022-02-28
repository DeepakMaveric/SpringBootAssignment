package com.microservices.accountservice.service;

import com.microservices.accountservice.entity.Account;
import com.microservices.accountservice.entity.TransactionRequest;

import java.util.List;

public interface AccountService {
    public Account addAccount(Account account);
    public List<Account> getAllAccounts();
    public List<Account> getAccountByCustid(Long id);
    public String addWithdrawMoney(int accountid, TransactionRequest transactionRequest);
}
