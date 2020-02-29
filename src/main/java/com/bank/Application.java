package com.bank;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.exceptions.ForceCloseThread;
import com.bank.services.menus.MainMenu;

public class Application {
	private static Logger log = Logger.getLogger(Application.class);
	private static Scanner s = new Scanner(System.in);
	public static Logger getLogger() {
		return log;
	}
	public static Scanner getScanner() {
		return s;
	}
	public static void main(String[] args) throws ForceCloseThread {
		MainMenu main = new MainMenu();
		main.run();
	}

}
