package com.foodDelivery.exceptions;

public class NoRestaurantFoundException extends Exception{

	public NoRestaurantFoundException() {
		super();
	}
	
	public NoRestaurantFoundException(String msg) {
		super(msg);
	}
	
}