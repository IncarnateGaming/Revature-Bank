package com.revature.bank.services.menus;

import java.util.List;

import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.ReturnMainMenu;
import com.revature.bank.model.Person;
import com.revature.bank.services.buisness.logic.AssociatePersonService;

public class ListAssociatedAccountsMenu extends AbstractMenu {

	public ListAssociatedAccountsMenu(MainMenu mainMenu) {
		super();
		setMainMenu(mainMenu);
	}

	@Override
	AbstractMenu menuFactory() throws ForceCloseThread, ReturnMainMenu {
		List<Person> associates = new AssociatePersonService().getPeople(getMainMenu().getPerson());
		for(Person person : associates) {
			System.out.println(person.toString());
		}
		return null;
	}
}
