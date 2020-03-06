package com.bank.testing.services.handlers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.bank.model.Account;
import com.revature.bank.services.handlers.AccountHandler;

public class AccountHandlerTest {
	@Test
	public void testCreate1() {
		Account newAccount = new Account(3, 50298.325, 59300);
		Account account = new AccountHandler().create(newAccount);
		assertEquals(50298.325,account.getBalance(),0.0001);
		assertEquals(59300,account.getOverdraftProtection());
	}
	@Test
	public void testCreate2() {
		Account newAccount = new Account(2, 30548.325, 45900,false);
		Account account = new AccountHandler().create(newAccount);
		assertEquals(30548.325,account.getBalance(),0.0001);
		assertEquals(45900,account.getOverdraftProtection());
	}
}
