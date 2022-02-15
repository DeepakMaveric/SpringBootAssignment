package com.custaccountdemo.accountmicroservicedemo.repository;

import com.custaccountdemo.accountmicroservicedemo.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Component
public interface AccountRepo extends MongoRepository<Account,String> {
    @Query("{custid:?0}")
    List<Account> findAccountbyCustid (Long id);

}