package com.revature.bank.services.handlers;

import java.util.List;

import com.revature.bank.dao.DAOUtilities;
import com.revature.bank.dao.interfaces.AccountTransactionDAO;
import com.revature.bank.model.Account;
import com.revature.bank.model.AccountTransaction;
import com.revature.bank.model.Person;

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
	public List<AccountTransaction> list(){
		return repository.list();
	}
	public List<AccountTransaction> list(Person person){
		return repository.list(person);
	}
	public List<AccountTransaction> list(Account account){
		return repository.list(account);
	}
	public AccountTransaction get(int accountTransactionId) {
		return repository.get(accountTransactionId);
	}
	public int getHighestId() {
		return repository.getHighestId();
	}
}
