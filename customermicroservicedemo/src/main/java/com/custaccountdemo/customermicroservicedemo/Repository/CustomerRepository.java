package com.custaccountdemo.customermicroservicedemo.Repository;

import com.custaccountdemo.customermicroservicedemo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
