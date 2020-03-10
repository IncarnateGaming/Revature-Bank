package com.revature.bank.services.handlers;

import java.util.List;

import com.revature.bank.dao.DAOUtilities;
import com.revature.bank.dao.interfaces.AccountRequestDAO;
import com.revature.bank.model.AccountRequest;

public class AccountRequestHandler {
	private AccountRequestDAO repository;
	public AccountRequestHandler() {
		repository = DAOUtilities.getAccountRequestDao();
	}

	public AccountRequest getAccountRequest(int input) {
		return repository.get(input);
	}

	public AccountRequest create(AccountRequest accountRequestToCreate) {
		return repository.create(accountRequestToCreate);
	}
	public List<AccountRequest> list() {
		return repository.list();
	}
	public AccountRequest get(int accountRequestId) {
		return repository.get(accountRequestId);
	}
	public AccountRequest update(AccountRequest accountRequestToUpdate) {
		return repository.update(accountRequestToUpdate);
	}
	public boolean delete(AccountRequest accountRequestToDelete) {
		return repository.delete(accountRequestToDelete);
	}
	public boolean delete(int accountRequestId) {
		return repository.delete(accountRequestId);
	}
	public int getHighestId() {
		return repository.getHighestId();
	}
}
