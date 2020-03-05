package com.bank.testing.services.helpers;

import org.apache.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import com.revature.bank.services.helpers.LoggerSingleton;

public class LoggerSingletonTest {

	@Test
	public void test() {
		assertTrue(LoggerSingleton.getLogger() instanceof Logger);
	}

}
