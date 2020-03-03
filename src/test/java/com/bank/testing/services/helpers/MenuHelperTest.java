package com.bank.testing.services.helpers;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.bank.testing.TestingHelper;
import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.ReturnMainMenu;
import com.revature.bank.services.helpers.MenuHelper;
import com.revature.bank.services.helpers.ScannerSingleton;

public class MenuHelperTest {
	Scanner s = ScannerSingleton.getScanner();
	@Before
	public void setUp() throws Exception {
	}
	@Test
	public void inputInt1() {
		System.out.println("Running\r\n15\r\n");
		TestingHelper.changeBuffer("15");
		int value = 0;
		try {
			value = MenuHelper.inputInt(s);
		} catch (ForceCloseThread | ReturnMainMenu e) {
			value = 5;
			e.printStackTrace();
		}
		assertEquals(3,value);
		System.out.println(value);
	}
}
