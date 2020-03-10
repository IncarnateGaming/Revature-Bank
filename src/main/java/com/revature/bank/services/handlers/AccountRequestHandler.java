package com.revature.bank.services.handlers;

import com.revature.bank.dao.DAOUtilities;
import com.revature.bank.dao.interfaces.AccountRequestDAO;
import com.revature.bank.model.AccountRequest;
import com.revature.bank.model.Person;

public class AccountRequestHandler {
	private AccountRequestDAO repository;
	public AccountRequestHandler() {
		repository = DAOUtilities.getAccountRequestDao();
	}

	public AccountRequest getAccountRequest(int input) {
		return repository.get(input);
	}

	public Person getPerson(AccountRequest accountRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
