package com.revature.bank.exceptions;

public class InsufficientFunds extends InsufficientLineOfCredit {
	private static final long serialVersionUID = -5564261331670605699L;

	public InsufficientFunds() {
		super();
	}

	public InsufficientFunds(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InsufficientFunds(String message, Throwable cause) {
		super(message, cause);
	}

	public InsufficientFunds(String message) {
		super(message);
	}

	public InsufficientFunds(Throwable cause) {
		super(cause);
	}
	
}
