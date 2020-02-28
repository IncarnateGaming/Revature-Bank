package com.bank.services.menus;

import java.util.List;

import com.bank.dao.DAOUtilities;
import com.bank.dao.interfaces.AccountDAO;
import com.bank.model.Account;
import com.bank.model.Person;

public class ListAccountsMenu extends AbstractMenu {
	private Person owner;
	private List<Account> accounts;
	private AccountDAO daoAccount = DAOUtilities.getAccountDao();
	public ListAccountsMenu(MainMenu mainMenu) {
		super();
	}
	public ListAccountsMenu(MainMenu mainMenu, Person owner) {
		this(mainMenu);
		this.owner=owner;
	}

	public void run() {
		do {
			if(accounts == null) {
				if(owner != null) {
					accounts = daoAccount.listAccounts(owner);
				}else {
					accounts = daoAccount.listAccounts();
				}
			}
			for(Account account : accounts) {
				log.trace(account.toString());
			}
			log.trace("1 to select account. 0 to return to previous menu.");
			setInput(MenuHelper.inputPositiveInt(s));
			switch(getInput()) {
			case 0:
				break;
			case 1:
				accounts = null;
				ModifyUserMenu modifyUserMenu = new ModifyUserMenu(getMainMenu());
				modifyUserMenu.run();
				break;
			default:
				log.trace("No accepted number entered, please try again");
			}
		}while(getInput()!=0);
	}
}
