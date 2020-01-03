package com.cognizant.MenuItem.exception;

public class CartEmptyException extends RuntimeException {

	String message = null;

	public CartEmptyException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
