package com.revature.bank.services.menus;

import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.ReturnMainMenu;
import com.revature.bank.exceptions.UnsupportedInteger;
import com.revature.bank.model.PermissionRank;
import com.revature.bank.services.helpers.MenuHelper;

public class EmployeeMenu extends AbstractMenu{

	public EmployeeMenu(MainMenu mainMenu) {
		super();
		setMainMenu(mainMenu);
	}

	@Override
	public AbstractMenu menuFactory() throws ForceCloseThread, ReturnMainMenu {
		AbstractMenu result = null;
		do {
			System.out.println("Press 1 to Manage Requested Accounts, 2 to list users, 3 to list accounts. Enter \"LOGOUT\" to logout.");
			if(getMainMenu().containsPermission(PermissionRank.getRankCustomer())) {
				System.out.println("Press 4 to view your own accounts.");
			}
			setInput(MenuHelper.inputPositiveInt(s));
			switch(getInput()) {
			case 0:
				break;
			case 1:
				result = new ManageRequestedAccounts(getMainMenu());
				break;
			case 2:
				result = new ListUsers(getMainMenu());
				break;
			case 3:
				result = new ListAccountsMenu(getMainMenu());
				break;
			case 4:
				if(getMainMenu().containsPermission(PermissionRank.getRankCustomer())) {
					result = new ListAccountsMenu(getMainMenu(),getMainMenu().getPerson());
				}else {
					unsupportedInteger();
				}
				break;
			default:
				unsupportedInteger();
			}
		}while(getInput()!=0 && (result == null));
		return result;
	}
}