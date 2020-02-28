package com.bank.services.menus;

public class CustomerMenu extends AbstractMenu{

	public CustomerMenu(MainMenu mainMenu) {
		super();
	}

	public void run() {
		do {
			log.trace("Press 1 to modify user info, 2 to check accounts, 3 to request new "
					+ "account, 4 to create a new associated user login, or 5 to list associated "
					+ "user logins Press 0 to return to previous menu.");
			setInput(MenuHelper.inputPositiveInt(s));
			switch(getInput()) {
			case 0:
				break;
			case 1:
				ModifyUserMenu modifyUserMenu = new ModifyUserMenu(getMainMenu());
				modifyUserMenu.run();
				break;
			case 2:
				ListAccountsMenu checkAccountsMenu = new ListAccountsMenu(getMainMenu());
				checkAccountsMenu.run();
				break;
			case 3:
				RequestAccountsMenu requestAccountsMenu = new RequestAccountsMenu(getMainMenu());
				requestAccountsMenu.run();
				break;
			case 4:
				CreateAccountMenu createAccountMenu = new CreateAccountMenu(getMainMenu());
				createAccountMenu.run();
				break;
			case 5:
				
			default:
				log.trace("No accepted number entered, please try again");
			}
		}while(getInput()!=0);
	}

}
