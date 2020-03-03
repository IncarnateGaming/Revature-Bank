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
	@Before
	public void setUp() throws Exception {
	}
	@Test
	public void inputInt1() {
		Scanner s = TestingHelper.changeBuffer("bob   test\r\n15\r\n");
		int value = 0;
		try {
			value = MenuHelper.inputInt(s);
		} catch (ForceCloseThread | ReturnMainMenu e) {
			value = 5;
			e.printStackTrace();
		}
		assertEquals(15,value);
	}
	@Test
	public void inputInt2() {
		Scanner s = TestingHelper.changeBuffer("\r\nbob\r\n12.341\r\n14");
		int value = 0;
		try {
			value = MenuHelper.inputInt(s);
		} catch (ForceCloseThread | ReturnMainMenu e) {
			value = 5;
			e.printStackTrace();
		}
		assertEquals(14,value);
	}
	@Test(expected = ForceCloseThread.class)
	public void inputInt3() throws ForceCloseThread,ReturnMainMenu{
		Scanner s = TestingHelper.changeBuffer("EXIT\r\n");
		MenuHelper.inputInt(s);
	}
	@Test(expected = ReturnMainMenu.class)
	public void inputInt4() throws ForceCloseThread,ReturnMainMenu{
		Scanner s = TestingHelper.changeBuffer("LOGOUT\r\n");
		MenuHelper.inputInt(s);
	}
	@Test(expected = ReturnMainMenu.class)
	public void inputInt5() throws ForceCloseThread,ReturnMainMenu{
		Scanner s = TestingHelper.changeBuffer("MAIN\r\n");
		MenuHelper.inputInt(s);
	}
}
