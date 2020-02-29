package com.revature.bank.services.menus;

public class NewPersonMenu extends AbstractMenu{
	public NewPersonMenu(MainMenu mainMenu) {
		setMainMenu(mainMenu);
	}
	public void run() {
		log.info("New Person Menu");
	}

}
