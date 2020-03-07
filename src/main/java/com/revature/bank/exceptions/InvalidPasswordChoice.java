package com.revature.bank.exceptions;

public class InvalidPasswordChoice extends Exception {

	private static final long serialVersionUID = 5349791584936491726L;

	public InvalidPasswordChoice() {
		super();
	}

	public InvalidPasswordChoice(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public InvalidPasswordChoice(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public InvalidPasswordChoice(String arg0) {
		super(arg0);
	}

	public InvalidPasswordChoice(Throwable arg0) {
		super(arg0);
	}

}
