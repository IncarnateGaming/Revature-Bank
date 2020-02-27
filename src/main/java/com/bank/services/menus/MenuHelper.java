package com.bank.services.menus;

import java.util.Scanner;

public class MenuHelper {
	public static int inputPositiveInt(Scanner s) {
		int val = 0;
		do {
			try {
				if( val < 0) {
					System.out.println("Value must be positive:");
				}
				val = Integer.parseInt(s.nextLine().split(" ")[0]);
			}catch(NumberFormatException e) {
				e.printStackTrace();
				val = -1;
			}
		}
		while(val < 0);
		return val;
	}
}