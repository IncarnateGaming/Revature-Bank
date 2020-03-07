package com.bank.testing.services.buisness.logic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.revature.bank.exceptions.InvalidPasswordChoice;
import com.revature.bank.model.Person;
import com.revature.bank.services.buisness.logic.PersonService;
import com.revature.bank.services.handlers.PersonHandler;

public class PersonServiceTest {
	private PersonService personService = new PersonService();
	private PersonHandler personHandler = new PersonHandler();
	@Test
	public void newPerson() {
		Person bob = personHandler.get("BobTheGreat");
		if(bob != null) {
			personHandler.delete(bob);
		}
		bob = personService.submitNewUser("BobTheGreat", "BobIsAwesome");
		assertTrue(personService.usernameTaken("BobTheGreat"));
	}
	@Test
	public void usernameAvailable() {
		Person bob = personHandler.get("BobTheGreat");
		if(bob != null) {
			personHandler.delete(bob);
		}
		assertFalse(personService.usernameTaken("BobTheGreat"));
	}
	@Test(expected = InvalidPasswordChoice.class)
	public void invalidPassword1() throws InvalidPasswordChoice{
		personService.passwordAccepted("too_short");
	}
	@Test(expected = InvalidPasswordChoice.class)
	public void invalidPassword2() throws InvalidPasswordChoice{
		personService.passwordAccepted("too_long_long_long_long_long_lo");
	}
	@Test(expected = InvalidPasswordChoice.class)
	public void invalidPassword3() throws InvalidPasswordChoice{
		personService.passwordAccepted("ALL_UPPER_IS_NO_GOOD");
	}
	@Test(expected = InvalidPasswordChoice.class)
	public void invalidPassword4() throws InvalidPasswordChoice{
		personService.passwordAccepted("all_lowercase_is_no_good");
	}
	@Test(expected = InvalidPasswordChoice.class)
	public void invalidPassword5() throws InvalidPasswordChoice{
		personService.passwordAccepted("NeedToIncludeNumbersToo");
	}
	@Test
	public void invalidPassword6() throws InvalidPasswordChoice{
		assertTrue(personService.passwordAccepted("Finally4AGoodPassword"));
	}
}
