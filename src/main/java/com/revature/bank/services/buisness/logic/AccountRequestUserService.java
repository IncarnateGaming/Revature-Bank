package com.revature.bank.services.buisness.logic;

import com.revature.bank.model.AccountRequest;
import com.revature.bank.model.AccountRequestUsers;
import com.revature.bank.model.Person;
import com.revature.bank.services.handlers.AccountRequestUserHandler;

public class AccountRequestUserService {
	private AccountRequestUserHandler accountRequestUserHandler;
	public AccountRequestUserService() {
		super();
		this.accountRequestUserHandler = new AccountRequestUserHandler();
	}
	public AccountRequestUserService(AccountRequestUserHandler accountRequestUserHandler) {
		super();
		this.accountRequestUserHandler = accountRequestUserHandler;
	}
	public boolean addUserToRequest(AccountRequest accountRequest, Person person) {
		boolean result = false;
		AccountRequestUsers accountRequestUsers = new AccountRequestUsers(person.getId(), accountRequest.getId());
		accountRequestUsers = accountRequestUserHandler.create(accountRequestUsers);
		if(accountRequestUsers != null) {
			result = true;
		}
		return result;
	}
}
