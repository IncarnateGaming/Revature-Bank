package com.bank.testing;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bank.model.Account;

class AccountTesting {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		Account a = new Account(5, 15346.42D, 7);
		a.setOverdraftProtection(500);
	}

}
