package com.revature.bank.services.handlers;

import com.revature.bank.dao.implementations.AccountRequestDAOImpl;
import com.revature.bank.dao.interfaces.AccountRequestDAO;
import com.revature.bank.model.AccountRequest;
import com.revature.bank.model.Person;

public class AccountRequestHandler {
	private AccountRequestDAO daoAR;
	public AccountRequestHandler() {
		daoAR = new AccountRequestDAOImpl();
	}

	public AccountRequest getAccountRequest(int input) {
		return daoAR.get(input);
	}

	public Person getPerson(AccountRequest accountRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
