package com.bank.exceptions;

public class UnsupportedInteger extends Exception {

	private static final long serialVersionUID = -8281091033194960111L;

	public UnsupportedInteger() {
		super();
	}

	public UnsupportedInteger(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public UnsupportedInteger(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UnsupportedInteger(String arg0) {
		super(arg0);
	}

	public UnsupportedInteger(Throwable arg0) {
		super(arg0);
	}

}
