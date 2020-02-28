package com.bank.services.menus;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bank.Application;

public abstract class AbstractMenu {
	public static Logger log = Application.getLogger();
	public static Scanner s = Application.getScanner();
	private int input=-1;
	private MainMenu mainMenu;
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

}
