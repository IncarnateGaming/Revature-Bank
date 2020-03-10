package com.revature.bank.services.menus;

import com.revature.bank.exceptions.AccessDenied;
import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.InsufficientLineOfCredit;
import com.revature.bank.exceptions.InvalidNegativeValue;
import com.revature.bank.exceptions.ReturnMainMenu;
import com.revature.bank.model.Account;
import com.revature.bank.services.buisness.logic.AccountService;
import com.revature.bank.services.buisness.logic.AccountTransactionService;
import com.revature.bank.services.buisness.logic.PermissionRankService;
import com.revature.bank.services.handlers.AccountHandler;
import com.revature.bank.services.handlers.AccountOwnershipHandler;
import com.revature.bank.services.helpers.LoggerSingleton;
import com.revature.bank.services.helpers.MenuHelper;
import com.revature.bank.services.helpers.PermissionRankHelper;

public class AccountMenu extends AbstractMenu {

	private static AccountHandler accountHandler = new AccountHandler();
	private static AccountService accountService = new AccountService();
	private static AccountOwnershipHandler accountOwnershipHandler = new AccountOwnershipHandler();
	private static AccountTransactionService accountTransactionService = new AccountTransactionService();
	private static PermissionRankService rankService = new PermissionRankService();
	private Account account;
	public AccountMenu(MainMenu mainMenu, int accountId) {
		super();
		setMainMenu(mainMenu);
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
		if ((!(
					accountOwnershipHandler.checkOwned(account, getMainMenu().getPerson())//check ownership
					|| rankService.containsPermission(PermissionRankHelper.getEmployee(),getMainMenu().getPermissions())//check employee 
					|| rankService.containsPermission(PermissionRankHelper.getAdmin(), getMainMenu().getPermissions())//check admin
					)
				)) {
			AccessDenied accessDenied = new AccessDenied();
			LoggerSingleton.getAccessLog().warn(getMainMenu().getPerson().toString() 
					+ " just attempted to access " + account.toString(), accessDenied);
			System.out.println("Access Denied");
			return null;
		}
		do {
			System.out.println(account.toString());
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
				try {
					accountTransactionService.createDeposit(account, depositAmount);
					account = accountHandler.get(account.getId());
				} catch (InvalidNegativeValue e) {
					LoggerSingleton.getLogger().warn("Negative Deposit",e);
				}
				break;
			case 2:
				System.out.println("How much do you want to withdraw?");
				double withdrawAmount = MenuHelper.inputPositiveDouble(s);
				try {
					accountTransactionService.createWithdraw(account, withdrawAmount);
					account = accountHandler.get(account.getId());
				} catch (InvalidNegativeValue | InsufficientLineOfCredit e) {
					LoggerSingleton.getLogger().warn("Negative Withdraw",e);
				}
				break;
			case 3:
				System.out.println("How much do you want to transfer?");
				double transferAmount = MenuHelper.inputPositiveDouble(s);
				System.out.println("Which account do you want to transfer to?");
				int transferAccountId = MenuHelper.inputPositiveInt(s);
				Account targetAccount = accountHandler.get(transferAccountId);
				if (targetAccount == null) {
					System.out.println("No account exists with the id: " + transferAccountId);
				}else {
					try {
						accountTransactionService.createTransfer(account, targetAccount, transferAmount);
						account = accountHandler.get(account.getId());
					} catch (InvalidNegativeValue | InsufficientLineOfCredit e) {
						LoggerSingleton.getLogger().warn("Negative Withdraw",e);
					}
				}
				break;
			case 4:
				if(rankService.containsPermission(PermissionRankHelper.getAdmin(), getMainMenu().getPermissions())) {
					accountService.deactiveateAccount(account);
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
