package com.foodDelivery.exceptions;

public class ItemException extends RuntimeException {

	public ItemException() {
	
	}

	public ItemException(String message) {
		super(message);
	}

	public ItemException(Throwable cause) {
		super(cause);
	}

	public ItemException(String message, Throwable cause) {
		super(message, cause);
	}

	public ItemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
