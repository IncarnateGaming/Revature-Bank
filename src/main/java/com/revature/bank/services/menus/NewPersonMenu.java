package com.revature.bank.services.menus;

import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.InvalidPasswordChoice;
import com.revature.bank.exceptions.ReturnMainMenu;
import com.revature.bank.model.Person;
import com.revature.bank.services.buisness.logic.PersonService;
import com.revature.bank.services.handlers.AssociatedPersonHandler;
import com.revature.bank.services.handlers.PermissionRankHandler;
import com.revature.bank.services.helpers.LoggerSingleton;
import com.revature.bank.services.helpers.MenuHelper;
import com.revature.bank.services.helpers.PermissionRankHelper;

public class NewPersonMenu extends AbstractMenu{
	private Person associatedPerson;
	public NewPersonMenu(MainMenu mainMenu) {
		setMainMenu(mainMenu);
	}
	public NewPersonMenu(MainMenu mainMenu, Person associatedPerson) {
		this(mainMenu);
		this.associatedPerson = associatedPerson;
	}
	@Override
	AbstractMenu menuFactory() throws ForceCloseThread, ReturnMainMenu {
		AbstractMenu result = null;
		boolean usernameTaken = true;
		String username;
		do {
			System.out.println("What username do you want to use for this user login?");
			username = MenuHelper.inputToken(s);
			usernameTaken = new PersonService().usernameTaken(username);
			if (usernameTaken) {
				System.out.println("Username: \""+ username + "\" is already in use.");
			}
		}while (usernameTaken == true);
		boolean passwordAccepted;
		String password;
		do {
			System.out.println("What password do you want to use for the " + username + " user login?");
			password = MenuHelper.inputToken(s);
			try {
				passwordAccepted = new PersonService().passwordAccepted(password);
			} catch (InvalidPasswordChoice e) {
				passwordAccepted = false;
				LoggerSingleton.getLogger().warn("Invalid Password Choice: ",e);
			}
		}while (passwordAccepted == false);
		Person newPerson = new PersonService().submitNewUser(username,password);
		new PermissionRankHandler().assign(newPerson, PermissionRankHelper.getCustomer());
		//If triggered by association, create the association
		if(associatedPerson != null) {
			new AssociatedPersonHandler().create(associatedPerson,newPerson);
		}
		System.out.println(username + " created!");
		return result;
	}

}
