package com.bank.testing;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class TestingHelper {
	private TestingHelper() {
	}
	public static Scanner changeBuffer(String s) {
		System.setIn(new ByteArrayInputStream(s.getBytes()));
		return new Scanner(System.in);
	}
}
