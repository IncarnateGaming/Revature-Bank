package com.revature.bank.services.menus;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.ReturnMainMenu;
import com.revature.bank.exceptions.UnsupportedInteger;
import com.revature.bank.services.helpers.LoggerSingleton;
import com.revature.bank.services.helpers.ScannerSingleton;

public abstract class AbstractMenu {
	public Logger log = LoggerSingleton.getLogger();
	public Scanner s = ScannerSingleton.getScanner();
	private int input=-1;
	private MainMenu mainMenu;
	AbstractMenu(){
		super();
	}
	public int getInput() {
		return input;
	}
	public void setInput(int input) {
		this.input = input;
	}
	public Scanner getScanner() {
		return s;
	}
	public void setScanner(Scanner s) {
		this.s = s;
	}
	public MainMenu getMainMenu() {
		return mainMenu;
	}
	public void setMainMenu(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
	}

	abstract AbstractMenu menuFactory() throws ForceCloseThread, ReturnMainMenu;
	public void unsupportedInteger() {
		Exception newException = new UnsupportedInteger("The integer: " + getInput() + " is unsupported in this menu.");
		log.warn(newException.getMessage(), newException);
		System.out.println("No accepted number entered, please try again");
	}
}
