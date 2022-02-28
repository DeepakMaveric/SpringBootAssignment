package com.microservices.customerservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "addressdetails")
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String street;

    private String city;

    private long pincode;

    private String country;

  /* @OneToOne
   @JoinColumn(name = "cust_id")
    private Customer customer;*/

}
