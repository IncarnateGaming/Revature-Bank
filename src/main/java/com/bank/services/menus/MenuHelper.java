package com.bank.services.menus;

import java.util.Scanner;

import com.bank.Application;

public class MenuHelper {
	private MenuHelper() {
		throw new IllegalStateException("Utility class");
	}
	public static int inputPositiveInt(Scanner s) {
		int val = 0;
		do {
			try {
				if( val < 0) {
					System.out.println("Value must be positive:");
				}
				val = Integer.parseInt(s.nextLine().split(" ")[0]);
			}catch(NumberFormatException e) {
				Application.getLogger().warn("Non-number submitted by user",e);
				val = -1;
			}
		}
		while(val < 0);
		return val;
	}
	public static int inputInt(Scanner s) {
		int val = -168259;
		do {
			try {
				if( val == -168259) {
					System.out.println("Value must be a valid integer:");
				}
				val = Integer.parseInt(s.nextLine().split(" ")[0]);
			}catch(NumberFormatException e) {
				Application.getLogger().warn(e.getStackTrace());
				Application.getLogger().warn("Non-number submitted by user",e);
				val = -168259;
			}
		}
		while(val == -168259);
		return val;
	}
	public static String inputStringOneWord(Scanner s) {
		String val;
		String result;
		val = s.nextLine().split(" ")[0];
		result = val.replaceAll("[^a-zA-Z]+", "");
		return result;
	}
}
