package com.revature.bank.services.menus;

import java.util.List;

import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.ReturnMainMenu;
import com.revature.bank.model.PermissionRank;
import com.revature.bank.model.Person;
import com.revature.bank.services.buisness.logic.PermissionRankService;
import com.revature.bank.services.handlers.PermissionRankHandler;
import com.revature.bank.services.handlers.PersonHandler;
import com.revature.bank.services.helpers.MenuHelper;
import com.revature.bank.services.helpers.PermissionRankHelper;

public class LoginMenu extends AbstractMenu{
	private PermissionRankService rankService = new PermissionRankService();
	public LoginMenu(MainMenu mainMenu) {
		super();
		setMainMenu(mainMenu);
	}

	@Override
	public AbstractMenu menuFactory() throws ForceCloseThread, ReturnMainMenu {
		AbstractMenu result = null;
		Person user = null;
		List<PermissionRank> ranks = null;
		boolean loginSuccess = false;
		do {
			System.out.println("Enter Username:");
			String username = MenuHelper.inputToken(s);
			System.out.println("Enter Password:");
			String password = MenuHelper.inputToken(s);
			user = new PersonHandler().get(username);
			if(user != null && user.getPassword().equals(password)) {
				loginSuccess = true;
				getMainMenu().setPerson(user);
				ranks = new PermissionRankHandler().list(user);
				getMainMenu().setPermissions(ranks);
			}else {
				System.out.println("Login failed, try again. Enter \"LOGOUT\" to return to previous menu");
			}
		}while (loginSuccess == false);
		if(rankService.containsPermission(PermissionRankHelper.getAdmin(), ranks)) {
			result = new EmployeeMenu(getMainMenu());
		}
		else if(rankService.containsPermission(PermissionRankHelper.getEmployee(), ranks)) {
			result = new EmployeeMenu(getMainMenu());
		}
		else if(rankService.containsPermission(PermissionRankHelper.getCustomer(), ranks)) {
			result = new CustomerMenu(getMainMenu());
		}
		return result;
	}
}
