package com.revature.bank.services.menus;

import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.ReturnMainMenu;
import com.revature.bank.exceptions.UnsupportedInteger;
import com.revature.bank.services.helpers.MenuHelper;

public class EmployeeMenu extends AbstractMenu{

	public EmployeeMenu(MainMenu mainMenu) {
		super();
		setMainMenu(mainMenu);
	}

	public void run() throws ForceCloseThread, ReturnMainMenu {
		do {
			System.out.println("Press 1 to modify user info, 2 to check accounts, 3 to request new account, or 4 to create a new associated user login. Press 0 to return to previous menu.");
			setInput(MenuHelper.inputPositiveInt(s));
			switch(getInput()) {
			case 0:
				break;
			case 1:
				ModifyUserMenu modifyUserMenu = new ModifyUserMenu(getMainMenu());
				modifyUserMenu.run();
				break;
			case 2:
				ListAccountsMenu checkAccountsMenu = new ListAccountsMenu(getMainMenu());
				checkAccountsMenu.run();
				break;
			case 3:
				RequestAccountsMenu requestAccountsMenu = new RequestAccountsMenu(getMainMenu());
				requestAccountsMenu.run();
				break;
			case 4:
				CreateAccountMenu createAccountMenu = new CreateAccountMenu(getMainMenu());
				createAccountMenu.run();
				break;
			default:
				Exception newException = new UnsupportedInteger("The integer: " + getInput() + " is unsupported in this menu.");
				log.warn(newException.getMessage(), newException);
				System.out.println("No accepted number entered, please try again");
			}
		}while(getInput()!=0);
	}

}
