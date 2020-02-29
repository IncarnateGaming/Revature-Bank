package com.revature.bank.exceptions;

public class ForceCloseThread extends Exception {

	private static final long serialVersionUID = 9126297415395736849L;

	public ForceCloseThread() {
		super();
	}

	public ForceCloseThread(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ForceCloseThread(String message, Throwable cause) {
		super(message, cause);
	}

	public ForceCloseThread(String message) {
		super(message);
	}

	public ForceCloseThread(Throwable cause) {
		super(cause);
	}

}
