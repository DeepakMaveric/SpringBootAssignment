package com.microservices.accountservice.service;

import com.microservices.accountservice.entity.Account;
import com.microservices.accountservice.entity.TransactionRequest;
import com.microservices.accountservice.entity.TransactionType;
import com.microservices.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public String addWithdrawMoney(int accountid, TransactionRequest transactionRequest) {
        Optional<Account> account = accountRepository.findByAccountid(accountid);
        if(account.isPresent()) {
            Double accountbal = account.get().getAccountbal();
            if (TransactionType.DEPOSIT == transactionRequest.getTransactiontype()) {
                Double newbal = accountbal + transactionRequest.getAmount();
                account.get().setAccountbal(newbal);
                accountRepository.save(account.get());
                return "Transaction Successful";
            }
            else if (TransactionType.WITHDRAW == transactionRequest.getTransactiontype()) {
                Double newbal = accountbal - transactionRequest.getAmount();
                account.get().setAccountbal(newbal);
                accountRepository.save(account.get());
                return "Transaction Successful";
            }
            else
                return "Invalid";
        }
        else
            return "Account doesn't exits. Please check account Id.";


        }
    }

