package com.foodDelivery.exceptions;

public class InvalidURIException extends RuntimeException{
	
	public InvalidURIException() {
	}
	
	public InvalidURIException(String message) {
		
	super(message);
	
	}

}
