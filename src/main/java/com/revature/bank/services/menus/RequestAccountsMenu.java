package com.revature.bank.services.menus;

import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.ReturnMainMenu;

public class RequestAccountsMenu extends AbstractMenu {
	public RequestAccountsMenu(MainMenu mainMenu) {
		super();
		setMainMenu(mainMenu);
	}
	@Override
	public AbstractMenu menuFactory() throws ForceCloseThread, ReturnMainMenu {
		// TODO Auto-generated method stub
		return null;
	}
}
