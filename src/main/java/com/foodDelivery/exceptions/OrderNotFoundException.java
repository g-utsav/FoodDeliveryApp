package com.foodDelivery.exceptions;

public class OrderNotFoundException extends Exception{

    public OrderNotFoundException() {
    }

    public OrderNotFoundException(String message) {
        super(message);
    }
}