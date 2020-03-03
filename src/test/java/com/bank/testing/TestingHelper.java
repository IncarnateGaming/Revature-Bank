package com.bank.testing;

import java.io.ByteArrayInputStream;

public class TestingHelper {
	private TestingHelper() {
	}
	public static void changeBuffer(String s) {
		System.setIn(new ByteArrayInputStream(s.getBytes()));
	}
}
