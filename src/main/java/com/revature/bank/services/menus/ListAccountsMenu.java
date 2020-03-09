package com.revature.bank.services.menus;

import java.util.List;

import com.revature.bank.dao.DAOUtilities;
import com.revature.bank.dao.interfaces.AccountDAO;
import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.ReturnMainMenu;
import com.revature.bank.exceptions.UnsupportedInteger;
import com.revature.bank.model.Account;
import com.revature.bank.model.Person;
import com.revature.bank.services.helpers.MenuHelper;

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

	@Override
	public AbstractMenu menuFactory() throws ForceCloseThread, ReturnMainMenu {
		AbstractMenu result = null;
		do {
			if(accounts == null) {
				if(owner != null) {
					accounts = daoAccount.listJoin(owner);
				}else {
					accounts = daoAccount.listJoin();
				}
			}
			System.out.format("%6%16%24%5%12%16%8s", "ID","Balance","Overdraft Protection","Active","Account Type","Min Balance","Interest");
			for(Account account : accounts) {
				System.out.format("%6%16%24%5%12%16%8s", account.getId(),account.getBalance(),
						account.getOverdraftProtection(),account.getActive()
						, account.getAccountType() != null ? account.getAccountType().getLabel() : ""
						, account.getAccountType() != null ? account.getAccountType().getMinBalance() : ""
						, account.getAccountType() != null ? account.getAccountType().getInterest() : "");
			}
			System.out.println("1 to select account. 0 to return to previous menu.");
			setInput(MenuHelper.inputPositiveInt(s));
			switch(getInput()) {
			case 0:
				break;
			case 1:
				accounts = null;
				System.out.println("Which account number do you want to access?");
				result = new AccountMenu(getMainMenu(),MenuHelper.inputPositiveInt(s));
				break;
			default:
				Exception newException = new UnsupportedInteger("The integer: " + getInput() + " is unsupported in this menu.");
				log.warn(newException.getMessage(), newException);
				System.out.println("No accepted number entered, please try again");
			}
		}while(getInput()!=0 && result == null);
		return result;
	}
}
