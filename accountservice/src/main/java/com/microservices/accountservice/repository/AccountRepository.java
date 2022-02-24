package com.microservices.accountservice.repository;

import com.microservices.accountservice.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface AccountRepository extends MongoRepository<Account,String> {

    List<Account> findByCustid (Long custid);
}
