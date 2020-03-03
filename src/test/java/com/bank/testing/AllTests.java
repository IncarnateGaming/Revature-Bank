package com.bank.testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.bank.testing.entity.AccountTest;
import com.bank.testing.services.helpers.MenuHelperTest;

@RunWith(Suite.class)
@SuiteClasses({
	AccountTest.class,
	MenuHelperTest.class
	})
public class AllTests {
}
