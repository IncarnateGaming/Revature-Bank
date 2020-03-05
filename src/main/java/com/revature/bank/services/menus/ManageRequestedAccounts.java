package com.revature.bank.services.menus;

import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.ReturnMainMenu;
import com.revature.bank.model.PermissionRank;
import com.revature.bank.services.helpers.MenuHelper;

public class ManageRequestedAccounts extends AbstractMenu {

	public ManageRequestedAccounts(MainMenu mainMenu) {
		super();
		setMainMenu(mainMenu);
	}

	@Override
	AbstractMenu menuFactory() throws ForceCloseThread, ReturnMainMenu {
		AbstractMenu result = null;
		do {
		// Print out top 10 Account Requests
			System.out.println("Press 1 to Enter an account request to manage, 2 to display next set of results. Press 0 to return to previous menu.");
			setInput(MenuHelper.inputPositiveInt(s));
			switch(getInput()) {
			case 0:
				break;
			case 1:
				result = manageAccountRequest();
				break;
			case 2:
				//ToDo, display next 10
				break;
			default:
				unsupportedInteger();
			}
		}while(getInput()!=0 && (result == null));
		return result;
	}
	private AbstractMenu manageAccountRequest() throws ForceCloseThread, ReturnMainMenu{
		System.out.println("Enter account request number.");
		setInput(MenuHelper.inputPositiveInt(s));
		return new ManageRequestedAccount(getInput());
	}
}