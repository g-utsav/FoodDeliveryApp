package com.foodDelivery.exceptions;

public class OrderDetailsException extends RuntimeException{

	
	public OrderDetailsException (){
		super();
	}
	
	public OrderDetailsException (String msg){
		super(msg);
	}
}
