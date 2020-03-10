package com.revature.bank.services.buisness.logic;

import java.util.Scanner;

import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.ReturnMainMenu;
import com.revature.bank.model.Account;
import com.revature.bank.services.handlers.AccountHandler;
import com.revature.bank.services.helpers.LoggerSingleton;
import com.revature.bank.services.helpers.MenuHelper;
import com.revature.bank.services.helpers.ScannerSingleton;

public class AccountService {
	private static AccountHandler accountHandler;
	private Scanner s = ScannerSingleton.getScanner();
	public AccountService() {
		super();
		AccountService.accountHandler = new AccountHandler();
	}
	public AccountService(AccountHandler accountHandler) {
		super();
		AccountService.accountHandler = accountHandler;
	}
	public Account deactiveateAccount(Account account) throws ForceCloseThread, ReturnMainMenu {
		Account result = null;
		System.out.println("Are you sure you want to inactivate this account?(Y/N)");
		boolean confirmation = MenuHelper.inputYN(s);
		if (confirmation) {
			Account officialAccount = accountHandler.get(account.getId());
			officialAccount.setActive(false);
			result = accountHandler.update(officialAccount);
			LoggerSingleton.getLogger().info("Deactivated account number: " + officialAccount.getId());
		}
		return result;
	}
}
