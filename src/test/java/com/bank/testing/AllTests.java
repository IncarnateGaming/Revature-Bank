package com.bank.testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.bank.testing.services.helpers.LoggerSingletonTest;
import com.bank.testing.services.helpers.MathHelperTest;
import com.bank.testing.services.helpers.MenuHelperTest;
import com.bank.testing.services.helpers.ScannerSingletonTest;

@RunWith(Suite.class)
@SuiteClasses({
	LoggerSingletonTest.class,
	MathHelperTest.class,
	MenuHelperTest.class,
	ScannerSingletonTest.class
	})
public class AllTests {
}
