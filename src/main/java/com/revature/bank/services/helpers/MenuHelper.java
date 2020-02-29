package com.revature.bank.services.helpers;

import java.util.Scanner;

import com.revature.bank.Application;
import com.revature.bank.exceptions.ForceCloseThread;

public class MenuHelper {
	private MenuHelper() {
		throw new IllegalStateException("Utility class");
	}
	public static String getLine(Scanner s) throws ForceCloseThread {
		String line = s.nextLine();
		if(line.equals("EXIT")) {
			throw new ForceCloseThread("EXIT was entered.");
		}
		return line;
	}
	public static int inputPositiveInt(Scanner s) throws ForceCloseThread{
		int val = 0;
		do {
			try {
				if( val < 0) {
					System.out.println("Value must be positive:");
				}
				String line = getLine(s);
				val = Integer.parseInt(line.split(" ")[0]);
			}catch(NumberFormatException e) {
				Application.getLogger().warn("Non-number submitted by user",e);
				val = -1;
			}
		}
		while(val < 0);
		return val;
	}
	public static int inputInt(Scanner s) throws ForceCloseThread {
		int val = 0;
		do {
			try {
				if( val == -168259) {
					System.out.println("Value must be a valid integer:");
				}
				String line = getLine(s);
				val = Integer.parseInt(line.split(" ")[0]);
			}catch(NumberFormatException e) {
				Application.getLogger().warn("Non-number submitted by user",e);
				val = -168259;
			}
		}
		while(val == -168259);
		return val;
	}
	public static double inputPositiveDouble(Scanner s) throws ForceCloseThread{
		double val = 0;
		do {
			try {
				if( val == -1) {
					System.out.println("Value must be a valid a positive double:");
				}
				String line = getLine(s);
				val = Double.parseDouble(line.split(" ")[0]);
			}catch(NumberFormatException e) {
				Application.getLogger().warn("Non-number submitted by user",e);
				val = -1;
			}
		}
		while(val < 0);
		return val;
	}
	public static String inputStringOneWord(Scanner s) throws ForceCloseThread {
		String line = getLine(s);
		String val = line.split(" ")[0];
		return val.replaceAll("[^a-zA-Z]+", "");
	}
	public static boolean inputYN(Scanner s) throws ForceCloseThread{
		String line = getLine(s);
		String val = line.split(" ")[0];
		val = val.replaceAll("[^a-zA-Z]+", "").toUpperCase();
		boolean result = false;
		if(val.equals("Y")) {
			result = true;
		}
		return result;
	}
}
