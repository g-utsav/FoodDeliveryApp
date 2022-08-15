package com.foodDelivery.exceptions;

public class OrderCompletedException extends Exception{

    public OrderCompletedException() {
    }

    public OrderCompletedException(String message) {
        super(message);
    }
}