package com.bank.testing.services.menus;

import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Test;

import com.bank.testing.TestingHelper;
import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.ReturnMainMenu;
import com.revature.bank.services.menus.CreateAccountMenu;
import com.revature.bank.services.menus.CustomerMenu;
import com.revature.bank.services.menus.ListAccountsMenu;
import com.revature.bank.services.menus.ListAssociatedAccountsMenu;
import com.revature.bank.services.menus.MainMenu;
import com.revature.bank.services.menus.ModifyUserMenu;
import com.revature.bank.services.menus.RequestAccountsMenu;

public class CustomerMenuTest {
	public Scanner s;
	public MainMenu mainMenu = new MainMenu();

	@Test
	public void UpMenu() throws ForceCloseThread, ReturnMainMenu {
		s = TestingHelper.changeBuffer("bob   test\r\n0\r\n");
		assertTrue(new CustomerMenu(mainMenu,s).menuFactory() == null);
	}
	@Test
	public void ModifyUserTest() throws ForceCloseThread, ReturnMainMenu {
		s = TestingHelper.changeBuffer("bob   test\r\n15\r\n1\r\n");
		assertTrue(new CustomerMenu(mainMenu,s).menuFactory() instanceof ModifyUserMenu);
	}
	@Test
	public void ListAccountsTest() throws ForceCloseThread, ReturnMainMenu {
		s = TestingHelper.changeBuffer("bob   test\r\n2\r\n");
		assertTrue(new CustomerMenu(mainMenu,s).menuFactory() instanceof ListAccountsMenu);
	}
	@Test
	public void RequestAccountsTest() throws ForceCloseThread, ReturnMainMenu {
		s = TestingHelper.changeBuffer("bob   test\r\n3\r\n");
		assertTrue(new CustomerMenu(mainMenu,s).menuFactory() instanceof RequestAccountsMenu);
	}
	@Test
	public void CreateAccountTest() throws ForceCloseThread, ReturnMainMenu {
		s = TestingHelper.changeBuffer("bob   test\r\n4\r\n");
		assertTrue(new CustomerMenu(mainMenu,s).menuFactory() instanceof CreateAccountMenu);
	}
	@Test
	public void ListAccountsTest2() throws ForceCloseThread, ReturnMainMenu {
		s = TestingHelper.changeBuffer("bob   test\r\n5\r\n");
		assertTrue(new CustomerMenu(mainMenu,s).menuFactory() instanceof ListAssociatedAccountsMenu);
	}

}
