package com.revature.bank.exceptions;

public class InsufficientLineOfCredit extends Exception {
	private static final long serialVersionUID = -4187690089339700140L;

	public InsufficientLineOfCredit() {
		super();
	}

	public InsufficientLineOfCredit(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InsufficientLineOfCredit(String message, Throwable cause) {
		super(message, cause);
	}

	public InsufficientLineOfCredit(String message) {
		super(message);
	}

	public InsufficientLineOfCredit(Throwable cause) {
		super(cause);
	}
}
