package com.revature.bank;

import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.services.menus.MainMenu;

public class Application {
	public static void main(String[] args) throws ForceCloseThread {
		MainMenu main = new MainMenu();
		Thread t1 = new Thread(main);
		t1.start();
	}
}