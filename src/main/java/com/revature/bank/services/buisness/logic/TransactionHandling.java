package com.revature.bank.services.buisness.logic;

import com.revature.bank.model.Account;
import com.revature.bank.model.Person;

public class TransactionHandling {
	private TransactionHandling() {
	}
	public static boolean newDeposit(Account account, double amount, Person person) {
		return false;
	}
	public static boolean newWithdraw(Account account, double amount, Person person) {
		return false;
	}
	public static boolean newTransfer(Account originAccount, Account targetAccount, double amount, Person person) {
		return false;
	}
}
