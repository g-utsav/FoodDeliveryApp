package com.foodDelivery.exceptions;

public class UserAccessNotGrantedException extends Exception {

	public UserAccessNotGrantedException() {
		super();
	}
	
	public UserAccessNotGrantedException(String msg) {
		super(msg);
	}
	
}
