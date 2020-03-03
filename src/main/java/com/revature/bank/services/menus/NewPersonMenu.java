package com.revature.bank.services.menus;

import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.ReturnMainMenu;
import com.revature.bank.services.buisness.logic.PersonHandling;
import com.revature.bank.services.helpers.MenuHelper;

public class NewPersonMenu extends AbstractMenu{
	public NewPersonMenu(MainMenu mainMenu) {
		setMainMenu(mainMenu);
	}
	@Override
	AbstractMenu menuFactory() throws ForceCloseThread, ReturnMainMenu {
		AbstractMenu result = null;
		boolean usernameTaken = true;
		String username;
		do {
			System.out.println("What username do you want to use for this user login?");
			username = MenuHelper.inputStringOneWord(s);
			usernameTaken = PersonHandling.usernameTaken(username);
			if (usernameTaken) {
				System.out.println("Username: \""+ username + "\" is already in use.");
			}
		}while (usernameTaken == true);
		boolean passwordAccepted;
		String password;
		do {
			System.out.println("What password do you want to use for the " + username + " user login?");
			password = MenuHelper.inputStringOneWord(s);
			passwordAccepted = PersonHandling.passwordAccepted(password);
			if (!passwordAccepted) {
				System.out.println("Password: \""+ username + "\" does not meet standards.");
				//TODO be more specific
			}
		}while (usernameTaken == true);
		PersonHandling.submitNewUser(username,password);
		System.out.println(username + " created!");
		return result;
	}

}
