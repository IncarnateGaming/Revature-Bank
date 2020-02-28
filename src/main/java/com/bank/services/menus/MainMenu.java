package com.bank.services.menus;

import com.bank.model.PermissionRank;
import com.bank.model.Person;

public class MainMenu extends AbstractMenu{
	private Person person;
	private PermissionRank permissionRank;
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public PermissionRank getPermissionRank() {
		return permissionRank;
	}
	public void setPermissionRank(PermissionRank permissionRank) {
		this.permissionRank = permissionRank;
	}
	public void run() {
		do {
			log.info("Press 1 to login or 2 to create a new account. Press 0 to exit.");
			setInput(MenuHelper.inputPositiveInt(s));
			switch(getInput()) {
			case 0:
				break;
			case 1:
				LoginMenu loginMenu = new LoginMenu(this);
				loginMenu.run();
				break;
			case 2:
				NewPersonMenu newPersonMenu = new NewPersonMenu(this);
				newPersonMenu.run();
				break;
			default:
				log.info("No accepted number entered, please try again");
			}
		}while (getInput() != 0);
		log.info("Program Closed");
	}
}
