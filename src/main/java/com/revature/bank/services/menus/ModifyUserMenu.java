package com.revature.bank.services.menus;

import com.revature.bank.dao.DAOUtilities;
import com.revature.bank.dao.interfaces.PersonDAO;
import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.model.Person;
import com.revature.bank.services.helpers.MenuHelper;

public class ModifyUserMenu extends AbstractMenu {

	private Person localPerson;
	public ModifyUserMenu(MainMenu mainMenu) {
		super();
		setMainMenu(mainMenu);
		this.localPerson = getMainMenu().getPerson();
	}
	public void run() throws ForceCloseThread {
		do {
			log.trace("Press 1 to change First Name, 2 Last Name, 3 Street Address, 4 City, "
					+ "5 Social Security Number. 0 to save and return to previous menu.");
			setInput(MenuHelper.inputPositiveInt(s));
			switch(getInput()) {
			case 0:
				PersonDAO daoPerson = DAOUtilities.getPersonDao();
				daoPerson.savePerson(localPerson);
				log.info("Person persisted: " + localPerson.toString());
				break;
			case 1:
				log.trace("Set First Name:");
				localPerson.setFirstName(MenuHelper.inputStringOneWord(s));
				log.trace("First name set to: " + localPerson.getFirstName() + ". Remember to hit 0 to save.");
				break;
			case 2:
				log.trace("Set Last Name:");
				localPerson.setLastName(MenuHelper.inputStringOneWord(s));
				log.trace("Last name set to: " + localPerson.getLastName() + ". Remember to hit 0 to save.");
				break;
			case 3:
				//TODO add Street Address Support
				break;
			case 4:
				//TODO add City Support
				break;
			case 5:
				int num = (int) ((Math.random()*100000000)+899999999);
				log.trace("As this is a demonstration bank, it only accepts randomly generated SSNs in the 900-00-0000 range");
				log.trace("You have been assigned: " + num);
				localPerson.setSocialSecurityNumber(num);
				break;
			default:
				log.trace("No accepted number entered, please try again");
			}
		}while(getInput()!=0);
	}
}
