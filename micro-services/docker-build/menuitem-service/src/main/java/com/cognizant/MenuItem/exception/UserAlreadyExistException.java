package com.cognizant.MenuItem.exception;

public class UserAlreadyExistException extends RuntimeException {
	String message = null;

	public UserAlreadyExistException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
