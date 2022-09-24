package com.foodDelivery.exceptions;

public class CartItemNotFoundException extends Exception{
    public CartItemNotFoundException() {
    }

    public CartItemNotFoundException(String message) {
        super(message);
    }
}
