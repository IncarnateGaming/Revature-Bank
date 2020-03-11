package com.bank.testing.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.revature.bank.exceptions.InsufficientLineOfCredit;
import com.revature.bank.exceptions.InvalidNegativeValue;
import com.revature.bank.model.Account;
import com.revature.bank.model.Person;
import com.revature.bank.services.buisness.logic.AccountTransactionService;
import com.revature.bank.services.buisness.logic.PermissionRankService;
import com.revature.bank.services.handlers.AccountHandler;
import com.revature.bank.services.handlers.AccountOwnershipHandler;
import com.revature.bank.services.handlers.AssociatedPersonHandler;
import com.revature.bank.services.handlers.PermissionRankHandler;
import com.revature.bank.services.handlers.PersonHandler;
import com.revature.bank.services.helpers.AccountTypeHelper;
import com.revature.bank.services.helpers.PermissionRankHelper;

public class DataPopulation {
	private PersonHandler personHandler = new PersonHandler();
	private PermissionRankService rankService = new PermissionRankService();
	private PermissionRankHandler rankHandler = new PermissionRankHandler();
	private AccountHandler accountHandler = new AccountHandler();
	private AccountOwnershipHandler ownHandler = new AccountOwnershipHandler();
	private AccountTransactionService tranService = new AccountTransactionService();
	private AssociatedPersonHandler associatedPersonHandler = new AssociatedPersonHandler();
	private Person george;
	private Person bugs;
	private Person rudolph;
	private Person snoopy;
	private Account georgeChecking;
	private Account georgeSavings;
	private Account bugsChecking;
	private Account bugsCredit;
	private Account rudolphChecking;
	private Account rudolphHighYield;
	@Test
	public void userSetup() throws InvalidNegativeValue, InsufficientLineOfCredit {
		this.george = new Person("George", "SecurePassword1");
		if(personHandler.get(george.getUsername()) == null) {
			george = personHandler.create(george);
		}else {
			george = personHandler.get(george.getUsername());
		}
		george.setFirstName("King");
		george.setLastName("George");
		george = personHandler.update(george);
		this.bugs = new Person("Bugs", "SecurePassword1");
		if(personHandler.get(bugs.getUsername()) == null) {
			bugs = personHandler.create(bugs);
		}else {
			bugs = personHandler.get(bugs.getUsername());
		}
		bugs.setFirstName("Bugs");
		bugs.setLastName("Bunny");
		personHandler.update(bugs);
		this.rudolph = new Person("Rudolph", "SecurePassword1");
		if(personHandler.get(rudolph.getUsername()) == null) {
			rudolph = personHandler.create(rudolph);
		}else {
			rudolph = personHandler.get(rudolph.getUsername());
		}
		rudolph.setFirstName("Rudolph");
		rudolph.setLastName("RedNose");
		personHandler.update(rudolph);
		this.snoopy = new Person("Snoopy", "SecurePassword1");
		if(personHandler.get(snoopy.getUsername()) == null) {
			snoopy = personHandler.create(snoopy);
		}else {
			snoopy = personHandler.get(snoopy.getUsername());
		}
		snoopy.setFirstName("Snoopy");
		snoopy.setLastName("LongEars");
		personHandler.update(snoopy);
		associatedPersonHandler.create(george, bugs);
		associatedPersonHandler.create(george, snoopy);
		associatedPersonHandler.create(snoopy, bugs);
		assertTrue(associatedPersonHandler.check(george, bugs));
		assertFalse(associatedPersonHandler.check(george, rudolph));
		rankHandler.assign(george, PermissionRankHelper.getCustomer());
		assertTrue(rankService.containsPermission(
				PermissionRankHelper.getCustomer(), 
				rankHandler.list(george)));
		rankHandler.assign(snoopy, PermissionRankHelper.getCustomer());
		assertTrue(rankService.containsPermission(
				PermissionRankHelper.getCustomer(), 
				rankHandler.list(snoopy)));
		rankHandler.assign(bugs, PermissionRankHelper.getEmployee());
		assertTrue(rankService.containsPermission(
				PermissionRankHelper.getEmployee(), 
				rankHandler.list(bugs)));
		rankHandler.assign(rudolph, PermissionRankHelper.getAdmin());
		assertTrue(rankService.containsPermission(
				PermissionRankHelper.getAdmin(), 
				rankHandler.list(rudolph)));
		rankHandler.assign(snoopy, PermissionRankHelper.getAdmin());
		assertTrue(rankService.containsPermission(
				PermissionRankHelper.getAdmin(), 
				rankHandler.list(snoopy)));
		georgeChecking = new Account(
				AccountTypeHelper.getChecking().getId(),
				0,0);
		georgeSavings = new Account(
				AccountTypeHelper.getSavings().getId(),
				0,0);
		bugsChecking = new Account(
				AccountTypeHelper.getChecking().getId(),
				0,0);
		bugsCredit = new Account(
				AccountTypeHelper.getCredit().getId(),
				0,0);
		rudolphChecking = new Account(
				AccountTypeHelper.getChecking().getId(),
				0,0);
		rudolphHighYield = new Account(
				AccountTypeHelper.getHighYield().getId(),
				0,0);
		georgeChecking = accountHandler.create(georgeChecking);
		georgeSavings = accountHandler.create(georgeSavings);
		bugsChecking = accountHandler.create(bugsChecking);
		bugsCredit = accountHandler.create(bugsCredit);
		rudolphChecking = accountHandler.create(rudolphChecking);
		rudolphHighYield = accountHandler.create(rudolphHighYield);
		ownHandler.create(georgeChecking, george);
		ownHandler.create(georgeSavings, george);
		ownHandler.create(georgeSavings, bugs);
		ownHandler.create(georgeSavings, snoopy);
		ownHandler.create(bugsChecking, bugs);
		ownHandler.create(bugsCredit, bugs);
		ownHandler.create(bugsCredit, snoopy);
		ownHandler.create(rudolphChecking, rudolph);
		ownHandler.create(rudolphHighYield, rudolph);
		assertTrue(ownHandler.checkOwned(georgeChecking, george));
		assertTrue(ownHandler.checkOwned(georgeSavings, george));
		assertTrue(ownHandler.checkOwned(georgeSavings, bugs));//Make sure that you can have dual ownership
		assertFalse(ownHandler.checkOwned(georgeChecking, bugs));
		assertTrue(ownHandler.checkOwned(bugsChecking, bugs));
		assertTrue(ownHandler.checkOwned(bugsCredit, bugs));
		assertFalse(ownHandler.checkOwned(bugsCredit, rudolph));
		assertTrue(ownHandler.checkOwned(rudolphHighYield, rudolph));
		assertTrue(ownHandler.checkOwned(rudolphChecking, rudolph));
		assertFalse(ownHandler.checkOwned(rudolphChecking, george));
		tranService.createDeposit(georgeChecking, 500);
		tranService.createDeposit(georgeSavings, 19_500);
		tranService.createDeposit(bugsChecking, 1500);
		tranService.createDeposit(rudolphChecking, 3_500);
		tranService.createDeposit(rudolphHighYield, 150_000);
		tranService.createWithdraw(georgeChecking, 321.59);
		tranService.createWithdraw(bugsChecking, 19.24);
		tranService.createWithdraw(bugsCredit, 500);
		tranService.createTransfer(rudolphHighYield, rudolphChecking, 6000);
		tranService.createTransfer(bugsChecking, georgeChecking, 365.21);
		assertEquals(543.62,accountHandler.get(georgeChecking.getId()).getBalance(),0.01);
		assertEquals(19_500,accountHandler.get(georgeSavings.getId()).getBalance(),0.01);
		assertEquals(1115.55,accountHandler.get(bugsChecking.getId()).getBalance(),0.01);
		assertEquals(-500,accountHandler.get(bugsCredit.getId()).getBalance(),0.01);
		assertEquals(144_000,accountHandler.get(rudolphHighYield.getId()).getBalance(),0.01);
		assertEquals(9_500,accountHandler.get(rudolphChecking.getId()).getBalance(),0.01);
	}
}
