package com.foodDelivery.exceptions;

public class ItemAlreadyPresentException extends Exception {

	public ItemAlreadyPresentException() {

	}

	public ItemAlreadyPresentException(String message) {
		super(message);

	}

	public ItemAlreadyPresentException(Throwable cause) {
		super(cause);

	}

	public ItemAlreadyPresentException(String message, Throwable cause) {
		super(message, cause);

	}

	public ItemAlreadyPresentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
