package com.bank.testing;

import org.apache.log4j.Logger;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.revature.bank.Application;

public class TestDriver {
	private static Logger log = Application.getLogger();
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(AllTests.class);
		for (Failure failure : result.getFailures()) {
			log.warn(failure.toString());
		}
		log.info(result.wasSuccessful());
	}
}
