package com.bank.services.menus;

import java.util.List;

import com.bank.dao.DAOUtilities;
import com.bank.dao.interfaces.AccountDAO;
import com.bank.exceptions.ForceCloseThread;
import com.bank.exceptions.UnsupportedInteger;
import com.bank.model.Account;
import com.bank.model.Person;
import com.bank.services.helpers.MenuHelper;

public class ListAccountsMenu extends AbstractMenu {
	private Person owner;
	private List<Account> accounts;
	private AccountDAO daoAccount = DAOUtilities.getAccountDao();
	public ListAccountsMenu(MainMenu mainMenu) {
		super();
		setMainMenu(mainMenu);
	}
	public ListAccountsMenu(MainMenu mainMenu, Person owner) {
		this(mainMenu);
		this.owner=owner;
	}

	public void run() throws ForceCloseThread {
		do {
			if(accounts == null) {
				if(owner != null) {
					accounts = daoAccount.listAccounts(owner);
				}else {
					accounts = daoAccount.listAccounts();
				}
			}
			for(Account account : accounts) {
				System.out.println(account.toString());
			}
			System.out.println("1 to select account. 0 to return to previous menu.");
			setInput(MenuHelper.inputPositiveInt(s));
			switch(getInput()) {
			case 0:
				break;
			case 1:
				accounts = null;
				System.out.println("Which account number do you want to access?");
				AccountMenu accountMenu = new AccountMenu(getMainMenu(),MenuHelper.inputPositiveInt(s));
				accountMenu.run();
				break;
			default:
				Exception newException = new UnsupportedInteger("The integer: " + getInput() + " is unsupported in this menu.");
				log.warn(newException.getMessage(), newException);
				System.out.println("No accepted number entered, please try again");
			}
		}while(getInput()!=0);
	}
}
