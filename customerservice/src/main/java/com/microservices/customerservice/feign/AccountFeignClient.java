package com.microservices.customerservice.feign;

import com.microservices.customerservice.entity.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "ACCOUNTSERVICE",fallbackFactory = HystrixFallBackFactory.class)
public interface AccountFeignClient {

    @GetMapping(value = "/accounts/custid/{id}")
    List<Account> getIds(@PathVariable Long id);

    @PostMapping(value = "/accounts/account")
    String addAccount(Account account);


}

