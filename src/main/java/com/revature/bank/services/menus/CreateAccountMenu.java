package com.revature.bank.services.menus;

import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.ReturnMainMenu;
import com.revature.bank.model.Person;

public class CreateAccountMenu extends AbstractMenu {
	public CreateAccountMenu(MainMenu mainMenu) {
		super();
		setMainMenu(mainMenu);
	}
	@Override
	AbstractMenu menuFactory() throws ForceCloseThread, ReturnMainMenu {
		// TODO Auto-generated method stub
		return null;
	}
}
