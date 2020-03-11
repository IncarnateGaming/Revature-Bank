package com.revature.bank.services.menus;

import java.util.List;

import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.ReturnMainMenu;
import com.revature.bank.model.Person;
import com.revature.bank.services.handlers.PersonHandler;

public class ListUsers extends AbstractMenu {

	private List<Person> list = new PersonHandler().list();
	public ListUsers(MainMenu mainMenu) {
		super();
		setMainMenu(mainMenu);
	}

	@Override
	AbstractMenu menuFactory() throws ForceCloseThread, ReturnMainMenu {
		for(Person per : list) {
			per.toString();
		}
		return null;
	}

}
