package com.microservices.customerservice.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Component
public class CustomerRequest {


    @NotBlank(message = "Customer name is mandatory.")
    private String custname;

    @Min(value=18, message="Minimum age 18 is required")
    private int custage;

    @NotBlank(message = "Email Id is mandatory.")
    @Column(unique = true)
    //@Pattern(regexp = "\^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$\"")
    private String custemail;

    @NotBlank(message = "Mobile number is mandatory.")
    private String custmob;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private boolean isactive;

    private long pincode;

    private String street;

    private String city;

    private String country;
}
