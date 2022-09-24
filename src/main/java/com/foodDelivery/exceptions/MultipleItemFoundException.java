package com.foodDelivery.exceptions;

public class MultipleItemFoundException extends Exception {

	public MultipleItemFoundException() {

	}

	public MultipleItemFoundException(String message) {
		super(message);

	}

	public MultipleItemFoundException(Throwable cause) {
		super(cause);

	}

	public MultipleItemFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public MultipleItemFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
