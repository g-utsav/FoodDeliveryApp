package com.foodDelivery.exceptions;

public class MultipleRestaurantFoundException extends Exception{

	public MultipleRestaurantFoundException() {
		super();
	}
	
	public MultipleRestaurantFoundException(String msg) {
		super(msg);
	}
	
}