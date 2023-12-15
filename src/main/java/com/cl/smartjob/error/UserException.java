package com.cl.smartjob.error;

public class UserException extends Exception {

	private static final long serialVersionUID = 1L;

	private final String message;

	public UserException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	
}
