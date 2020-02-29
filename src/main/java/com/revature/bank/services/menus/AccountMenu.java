package com.revature.bank.services.menus;

import com.revature.bank.dao.DAOUtilities;
import com.revature.bank.dao.interfaces.AccountDAO;
import com.revature.bank.dao.interfaces.AccountOwnershipDAO;
import com.revature.bank.exceptions.AccessDenied;
import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.UnsupportedInteger;
import com.revature.bank.model.Account;
import com.revature.bank.model.AccountTransaction;
import com.revature.bank.model.AccountTransactionStatus;
import com.revature.bank.model.AccountTransactionType;
import com.revature.bank.services.helpers.MenuHelper;

public class AccountMenu extends AbstractMenu {

	private AccountDAO daoAccount = DAOUtilities.getAccountDao();
	private AccountOwnershipDAO daoAccOwner = DAOUtilities.getAccountOwnershipDao();
	private Account account;
	public AccountMenu(MainMenu mainMenu, int accountId) {
		super();
		setMainMenu(mainMenu);
		setAccount(daoAccount.getAccount(accountId));
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@Override
	void run() throws ForceCloseThread {
		//Check if owner or employee or admin
		if ((!(daoAccOwner.listAccountOwnershipIds(account.getId())
				.contains(getMainMenu().getPerson().getId()))
				|| getMainMenu().containsPermission("Employee") 
				|| getMainMenu().containsPermission("Admin"))) {
			AccessDenied accessDenied = new AccessDenied();
			log.warn(getMainMenu().getPerson().toString() 
					+ " just attempted to access" + account.toString(), accessDenied);
			System.out.println("Access Denied");
			return;
		}
		System.out.println(account.toString());
		do {
			System.out.println("Press 1 to deposit, 2 to withdraw, 3 to transfer. Press 0 to return to previous menu.");
			if(getMainMenu().containsPermission("Admin")) {
				System.out.println("Press 4 to mark the account as inactive.");
			}
			setInput(MenuHelper.inputPositiveInt(s));
			switch(getInput()) {
			case 0:
				break;
			case 1:
				System.out.println("How much do you want to deposit?");
				double depositAmount = MenuHelper.inputPositiveDouble(s);
				AccountTransaction newDeposit = new AccountTransaction(account.getId(), AccountTransactionStatus.getPendingId(), AccountTransactionType.getDepositId(), null);
				ModifyUserMenu modifyUserMenu = new ModifyUserMenu(getMainMenu());
				modifyUserMenu.run();
				break;
			case 2:
				System.out.println("How much do you want to withdraw?");
				ListAccountsMenu checkAccountsMenu = new ListAccountsMenu(getMainMenu(),getMainMenu().getPerson());
				checkAccountsMenu.run();
				break;
			case 3:
				System.out.println("How much do you want to transfer?");
				System.out.println("Which account do you want to transfer to?");
				RequestAccountsMenu requestAccountsMenu = new RequestAccountsMenu(getMainMenu());
				requestAccountsMenu.run();
				break;
			case 4:
				if(!getMainMenu().containsPermission("Admin")) {
					unsupportedInteger();
					break;
				}
				System.out.println("Are you sure you want to inactivate this account?(Y/N)");
				CreateAccountMenu createAccountMenu = new CreateAccountMenu(getMainMenu());
				createAccountMenu.run();
				break;
			default:
				unsupportedInteger();
			}
		}while(getInput()!=0);
	}
	public void unsupportedInteger() {
		Exception newException = new UnsupportedInteger("The integer: " + getInput() + " is unsupported in this menu.");
		log.warn(newException.getMessage(), newException);
		System.out.println("No accepted number entered, please try again");
	}
}
