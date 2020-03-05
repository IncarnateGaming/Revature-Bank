package com.bank.testing.services.helpers;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.bank.testing.TestingHelper;
import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.ReturnMainMenu;
import com.revature.bank.services.helpers.MenuHelper;

public class MenuHelperTest {
	@Before
	public void setUp() throws Exception {
	}
	//SECTION inputInt 
	@Test
	public void inputInt1() throws ForceCloseThread, ReturnMainMenu {
		Scanner s = TestingHelper.changeBuffer("bob   test\r\n15\r\n");
		int value = MenuHelper.inputInt(s);
		assertEquals(15,value);
	}
	@Test
	public void inputInt2() throws ForceCloseThread, ReturnMainMenu {
		Scanner s = TestingHelper.changeBuffer("\r\nbob\r\n12.341\r\n14");
		int value = MenuHelper.inputInt(s);
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
	@Test
	public void inputInt6() throws ForceCloseThread, ReturnMainMenu {
		Scanner s = TestingHelper.changeBuffer("\r\nbob\r\n12.341\r\n-4");
		int value = MenuHelper.inputInt(s);
		assertEquals(-4,value);
	}
	//SECTION inputPositiveInt 
	@Test
	public void inputPosInt1() throws ForceCloseThread, ReturnMainMenu {
		Scanner s = TestingHelper.changeBuffer("bob   test\r\n15\r\n");
		int value = MenuHelper.inputPositiveInt(s);
		assertEquals(15,value);
	}
	@Test
	public void inputPosInt2() throws ForceCloseThread, ReturnMainMenu {
		Scanner s = TestingHelper.changeBuffer("\r\nbob\r\n12.341\r\n14");
		int value = MenuHelper.inputPositiveInt(s);
		assertEquals(14,value);
	}
	@Test(expected = ForceCloseThread.class)
	public void inputPosInt3() throws ForceCloseThread,ReturnMainMenu{
		Scanner s = TestingHelper.changeBuffer("EXIT\r\n");
		MenuHelper.inputPositiveInt(s);
	}
	@Test(expected = ReturnMainMenu.class)
	public void inputPosInt4() throws ForceCloseThread,ReturnMainMenu{
		Scanner s = TestingHelper.changeBuffer("LOGOUT\r\n");
		MenuHelper.inputPositiveInt(s);
	}
	@Test(expected = ReturnMainMenu.class)
	public void inputPosInt5() throws ForceCloseThread,ReturnMainMenu{
		Scanner s = TestingHelper.changeBuffer("MAIN\r\n");
		MenuHelper.inputPositiveInt(s);
	}
	@Test
	public void inputPosInt6() throws ForceCloseThread, ReturnMainMenu {
		Scanner s = TestingHelper.changeBuffer("\r\nbob\r\n12.341\r\n-4\r\n192");
		int value = MenuHelper.inputPositiveInt(s);
		assertEquals(192,value);
	}
	//Section inputPositiveDouble
	@Test
	public void inputPosDouble1() throws ForceCloseThread, ReturnMainMenu {
		Scanner s = TestingHelper.changeBuffer("bob   test\r\n15\r\n");
		double value = MenuHelper.inputPositiveDouble(s);
		assertEquals(15,value,0.0001);
	}
	@Test
	public void inputPosDouble2() throws ForceCloseThread, ReturnMainMenu {
		Scanner s = TestingHelper.changeBuffer("\r\nbob\r\n12.341\r\n14\r\n");
		double value = MenuHelper.inputPositiveDouble(s);
		assertEquals(12.341d,value,0.0001);
	}
	@Test(expected = ForceCloseThread.class)
	public void inputPosDouble3() throws ForceCloseThread,ReturnMainMenu{
		Scanner s = TestingHelper.changeBuffer("EXIT\r\n");
		MenuHelper.inputPositiveDouble(s);
	}
	@Test(expected = ReturnMainMenu.class)
	public void inputPosDouble4() throws ForceCloseThread,ReturnMainMenu{
		Scanner s = TestingHelper.changeBuffer("LOGOUT\r\n");
		MenuHelper.inputPositiveDouble(s);
	}
	@Test(expected = ReturnMainMenu.class)
	public void inputPosDouble5() throws ForceCloseThread,ReturnMainMenu{
		Scanner s = TestingHelper.changeBuffer("MAIN\r\n");
		MenuHelper.inputPositiveDouble(s);
	}
	@Test
	public void inputPosDouble6() throws ForceCloseThread, ReturnMainMenu {
		Scanner s = TestingHelper.changeBuffer("\r\nbob\r\n-4.31\r\n5.3\r\n");
		double value = MenuHelper.inputPositiveDouble(s);
		assertEquals(5.3,value,0.0001);
	}
	//SECTION string one word
	@Test
	public void inputStringOneW1() throws ForceCloseThread, ReturnMainMenu {
		Scanner s = TestingHelper.changeBuffer("b1o$b   test\r\n15\r\n");
		String value = MenuHelper.inputStringOneWord(s);
		assertEquals("bob",value);
	}
	@Test
	public void inputStringOneW2() throws ForceCloseThread, ReturnMainMenu {
		Scanner s = TestingHelper.changeBuffer("\r\nbob\r\n12.341\r\n14\r\n");
		String value = MenuHelper.inputStringOneWord(s);
		assertEquals("",value);
	}
	@Test(expected = ForceCloseThread.class)
	public void inputStringOneW3() throws ForceCloseThread,ReturnMainMenu{
		Scanner s = TestingHelper.changeBuffer("EXIT\r\n");
		MenuHelper.inputStringOneWord(s);
	}
	@Test(expected = ReturnMainMenu.class)
	public void inputStringOneW4() throws ForceCloseThread,ReturnMainMenu{
		Scanner s = TestingHelper.changeBuffer("LOGOUT\r\n");
		MenuHelper.inputStringOneWord(s);
	}
	@Test(expected = ReturnMainMenu.class)
	public void inputStringOneW5() throws ForceCloseThread,ReturnMainMenu{
		Scanner s = TestingHelper.changeBuffer("MAIN\r\n");
		MenuHelper.inputStringOneWord(s);
	}
	//SECTION inputYN
	@Test
	public void inputY1() throws ForceCloseThread, ReturnMainMenu {
		Scanner s = TestingHelper.changeBuffer("y\r\n");
		boolean value = MenuHelper.inputYN(s);
		assertEquals(true,value);
	}
	@Test
	public void inputY2() throws ForceCloseThread, ReturnMainMenu {
		Scanner s = TestingHelper.changeBuffer("bob\r\n");
		boolean value = MenuHelper.inputYN(s);
		assertEquals(false,value);
	}
	@Test(expected = ForceCloseThread.class)
	public void inputY3() throws ForceCloseThread,ReturnMainMenu{
		Scanner s = TestingHelper.changeBuffer("EXIT\r\n");
		MenuHelper.inputYN(s);
	}
	@Test(expected = ReturnMainMenu.class)
	public void inputY4() throws ForceCloseThread,ReturnMainMenu{
		Scanner s = TestingHelper.changeBuffer("LOGOUT\r\n");
		MenuHelper.inputYN(s);
	}
	@Test(expected = ReturnMainMenu.class)
	public void inputY5() throws ForceCloseThread,ReturnMainMenu{
		Scanner s = TestingHelper.changeBuffer("MAIN\r\n");
		MenuHelper.inputYN(s);
	}
	@Test
	public void inputY6() throws ForceCloseThread, ReturnMainMenu {
		Scanner s = TestingHelper.changeBuffer("yes\r\n");
		boolean value = MenuHelper.inputYN(s);
		assertEquals(true,value);
	}
	@Test
	public void inputY7() throws ForceCloseThread, ReturnMainMenu {
		Scanner s = TestingHelper.changeBuffer("true\r\n");
		boolean value = MenuHelper.inputYN(s);
		assertEquals(true,value);
	}
}
