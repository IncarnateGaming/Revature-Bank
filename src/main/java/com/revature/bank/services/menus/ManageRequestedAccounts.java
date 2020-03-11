package com.revature.bank.services.menus;

import java.util.List;

import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.ReturnMainMenu;
import com.revature.bank.model.Account;
import com.revature.bank.services.handlers.AccountHandler;
import com.revature.bank.services.helpers.MenuHelper;

public class ManageRequestedAccounts extends AbstractMenu {

	List<Account> listAccounts;
	public ManageRequestedAccounts(MainMenu mainMenu) {
		super();
		setMainMenu(mainMenu);
	}

	@Override
	AbstractMenu menuFactory() throws ForceCloseThread, ReturnMainMenu {
		AbstractMenu result = null;
		do {
			if(listAccounts == null) {
				listAccounts = new AccountHandler().list();
			}
			if(!listAccounts.isEmpty()) {
				for(Account account : listAccounts) {
					account.toString();
				}
			}
			System.out.println("Press 1 to Enter an account request to manage. Press 0 to return to previous menu.");
			setInput(MenuHelper.inputPositiveInt(s));
			switch(getInput()) {
			case 0:
				break;
			case 1:
				result = manageAccountRequest();
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