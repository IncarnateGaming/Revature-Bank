package com.revature.bank.services.menus;

import java.util.List;

import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.ReturnMainMenu;
import com.revature.bank.model.AccountType;
import com.revature.bank.model.Person;
import com.revature.bank.services.buisness.logic.AssociatePersonService;
import com.revature.bank.services.handlers.AccountTypeHandler;
import com.revature.bank.services.handlers.PersonHandler;
import com.revature.bank.services.helpers.MenuHelper;

public class RequestAccountsMenu extends AbstractMenu {
	private AccountTypeHandler accountTypeHandler = new AccountTypeHandler();
	private PersonHandler personHandler = new PersonHandler();
	public RequestAccountsMenu(MainMenu mainMenu) {
		super();
		setMainMenu(mainMenu);
	}
	@Override
	public AbstractMenu menuFactory() throws ForceCloseThread, ReturnMainMenu {
		List<AccountType> accountTypes = accountTypeHandler.list();
		AccountType accountType = null;
		do {
			for(AccountType accountTypelist : accountTypes) {
				System.out.println(accountTypelist.toString());
			}
			System.out.println("Which account type do you want to open?");
			int accountTypeId = MenuHelper.inputPositiveInt(s);
			accountType = accountTypeHandler.get(accountTypeId);
			if(accountType == null) {
				System.out.println("Invalid Integer, please enter the id for an account type.");
			}
		}while(accountType == null && !accountTypes.isEmpty());
		//TODO add account request creation
		List<Person> associates = new AssociatePersonService().getPeople(getMainMenu().getPerson());
		int input = -1;
		while (input != 0 && !associates.isEmpty()) {
			System.out.println("Known associates:");
			for (Person per : associates) {
				System.out.println(per.toString());
			}
			System.out.println("If you wish to add an associate to this account enter their id. "
					+ "Enter \"0\" when you are done making selections.");
			input = MenuHelper.inputPositiveInt(s);
			if (input > 0) {
				Person personToAdd = personHandler.get(input);
				if(personToAdd != null) {
					System.out.println(personToAdd.getFirstName() + " " + personToAdd.getLastName() + 
							" added to your new account.");
				}else {
					System.out.println("No person exists with the id of " + input);
				}
			}
		}
		return null;
	}
}
