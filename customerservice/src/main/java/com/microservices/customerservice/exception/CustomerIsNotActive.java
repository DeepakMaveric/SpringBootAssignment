package com.microservices.customerservice.exception;

public class CustomerIsNotActive extends RuntimeException{
    public CustomerIsNotActive(String message){
        super(message);
    }
}
