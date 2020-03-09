package com.revature.bank.services.menus;

import com.revature.bank.dao.DAOUtilities;
import com.revature.bank.dao.interfaces.AccountDAO;
import com.revature.bank.dao.interfaces.AccountOwnershipDAO;
import com.revature.bank.exceptions.AccessDenied;
import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.ReturnMainMenu;
import com.revature.bank.exceptions.UnsupportedInteger;
import com.revature.bank.model.Account;
import com.revature.bank.model.AccountTransaction;
import com.revature.bank.model.AccountTransactionStatus;
import com.revature.bank.model.AccountTransactionType;
import com.revature.bank.model.PermissionRank;
import com.revature.bank.services.buisness.logic.PermissionRankService;
import com.revature.bank.services.helpers.MenuHelper;
import com.revature.bank.services.helpers.PermissionRankHelper;

public class AccountMenu extends AbstractMenu {

	private AccountDAO daoAccount = DAOUtilities.getAccountDao();
	private AccountOwnershipDAO daoAccOwner = DAOUtilities.getAccountOwnershipDao();
	private Account account;
	private PermissionRankService rankService = new PermissionRankService();
	public AccountMenu(MainMenu mainMenu, int accountId) {
		super();
		setMainMenu(mainMenu);
		setAccount(daoAccount.get(accountId));
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@Override
	public AbstractMenu menuFactory() throws ForceCloseThread, ReturnMainMenu {
		AbstractMenu result = null;
		//Check if owner or employee or admin
		if ((!(daoAccOwner.listIds(account.getId())
				.contains(getMainMenu().getPerson().getId()))
				|| rankService.containsPermission(PermissionRankHelper.getEmployee(),getMainMenu().getPermissions()) 
				|| rankService.containsPermission(PermissionRankHelper.getAdmin(), getMainMenu().getPermissions())
				)) {
			AccessDenied accessDenied = new AccessDenied();
			log.warn(getMainMenu().getPerson().toString() 
					+ " just attempted to access" + account.toString(), accessDenied);
			System.out.println("Access Denied");
			return null;
		}
		System.out.println(account.toString());
		do {
			System.out.println("Press 1 to deposit, 2 to withdraw, 3 to transfer. Press 0 to return to previous menu.");
			if(rankService.containsPermission(PermissionRankHelper.getAdmin(), getMainMenu().getPermissions())) {
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
				//TODO add more business logic
				break;
			case 2:
				System.out.println("How much do you want to withdraw?");
				//TODO add business logic for withdraws
				break;
			case 3:
				System.out.println("How much do you want to transfer?");
				System.out.println("Which account do you want to transfer to?");
				//TODO add business logic for transfers
				break;
			case 4:
				if(rankService.containsPermission(PermissionRankHelper.getAdmin(), getMainMenu().getPermissions())) {
					System.out.println("Are you sure you want to inactivate this account?(Y/N)");
					//TODO add buisness logic
					break;
				}else {
					unsupportedInteger();
					break;
				}
			default:
				unsupportedInteger();
			}
		}while(getInput()!=0 && result == null);
		return result;
	}
}
