package com.revature.bank.services.handlers;

import com.revature.bank.dao.DAOUtilities;
import com.revature.bank.dao.interfaces.AccountTransactionDAO;
import com.revature.bank.model.Account;
import com.revature.bank.model.AccountTransaction;

public class TransactionHandler {
	private AccountTransactionDAO repository;
	public TransactionHandler() {
		super();
		this.repository = DAOUtilities.getAccountTransactionDao();
	}
	public TransactionHandler(AccountTransactionDAO repository) {
		super();
		this.repository = repository;
	}
	public static boolean newDeposit(Account account, double amount, AccountTransaction person) {
		return false;
	}
	public static boolean newWithdraw(Account account, double amount, AccountTransaction person) {
		return false;
	}
	public static boolean newTransfer(Account originAccount, Account targetAccount, double amount, AccountTransaction person) {
		return false;
	}
}
