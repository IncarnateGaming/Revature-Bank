package com.revature.bank.services.handlers;

import java.util.List;

import com.revature.bank.dao.implementations.AccountTransactionDAOImpl;
import com.revature.bank.dao.interfaces.AccountTransactionDAO;
import com.revature.bank.model.Account;
import com.revature.bank.model.AccountTransaction;
import com.revature.bank.model.Person;

public class AccountTransactionHandler {
	private AccountTransactionDAO repository = null;
	public AccountTransactionHandler() {
		super();
		this.repository = new AccountTransactionDAOImpl();
	}
	public AccountTransactionHandler(AccountTransactionDAO repository) {
		super();
		this.repository = repository;
	}
	public boolean createDeposit(Account account, double value) {
		return repository.createDeposit(account, value);
	}
	public boolean createWithdraw(Account account, double value) {
		return repository.createWithdraw(account, value);
	}
	public boolean createTransfer(Account originAccount, Account targetAccount, double value) {
		return repository.createTransfer(originAccount, targetAccount, value);
	}
	public List<AccountTransaction> list() {
		return repository.list();
	}
	public List<AccountTransaction> list(Person person) {
		return repository.list(person);
	}
	public List<AccountTransaction> list(Account account) {
		return repository.list(account);
	}
	public AccountTransaction get(int accountTransactionId) {
		return repository.get(accountTransactionId);
	}
	public AccountTransaction update(AccountTransaction accountTransactionToUpdate) {
		return repository.update(accountTransactionToUpdate);
	}
	public boolean delete(AccountTransaction accountTransactionToDelete) {
		return repository.delete(accountTransactionToDelete);
	}
	public boolean delete(int accountTransactionId) {
		return repository.delete(accountTransactionId);
	}
	public int getHighestId() {
		return repository.getHighestId();
	}
}
