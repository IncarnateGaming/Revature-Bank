package com.bank.testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.bank.testing.services.buisness.logic.PersonServiceTest;
import com.bank.testing.services.handlers.AccountHandlerTest;
import com.bank.testing.services.helpers.LoggerSingletonTest;
import com.bank.testing.services.helpers.MathHelperTest;
import com.bank.testing.services.helpers.MenuHelperTest;
import com.bank.testing.services.helpers.ScannerSingletonTest;
import com.bank.testing.services.menus.CustomerMenuTest;

@RunWith(Suite.class)
@SuiteClasses({
	AccountHandlerTest.class,
	CustomerMenuTest.class,
	LoggerSingletonTest.class,
	MathHelperTest.class,
	MenuHelperTest.class,
	PersonServiceTest.class,
	ScannerSingletonTest.class
	})
public class AllTests {
}
