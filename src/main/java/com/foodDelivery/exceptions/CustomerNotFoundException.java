package com.foodDelivery.exceptions;

public class CustomerNotFoundException extends Exception{

    public CustomerNotFoundException() {
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }
}