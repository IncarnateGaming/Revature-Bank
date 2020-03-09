package com.revature.bank.services.handlers;

import java.util.List;

import com.revature.bank.dao.implementations.AccountTypeDAOImpl;
import com.revature.bank.dao.interfaces.AccountTypeDAO;
import com.revature.bank.model.AccountType;

public class AccountTypeHandler {
	private AccountTypeDAO repository = null;
	public AccountTypeHandler() {
		super();
		this.repository = new AccountTypeDAOImpl();
	}
	public AccountTypeHandler(AccountTypeDAO repository) {
		super();
		this.repository = repository;
	}
	public AccountType create(AccountType accountTypeToCreate) {
		return repository.create(accountTypeToCreate);
	}
	public List<AccountType> list() {
		return repository.list();
	}
	public AccountType get(int accountTypeId) {
		return repository.get(accountTypeId);
	}
	public AccountType update(AccountType accountTypeToUpdate) {
		return repository.update(accountTypeToUpdate);
	}
	public boolean delete(AccountType accountTypeToDelete) {
		return repository.delete(accountTypeToDelete);
	}
	public boolean delete(int accountTypeId) {
		return repository.delete(accountTypeId);
	}
	public int getHighestId() {
		return repository.getHighestId();
	}
}
