package com.revature.bank.services.buisness.logic;

import java.util.List;

import com.revature.bank.model.Account;
import com.revature.bank.model.AccountRequest;
import com.revature.bank.model.Person;
import com.revature.bank.services.handlers.AccountHandler;
import com.revature.bank.services.handlers.AccountOwnershipHandler;
import com.revature.bank.services.handlers.AccountRequestHandler;
import com.revature.bank.services.handlers.AccountRequestUserHandler;
import com.revature.bank.services.handlers.PersonHandler;
import com.revature.bank.services.helpers.LoggerSingleton;

public class ProcessAccountRequest {

	private static AccountHandler accountHandler = new AccountHandler();
	private static AccountOwnershipHandler accountOwnershipHandler = new AccountOwnershipHandler();
	private static AccountRequestHandler accountRequestHandler = new AccountRequestHandler();
	private static AccountRequestUserHandler accountRequestUserHandler = new AccountRequestUserHandler();
	private static PersonHandler personHandler = new PersonHandler();
	private ProcessAccountRequest() {
	}
	public static void approve(AccountRequest accountRequest) {
		Account newAccount = new Account(accountRequest.getAccountTypeId(), 0, 0);
		newAccount = accountHandler.create(newAccount);
		LoggerSingleton.getBusinessLog().info("Account: " + newAccount.getId() + " approved and created.");
		List<Integer> userIds = accountRequestUserHandler.list(accountRequest);
		for (Integer id : userIds) {
			Person person = personHandler.get(id);
			LoggerSingleton.getBusinessLog().info(person.getUsername() + " added to account: " + newAccount.getId());
			accountOwnershipHandler.create(newAccount, person);
		}
		accountRequestUserHandler.delete(accountRequest.getId());
		accountRequestHandler.delete(accountRequest);
	}
	public static void reject(AccountRequest accountRequest) {
		List<Integer> userIds = accountRequestUserHandler.list(accountRequest);
		LoggerSingleton.getBusinessLog().info("Account Type: " + accountRequest.getAccountTypeId() + " requested by " + userIds + " rejected.");
		accountRequestUserHandler.delete(accountRequest.getId());
		accountRequestHandler.delete(accountRequest);
	}
}
