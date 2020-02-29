package com.revature.bank.services.menus;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.bank.Application;
import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.ReturnMainMenu;

public abstract class AbstractMenu {
	public static Logger log = Application.getLogger();
	public static Scanner s = Application.getScanner();
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
	public MainMenu getMainMenu() {
		return mainMenu;
	}
	public void setMainMenu(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
	}

	abstract void run() throws ForceCloseThread, ReturnMainMenu;
}
