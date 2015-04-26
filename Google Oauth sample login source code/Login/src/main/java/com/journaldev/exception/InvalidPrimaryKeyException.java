package com.journaldev.exception;

public class InvalidPrimaryKeyException extends RuntimeException {
	
	
	
	public InvalidPrimaryKeyException() {
		super("Client ID should Greater than ZERO");
	}
	

}
