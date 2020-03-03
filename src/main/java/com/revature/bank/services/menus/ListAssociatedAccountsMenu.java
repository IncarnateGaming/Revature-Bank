package com.revature.bank.services.menus;

import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.ReturnMainMenu;

public class ListAssociatedAccountsMenu extends AbstractMenu {

	public ListAssociatedAccountsMenu(MainMenu mainMenu) {
		super();
		setMainMenu(mainMenu);
	}

	@Override
	AbstractMenu menuFactory() throws ForceCloseThread, ReturnMainMenu {
		// TODO Auto-generated method stub
		return null;
	}
}
