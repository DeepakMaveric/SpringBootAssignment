package com.microservices.customerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "customerdetails")
@Data
@NoArgsConstructor

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long custid;

    private String custname;

    private int custage;


    private Gender gender;

    @Column(unique = true)
    private String custemail;

    private String custmob;

    private boolean isactive;

   @OneToOne
   @JoinColumn(name = "addid")
    private Address address;


}
