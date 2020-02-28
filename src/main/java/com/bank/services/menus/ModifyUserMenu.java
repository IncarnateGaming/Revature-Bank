package com.bank.services.menus;

public class ModifyUserMenu extends AbstractMenu {

	public ModifyUserMenu(MainMenu mainMenu) {
		super();
		setMainMenu(mainMenu);
	}
	public void run() {
		do {
			log.info("Press 1 to modify user info, 2 to check accounts, 3 to request new account, or 4 to create a new associated user login. Press 0 to return to previous menu.");
			setInput(MenuHelper.inputPositiveInt(s));
			switch(getInput()) {
			case 0:
				break;
			case 1:
				getMainMenu().getPerson().setFirstName();
				break;
			case 2:
				CheckAccountsMenu checkAccountsMenu = new CheckAccountsMenu(getMainMenu());
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
			default:
				log.info("No accepted number entered, please try again");
			}
		}while(getInput()!=0);
	}
}
