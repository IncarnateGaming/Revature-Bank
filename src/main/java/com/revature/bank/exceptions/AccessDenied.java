package com.revature.bank.exceptions;

public class AccessDenied extends Exception {

	private static final long serialVersionUID = 5848792536201162615L;

	public AccessDenied() {
		super();
	}

	public AccessDenied(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AccessDenied(String message, Throwable cause) {
		super(message, cause);
	}

	public AccessDenied(String message) {
		super(message);
	}

	public AccessDenied(Throwable cause) {
		super(cause);
	}
	
}
