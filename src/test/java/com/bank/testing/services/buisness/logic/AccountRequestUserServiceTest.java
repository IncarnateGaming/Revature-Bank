package com.bank.testing.services.buisness.logic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.bank.model.AccountRequest;
import com.revature.bank.model.Person;
import com.revature.bank.services.buisness.logic.AccountRequestUserService;
import com.revature.bank.services.handlers.AccountRequestHandler;
import com.revature.bank.services.handlers.AccountRequestUserHandler;
import com.revature.bank.services.handlers.PersonHandler;
import com.revature.bank.services.helpers.AccountTypeHelper;

public class AccountRequestUserServiceTest {

	private static AccountRequestUserHandler accountRequestUserHandler;
	private static AccountRequestUserService accountRequestUserService;
	private static AccountRequestHandler accountRequestHandler;
	private static PersonHandler personHandler;
	private static Person george;
	private static Person bugs;
	private static Person rudolph;
	private static Person snoopy;
	private static AccountRequest request1;
	private static AccountRequest request2;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		accountRequestUserHandler = new AccountRequestUserHandler();
		accountRequestUserService = new AccountRequestUserService(new AccountRequestUserHandler());
		personHandler = new PersonHandler();
		accountRequestHandler = new AccountRequestHandler();
		george = new Person("George", "SecurePassword1");
		if(personHandler.get(george.getUsername()) == null) {
			george = personHandler.create(george);
		}else {
			george = personHandler.get(george.getUsername());
		}
		bugs = new Person("Bugs", "SecurePassword1");
		if(personHandler.get(bugs.getUsername()) == null) {
			bugs = personHandler.create(bugs);
		}else {
			bugs = personHandler.get(bugs.getUsername());
		}
		rudolph = new Person("Rudolph", "SecurePassword1");
		if(personHandler.get(rudolph.getUsername()) == null) {
			rudolph = personHandler.create(rudolph);
		}else {
			rudolph = personHandler.get(rudolph.getUsername());
		}
		snoopy = new Person("Snoopy", "SecurePassword1");
		if(personHandler.get(snoopy.getUsername()) == null) {
			snoopy = personHandler.create(snoopy);
		}else {
			snoopy = personHandler.get(snoopy.getUsername());
		}
		request1 = new AccountRequest(AccountTypeHelper.getChecking().getId());
		request1 = accountRequestHandler.create(request1);
		request2 = new AccountRequest(AccountTypeHelper.getHighYield().getId());
		request2 = accountRequestHandler.create(request2);
	}
	@Test
	public void testFails() {
		assertFalse(accountRequestUserHandler.check(request1, bugs));
		assertFalse(accountRequestUserHandler.check(request1, rudolph));
		assertFalse(accountRequestUserHandler.check(request2, bugs));
		assertFalse(accountRequestUserHandler.check(request2, rudolph));
	}
	@Test
	public void testSuccess() {
		accountRequestUserService.addUserToRequest(request1, bugs);
		accountRequestUserService.addUserToRequest(request1, rudolph);
		assertTrue(accountRequestUserHandler.check(request1, bugs));
		assertTrue(accountRequestUserHandler.check(request1, rudolph));
		assertFalse(accountRequestUserHandler.check(request2, bugs));
		assertFalse(accountRequestUserHandler.check(request2, rudolph));
	}

}
