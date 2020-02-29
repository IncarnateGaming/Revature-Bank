package com.revature.bank.exceptions;

public class ReturnMainMenu extends Exception {
	private static final long serialVersionUID = -5925962126837143136L;
	public ReturnMainMenu() {
		super();
	}
	public ReturnMainMenu(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public ReturnMainMenu(String message, Throwable cause) {
		super(message, cause);
	}
	public ReturnMainMenu(String message) {
		super(message);
	}
	public ReturnMainMenu(Throwable cause) {
		super(cause);
	}
}
