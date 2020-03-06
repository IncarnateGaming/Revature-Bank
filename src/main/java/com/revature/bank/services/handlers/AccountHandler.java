package com.revature.bank.services.handlers;

import java.util.List;

import com.revature.bank.dao.implementations.AccountDAOImpl;
import com.revature.bank.dao.interfaces.AccountDAO;
import com.revature.bank.model.Account;
import com.revature.bank.model.Person;

public class AccountHandler {
	private AccountDAO repository = null;
	public AccountHandler() {
		super();
		this.repository = new AccountDAOImpl();
	}
	public AccountHandler(AccountDAO repository) {
		super();
		this.repository = repository;
	}
	public Account create(Account accountToCreate) {
		return repository.create(accountToCreate);
	}
	public List<Account> list() {
		return repository.list();
	}
	public List<Account> list(Person owner) {
		return repository.list(owner);
	}
	public List<Integer> listIds(){
		return repository .listIds();
	}
	public Account get(int accountId) {
		return repository.get(accountId);
	}
	public Account update(Account accountToUpdate) {
		return repository.update(accountToUpdate);
	}
	public boolean delete(Account accountToDelete) {
		return repository.delete(accountToDelete);
	}
	public boolean delete(int accountId) {
		return repository.delete(accountId);
	}
	public int getHighestId() {
		return repository.getHighestId();
	}
}
