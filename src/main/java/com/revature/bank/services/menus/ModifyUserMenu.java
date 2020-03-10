package com.revature.bank.services.menus;

import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.ReturnMainMenu;
import com.revature.bank.model.Person;
import com.revature.bank.services.handlers.PersonHandler;
import com.revature.bank.services.helpers.MenuHelper;

public class ModifyUserMenu extends AbstractMenu {

	private Person localPerson;
	public ModifyUserMenu(MainMenu mainMenu) {
		super();
		setMainMenu(mainMenu);
		this.localPerson = getMainMenu().getPerson();
	}
	@Override
	public AbstractMenu menuFactory() throws ForceCloseThread, ReturnMainMenu {
		AbstractMenu result = null;
		do {
			System.out.println(localPerson.toString());
			System.out.println("Press 1 to change First Name, 2 Last Name"
//					+ ", 3 Street Address, 4 City"
					+ ", 5 Social Security Number. 0 to save and return to previous menu.");
			setInput(MenuHelper.inputPositiveInt(s));
			switch(getInput()) {
			case 0:
				PersonHandler personHandler = new PersonHandler();
				personHandler.update(localPerson);
				System.out.println("Person persisted: " + localPerson.toString());
				break;
			case 1:
				System.out.println("Set First Name:");
				localPerson.setFirstName(MenuHelper.inputStringOneWord(s));
				System.out.println("First name set to: " + localPerson.getFirstName() + ". Remember to hit 0 to save.");
				break;
			case 2:
				System.out.println("Set Last Name:");
				localPerson.setLastName(MenuHelper.inputStringOneWord(s));
				System.out.println("Last name set to: " + localPerson.getLastName() + ". Remember to hit 0 to save.");
				break;
			case 3:
				unsupportedInteger();
				//TODO add Street Address Support
				break;
			case 4:
				unsupportedInteger();
				//TODO add City Support
				break;
			case 5:
				int num = (int) ((Math.random()*100000000)+899999999);
				System.out.println("As this is a demonstration bank, it only accepts randomly generated SSNs in the 900-00-0000 range");
				System.out.println("You have been assigned: " + num);
				localPerson.setSocialSecurityNumber(num);
				break;
			default:
				unsupportedInteger();
			}
		}while(getInput()!=0);
		return result;
	}
}
