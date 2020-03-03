package com.revature.bank.services.menus;

import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.ReturnMainMenu;

public class ManageRequestedAccounts extends AbstractMenu {

	public ManageRequestedAccounts(MainMenu mainMenu) {
		super();
		setMainMenu(mainMenu);
	}

	@Override
	AbstractMenu menuFactory() throws ForceCloseThread, ReturnMainMenu {
		AbstractMenu result = null;
//		do {
//			System.out.println("Press 1 to Manage Requested Accounts, 2 to List Users, 3 to List Accounts. Enter \"LOGOUT\" to logout.");
//			setInput(MenuHelper.inputPositiveInt(s));
//			switch(getInput()) {
//			case 0:
//				break;
//			case 1:
//				result = new ManageRequestedAccounts(getMainMenu());
//				break;
//			case 2:
//				result = new ListUsers(getMainMenu());
//				break;
//			case 3:
//				result = new ListAccountsMenu(getMainMenu());
//				break;
//			case 4:
//				if(getMainMenu().containsPermission(PermissionRank.getRankCustomer())) {
//					result = new ListAccountsMenu(getMainMenu(),getMainMenu().getPerson());
//				}else {
//					unsupportedInteger();
//				}
//				break;
//			default:
//				unsupportedInteger();
//			}
//		}while(getInput()!=0 && (result == null));
		return result;
	}
}