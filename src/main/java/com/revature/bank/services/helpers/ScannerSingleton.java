package com.revature.bank.services.helpers;

import java.util.Scanner;

public class ScannerSingleton {
	private static Scanner s;
	private ScannerSingleton() {
	}
	public static Scanner getScanner() {
		if (s== null) {
			s = new Scanner(System.in);
		}
		return s;
	}
}
