package com.revature.bank.services.buisness.logic;

import com.revature.bank.exceptions.InsufficientFunds;
import com.revature.bank.exceptions.InsufficientLineOfCredit;
import com.revature.bank.exceptions.InvalidNegativeValue;
import com.revature.bank.model.Account;
import com.revature.bank.model.AccountType;
import com.revature.bank.services.handlers.AccountHandler;
import com.revature.bank.services.handlers.AccountTransactionHandler;
import com.revature.bank.services.handlers.AccountTypeHandler;
import com.revature.bank.services.helpers.LoggerSingleton;
import com.revature.bank.services.helpers.MathHelper;

public class AccountTransactionService {
	private static AccountHandler accHandler;
	private static AccountTransactionHandler tranHandler;
	private static AccountTypeHandler accountTypeHandler;
	public AccountTransactionService() {
		super();
		this.tranHandler = new AccountTransactionHandler();
	}
	private static AccountHandler getAccountHandler() {
		if(accHandler == null) {
			accHandler = new AccountHandler();
		}
		return accHandler;
	}
	private static AccountTransactionHandler getAccountTransactionHandler() {
		if(tranHandler == null) {
			tranHandler = new AccountTransactionHandler();
		}
		return tranHandler;
	}
	private static AccountTypeHandler getAccountTypeHandler() {
		if(accountTypeHandler == null) {
			accountTypeHandler = new AccountTypeHandler();
		}
		return accountTypeHandler;
	}
	public AccountTransactionService(AccountTransactionHandler tranHandler) {
		super();
		this.tranHandler = tranHandler;
	}
	public boolean createDeposit(Account account, double value) throws InvalidNegativeValue {
		boolean result = false;
		if (value < 0) {
			String msg = "Deposits must be positive. " + value + " was attempted to be entered.";
			System.out.println(msg);
			throw new InvalidNegativeValue(msg);
		}else {
			LoggerSingleton.getLogger().info(MathHelper.doubleTextOut(value) + " deposited into account number: " + account.getId());
			result = getAccountTransactionHandler().createDeposit(account, value);
		}
		return result;
	}
	public boolean createWithdraw(Account account, double value) throws InvalidNegativeValue, InsufficientLineOfCredit {
		boolean result = false;
		if (value < 0) {
			String msg = "Withdraws must be positive. " + value + " was attempted to be entered.";
			System.out.println(msg);
			throw new InvalidNegativeValue(msg);
		}else {
			/*This may be an extra call to re-get the value we already have at account.getBalance
			however it provides protection against someone opening multiple sessions
			to get an old balance in the buffer, then withdrawing from each of 
			those multiple sessions*/
			Account officialAccount = getAccountHandler().get(account.getId());
			AccountType officialAccountType = getAccountTypeHandler().get(officialAccount.getAccountTypeId());
			double futureValue = officialAccount.getBalance() - value;
			if(futureValue >= officialAccountType.getMinBalance() + officialAccount.getOverdraftProtection()) {
				if(futureValue >= officialAccountType.getMinBalance()) {
					result = tranHandler.createWithdraw(officialAccount, value);
					LoggerSingleton.getLogger().info(MathHelper.doubleTextOut(value) + " withdrawn from "
							+ "account number: " + officialAccount.getId());
				}else {
					System.out.println("WARNING: withdrawing " + MathHelper.doubleTextOut(value) + " from "
							+ "your account will result in you becoming overdrawn. You will be assessed a fee "
							+ "each day your account is overdrawn, so make sure to deposit more money by the end "
							+ "of the buisness day.");
					tranHandler.createWithdraw(officialAccount, value);
					LoggerSingleton.getLogger().info(MathHelper.doubleTextOut(value) + " withdrawn from "
							+ "account number: " + officialAccount.getId() + " This account is currently overdrawn.");
					throw new InsufficientFunds("Warning issued that account: " + officialAccount.getId() + " is overdrawn "
							+ "and will begin to assess daily fees.");
				}
			}else {
				System.out.println("Insufficient line of credit. Your combined balance: " + MathHelper.doubleTextOut(officialAccount.getBalance()) 
				+ " and overdraft protection: " + MathHelper.doubleTextOut(officialAccount.getOverdraftProtection()) + 
				". Remember that " + officialAccountType.getLabel() + " accounts have a minimum balance of " + MathHelper.doubleTextOut(officialAccountType.getMinBalance())
				+ " preventing you from withdrawing " + MathHelper.doubleTextOut(value) + " when your account only"
				+ " has " + MathHelper.doubleTextOut(officialAccount.getBalance()) + " in it.");
				throw new InsufficientLineOfCredit("Attempt to withdraw "+ MathHelper.doubleTextOut(value) + 
						" from account: " + officialAccount.getId());
			}
		}
		return result;
	}
	public boolean createTranfer(Account originAccount, Account targetAccount, double value) {
		return tranHandler.createTransfer(originAccount, targetAccount, value);
	}

}
