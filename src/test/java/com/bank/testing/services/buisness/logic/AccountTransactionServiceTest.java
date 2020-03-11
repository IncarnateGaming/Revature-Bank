package com.bank.testing.services.buisness.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.bank.exceptions.InsufficientFunds;
import com.revature.bank.exceptions.InsufficientLineOfCredit;
import com.revature.bank.exceptions.InvalidNegativeValue;
import com.revature.bank.model.Account;
import com.revature.bank.services.buisness.logic.AccountTransactionService;
import com.revature.bank.services.handlers.AccountHandler;
import com.revature.bank.services.handlers.AccountTransactionHandler;
import com.revature.bank.services.helpers.AccountTypeHelper;

public class AccountTransactionServiceTest {

	private static AccountTransactionService accountTransactionService;
	private static AccountHandler accountHandler;
	private static Account account;
	private static Account accountOverdraft;
	private static Account accountCredit;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		accountTransactionService = new AccountTransactionService(new AccountTransactionHandler());
		accountHandler = new AccountHandler();
		account = new Account(
				AccountTypeHelper.getChecking().getId(),
				0,0);
		account = accountHandler.create(account);
		accountOverdraft = new Account(
				AccountTypeHelper.getSavings().getId(),
				0,10000);
		accountOverdraft = accountHandler.create(accountOverdraft);
		accountCredit = new Account(
				AccountTypeHelper.getCredit().getId(),
				0,3000);
		accountCredit = accountHandler.create(accountCredit);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		account.setBalance(0);
		account = accountHandler.update(account);
		accountOverdraft.setBalance(0);
		accountOverdraft = accountHandler.update(accountOverdraft);
		accountCredit.setBalance(0);
		accountCredit = accountHandler.update(accountCredit);
	}

	@Test(expected = InvalidNegativeValue.class)
	public void test() throws InvalidNegativeValue {
		accountTransactionService.createDeposit(account, -15.32);
	}
	@Test(expected = InvalidNegativeValue.class)
	public void test2() throws InvalidNegativeValue, InsufficientLineOfCredit {
		accountTransactionService.createWithdraw(account, -15.32);
	}
	@Test(expected = InsufficientLineOfCredit.class)
	public void test3() throws InvalidNegativeValue, InsufficientLineOfCredit {
		accountTransactionService.createWithdraw(account, 15.32);
	}
	@Test(expected = InsufficientFunds.class)
	public void test4() throws InvalidNegativeValue, InsufficientLineOfCredit {
		accountTransactionService.createWithdraw(accountOverdraft, 15.32);
	}
	@Test(expected = InvalidNegativeValue.class)
	public void test5() throws InvalidNegativeValue, InsufficientLineOfCredit {
		accountTransactionService.createTransfer(account, accountOverdraft, -15.32);
	}
	@Test(expected = InsufficientLineOfCredit.class)
	public void test6() throws InvalidNegativeValue, InsufficientLineOfCredit {
		accountTransactionService.createTransfer(account, accountCredit, 15.32);
	}
	@Test(expected = InsufficientFunds.class)
	public void test7() throws InvalidNegativeValue, InsufficientLineOfCredit {
		accountTransactionService.createTransfer(accountOverdraft, account, 15.32);
	}

}
