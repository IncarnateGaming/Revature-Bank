package com.bank.testing.services.helpers;

import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Test;

import com.revature.bank.services.helpers.ScannerSingleton;

public class ScannerSingletonTest {

	@Test
	public void test() {
		assertTrue(ScannerSingleton.getScanner() instanceof Scanner);
	}

}
