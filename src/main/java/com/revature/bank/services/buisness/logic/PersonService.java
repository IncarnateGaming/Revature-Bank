package com.revature.bank.services.buisness.logic;

import com.revature.bank.exceptions.InvalidPasswordChoice;
import com.revature.bank.model.Person;
import com.revature.bank.services.handlers.PersonHandler;

public class PersonService {
	private PersonHandler personHandler;
	public PersonService() {
		super();
		personHandler = new PersonHandler();
	}
	public PersonService(PersonHandler personHandler) {
		super();
		this.personHandler = personHandler;
	}
	/**
	 * Tests to see if a username is already in use. If so returns true otherwise false
	 * @param username
	 * @return boolean
	 */
	public boolean usernameTaken(String username) {
		boolean result = true;
		if(personHandler.get(username) == null) {
			result = false;
		}
		return result;
	}
	public boolean passwordAccepted(String password) throws InvalidPasswordChoice {
		String msg;
		boolean result = true;
		if(password.length()<=10) {
			msg = "Password must be at least 10 characters.";
			System.out.println(msg);
			throw new InvalidPasswordChoice(msg);
		}else if(password.length()>30) {
			msg = "Password must be 30 characters or less.";
			System.out.println(msg);
			throw new InvalidPasswordChoice(msg);
		}else if(!password.matches(".*[a-z].*")) {
			msg = "Password must contain at least one lowercase letter.";
			System.out.println(msg);
			throw new InvalidPasswordChoice(msg);
		}else if(!password.matches(".*[A-Z].*")) {
			msg = "Password must contain at least one uppercase letter";
			System.out.println(msg);
			throw new InvalidPasswordChoice(msg);
		}else if(!password.matches(".*[0-9].*")) {
			msg = "Password must contain at least one number";
			System.out.println(msg);
			throw new InvalidPasswordChoice(msg);
		}
		return result;
	}
	public Person submitNewUser(String username, String password) {
		Person personToCreate = new Person(username, password);
		return new PersonHandler().create(personToCreate);
	}
}
