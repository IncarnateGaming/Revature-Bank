package com.bank.testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.bank.testing.services.helpers.MenuHelperTest;

@RunWith(Suite.class)
@SuiteClasses({
	MenuHelperTest.class
	})
public class AllTests {
}
