package com.foodDelivery.exceptions;

public class CartNotFoundException extends Exception{
    public CartNotFoundException() {
    }

    public CartNotFoundException(String message) {
        super(message);
    }
}
