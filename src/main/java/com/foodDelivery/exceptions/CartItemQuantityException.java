package com.foodDelivery.exceptions;

public class CartItemQuantityException extends Exception{
    public CartItemQuantityException() {
    }

    public CartItemQuantityException(String message) {
        super(message);
    }
}
