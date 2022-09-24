package com.foodDelivery.exceptions;

public class InvalidUserNameOrPassword extends Exception {

	public InvalidUserNameOrPassword() {
		super();
	}
	
	public InvalidUserNameOrPassword(String msg) {
		super(msg);
	}
}
