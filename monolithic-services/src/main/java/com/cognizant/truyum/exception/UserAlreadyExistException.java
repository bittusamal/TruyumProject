package com.cognizant.truyum.exception;

public class UserAlreadyExistException extends RuntimeException {
	String message = null;

	public UserAlreadyExistException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
