package com.revature.bank.services.menus;

import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.ReturnMainMenu;
import com.revature.bank.model.AccountRequest;
import com.revature.bank.services.buisness.logic.ProcessAccountRequest;
import com.revature.bank.services.handlers.AccountRequestHandler;
import com.revature.bank.services.handlers.AccountTypeHandler;
import com.revature.bank.services.helpers.MenuHelper;

public class ManageRequestedAccount extends AbstractMenu {

	private AccountRequestHandler accountRequestHandling;
	private AccountRequest accountRequest;
	public ManageRequestedAccount(int input) {
		accountRequestHandling = new AccountRequestHandler();
		accountRequest = accountRequestHandling.getAccountRequest(input);
	}

	@Override
	AbstractMenu menuFactory() throws ForceCloseThread, ReturnMainMenu {
		AbstractMenu result = null;
		System.out.println(new AccountTypeHandler().get(accountRequest.getAccountTypeId()).toString());
		//Display relevant information
		do {
			System.out.println("Press 1 to approve, 2 to reject"
//					+ ", 3 to view all accounts controlled by this person"
					+ ". Press 0 to return to previous menu.");
			setInput(MenuHelper.inputPositiveInt(s));
			switch(getInput()) {
			case 0:
				break;
			case 1:
				ProcessAccountRequest.approve(accountRequest);
				break;
			case 2:
				ProcessAccountRequest.reject(accountRequest);
				break;
			case 3:
				unsupportedInteger();
//				AbstractMenu requestersAccounts = new ListAccountsMenu(accountRequestHandling.getPerson(accountRequest));
//				result = new ListAccountsMenu(getMainMenu());
				break;
			default:
				unsupportedInteger();
			}
		}while(getInput()!=0 && getInput() != 1 && getInput() != 2 && (result == null));
		return null;
	}

}
