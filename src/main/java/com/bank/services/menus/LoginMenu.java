package com.bank.services.menus;

import com.bank.model.PermissionRank;
import com.bank.model.Person;

public class LoginMenu extends AbstractMenu{
	
	public LoginMenu(MainMenu mainMenu) {
		super(mainMenu);
	}

	public void run() {
		do {
			log.trace("Press 1 to login as Customer, 2 for Employee, 3 for Admin. Press 0 to return to previous menu.");
			setInput(MenuHelper.inputPositiveInt(s));
			getMainMenu().setPerson(new Person("awesome","engage","Bob","Saget"));
			switch(getInput()) {
			case 0:
				break;
			case 1:
				getMainMenu().setPermissionRank(new PermissionRank(1, "Customer"));
				CustomerMenu customerMenu = new CustomerMenu(getMainMenu());
				customerMenu.run();
				break;
			case 2:
				getMainMenu().setPermissionRank(new PermissionRank(2, "Employee"));
				EmployeeMenu employeeMenu = new EmployeeMenu(getMainMenu());
				employeeMenu.run();
				break;
			case 3:
				getMainMenu().setPermissionRank(new PermissionRank(3, "Admin"));
				EmployeeMenu employeeMenu2 = new EmployeeMenu(getMainMenu());
				employeeMenu2.run();
				break;
			default:
				log.trace("No accepted number entered, please try again");
			}
		}while(getInput()!=0);
	}
}
