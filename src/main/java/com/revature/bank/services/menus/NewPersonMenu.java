package com.revature.bank.services.menus;

import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.ReturnMainMenu;
import com.revature.bank.model.Person;
import com.revature.bank.services.handlers.AssociatedPersonHandler;
import com.revature.bank.services.handlers.PersonHandler;
import com.revature.bank.services.helpers.MenuHelper;

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
			username = MenuHelper.inputStringOneWord(s);
			usernameTaken = PersonHandler.usernameTaken(username);
			if (usernameTaken) {
				System.out.println("Username: \""+ username + "\" is already in use.");
			}
		}while (usernameTaken == true);
		boolean passwordAccepted;
		String password;
		do {
			System.out.println("What password do you want to use for the " + username + " user login?");
			password = MenuHelper.inputStringOneWord(s);
			passwordAccepted = PersonHandler.passwordAccepted(password);
			if (!passwordAccepted) {
				System.out.println("Password: \""+ username + "\" does not meet standards.");
				//TODO be more specific
			}
		}while (usernameTaken == true);
		Person newPerson = PersonHandler.submitNewUser(username,password);
		//If triggered by association, create the association
		if(associatedPerson != null) {
			AssociatedPersonHandler.create(associatedPerson,newPerson);
		}
		System.out.println(username + " created!");
		return result;
	}

}
