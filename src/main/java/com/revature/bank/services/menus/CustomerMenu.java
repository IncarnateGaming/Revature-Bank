package com.revature.bank.services.menus;

import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.ReturnMainMenu;
import com.revature.bank.exceptions.UnsupportedInteger;
import com.revature.bank.services.helpers.MenuHelper;

public class CustomerMenu extends AbstractMenu{

	public CustomerMenu(MainMenu mainMenu) {
		super();
		setMainMenu(mainMenu);
	}
	@Override
	public AbstractMenu menuFactory() throws ForceCloseThread, ReturnMainMenu {
		AbstractMenu result = null;
		do {
			System.out.println("Press 1 to modify user info, 2 to check accounts, 3 to request new "
					+ "account, 4 to create a new associated user login, or 5 to list associated "
					+ "user logins Press 0 to return to previous menu.");
			setInput(MenuHelper.inputPositiveInt(s));
			switch(getInput()) {
			case 0:
				break;
			case 1:
				result = new ModifyUserMenu(getMainMenu());
				break;
			case 2:
				result = new ListAccountsMenu(getMainMenu(),getMainMenu().getPerson());
				break;
			case 3:
				result = new RequestAccountsMenu(getMainMenu());
				break;
			case 4:
				result = new CreateAccountMenu(getMainMenu());
				break;
			case 5:
				result = new ListAssociatedAccountsMenu(getMainMenu());
				break;
			default:
				Exception newException = new UnsupportedInteger("The integer: " + getInput() + " is unsupported in this menu.");
				log.warn(newException.getMessage(), newException);
				System.out.println("No accepted number entered, please try again");
			}
		}while(getInput()!=0 && result == null);
		return result;
	}

}
