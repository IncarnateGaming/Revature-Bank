package com.revature.bank.services.helpers;

import java.util.Scanner;

import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.Logout;
import com.revature.bank.exceptions.ReturnMainMenu;

public class MenuHelper {
	private MenuHelper() {
		throw new IllegalStateException("Utility class");
	}
	/**
	 * Gets an entire line of input
	 * @param s Scanner
	 * @return
	 * @throws ForceCloseThread if "EXIT" entered
	 * @throws ReturnMainMenu if "LOGOUT" entered
	 */
	public static String getLine(Scanner s) throws ForceCloseThread, ReturnMainMenu {
		String line = s.nextLine();
		if(line.equals("EXIT")) {
			throw new ForceCloseThread("EXIT was entered.");
		}else if(line.equals("MAIN")) {
			throw new ReturnMainMenu("MENU was entered.");
		}else if(line.equals("LOGOUT")) {
			throw new Logout("LOGOUT was entered");
		}
		return line;
	}
	/**
	 * Scanner for user to enter a positive integer.
	 * @param s
	 * @return Returns an integer 0 or higher
	 * @throws ForceCloseThread if "EXIT" entered
	 * @throws ReturnMainMenu if "LOGOUT" entered
	 */
	public static int inputPositiveInt(Scanner s) throws ForceCloseThread, ReturnMainMenu{
		int val = 0;
		do {
			try {
				if( val < 0) {
					System.out.println("Value must be positive:");
				}
				String line = getLine(s);
				val = Integer.parseInt(line.split(" ")[0]);
			}catch(NumberFormatException e) {
				LoggerSingleton.getLogger().warn("Non-number submitted by user",e);
				val = -1;
			}
		}
		while(val < 0);
		return val;
	}
	/**
	 * Scanner for user to enter any integer, positive or negative
	 * @param s
	 * @return an integer
	 * @throws ForceCloseThread if "EXIT" entered
	 * @throws ReturnMainMenu if "LOGOUT" entered
	 */
	public static int inputInt(Scanner s) throws ForceCloseThread, ReturnMainMenu {
		int val = 0;
		do {
			try {
				if( val == -168259) {
					System.out.println("Value must be a valid integer:");
				}
				String line = getLine(s);
				val = Integer.parseInt(line.split(" ")[0]);
			}catch(NumberFormatException e) {
				LoggerSingleton.getLogger().warn("Non-number submitted by user",e);
				val = -168259;
			}
		}
		while(val == -168259);
		return val;
	}
	/**
	 * Scanner for user to input a positive double
	 * @param s
	 * @return positive double
	 * @throws ForceCloseThread if "EXIT" entered
	 * @throws ReturnMainMenu if "LOGOUT" entered
	 */
	public static double inputPositiveDouble(Scanner s) throws ForceCloseThread, ReturnMainMenu{
		double val = 0;
		do {
			try {
				if( val == -1) {
					System.out.println("Value must be a valid a positive double:");
				}
				String line = getLine(s);
				val = Double.parseDouble(line.split(" ")[0]);
			}catch(NumberFormatException e) {
				LoggerSingleton.getLogger().warn("Non-number submitted by user",e);
				val = -1;
			}
		}
		while(val < 0);
		return val;
	}
	/**
	 * Scanner for user to input a word
	 * @param s
	 * @return one alphabetical word
	 * @throws ForceCloseThread if "EXIT" entered
	 * @throws ReturnMainMenu if "LOGOUT" entered
	 */
	public static String inputStringOneWord(Scanner s) throws ForceCloseThread, ReturnMainMenu {
		String line = getLine(s);
		String val = line.split(" ")[0];
		return val.replaceAll("[^a-zA-Z]+", "");
	}
	/**
	 * Scanner to get Y/N
	 * @param s
	 * @return boolean, true for Y, false for N
	 * @throws ForceCloseThread if "EXIT" entered
	 * @throws ReturnMainMenu if "LOGOUT" entered
	 */
	public static boolean inputYN(Scanner s) throws ForceCloseThread, ReturnMainMenu{
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
