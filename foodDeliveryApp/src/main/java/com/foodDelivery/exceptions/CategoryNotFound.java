package com.foodDelivery.exceptions;

public class CategoryNotFound extends Exception {

	public CategoryNotFound() {

	}

	public CategoryNotFound(String message) {
		super(message);

	}

	public CategoryNotFound(Throwable cause) {
		super(cause);

	}

	public CategoryNotFound(String message, Throwable cause) {
		super(message, cause);

	}

	public CategoryNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
