package com.revature.bank.services.handlers;

import java.util.List;

import com.revature.bank.dao.DAOUtilities;
import com.revature.bank.dao.interfaces.AccountOwnershipDAO;
import com.revature.bank.model.Account;
import com.revature.bank.model.AccountOwnership;
import com.revature.bank.model.Person;

public class AccountOwnershipHandler {
	private AccountOwnershipDAO repository = null;
	public AccountOwnershipHandler() {
		super();
		this.repository = DAOUtilities.getAccountOwnershipDao();
	}
	public AccountOwnershipHandler(AccountOwnershipDAO repository) {
		super();
		this.repository = repository;
	}
	public AccountOwnership create(Account account, Person owner) {
		return repository.create(account, owner);
	}
	public AccountOwnership create(AccountOwnership accountOwnershipToCreate) {
		return repository.create(accountOwnershipToCreate);
	}
	public List<AccountOwnership> list() {
		return repository.list();
	}
	public List<AccountOwnership> list(int userId) {
		return repository.list(userId);
	}
	public List<Integer> listIds(int userId) {
		return repository.listIds(userId);
	}
	public AccountOwnership get(int accountOwnershipId) {
		return repository.get(accountOwnershipId);
	}
	public boolean checkOwned(Account account, Person person) {
		return repository.checkOwned(account, person);
	}
	public AccountOwnership update(AccountOwnership accountOwnershipToUpdate) {
		return repository.update(accountOwnershipToUpdate);
	}
	public boolean delete(AccountOwnership accountOwnershipToDelete) {
		return repository.delete(accountOwnershipToDelete);
	}
	public boolean delete(int accountOwnershipId) {
		return repository.delete(accountOwnershipId);
	}
	public int getHighestId() {
		return repository.getHighestId();
	}
}
