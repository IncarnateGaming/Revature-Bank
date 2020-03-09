package com.revature.bank.services.helpers;

import com.revature.bank.model.AccountType;
import com.revature.bank.services.handlers.AccountTypeHandler;

public class AccountTypeHelper {
	private static String typeChecking = "Checking";
	private static String typeSavings = "Savings";
	private static String typeHighYield = "High Yield Savings";
	private static String typeCredit = "Credit";
	private static AccountType checking;
	private static AccountType savings;
	private static AccountType highYield;
	private static AccountType credit;
	private AccountTypeHelper() {
	}
	
	public static String getTypeChecking() {
		return typeChecking;
	}

	public static String getTypeSavings() {
		return typeSavings;
	}

	public static String getTypeHighYield() {
		return typeHighYield;
	}

	public static String getTypeCredit() {
		return typeCredit;
	}

	public static AccountType getChecking() {
		if(checking == null) {
			checking = new AccountTypeHandler().create(
					new AccountType(AccountTypeHelper.getTypeChecking(),0,0.0005)
					);
		}
		return checking;
	}

	public static AccountType getSavings() {
		if(savings == null) {
			savings = new AccountTypeHandler().create(
					new AccountType(AccountTypeHelper.getTypeSavings(),300,0.0015)
					);
		}
		return savings;
	}

	public static AccountType getHighYield() {
		if(highYield == null) {
			highYield = new AccountTypeHandler().create(
					new AccountType(AccountTypeHelper.getTypeHighYield(),50000,0.0105)
					);
		}
		return highYield;
	}

	public static AccountType getCredit() {
		if(credit == null) {
			credit = new AccountTypeHandler().create(
					new AccountType(AccountTypeHelper.getTypeCredit(),-5000,0.0000)
					);
		}
		return credit;
	}
}
