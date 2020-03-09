package com.revature.bank.exceptions;

public class InvalidNegativeValue extends Exception{
	private static final long serialVersionUID = 4721941701359422455L;

	public InvalidNegativeValue() {
		super();
	}

	public InvalidNegativeValue(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public InvalidNegativeValue(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public InvalidNegativeValue(String arg0) {
		super(arg0);
	}

	public InvalidNegativeValue(Throwable arg0) {
		super(arg0);
	}
}
