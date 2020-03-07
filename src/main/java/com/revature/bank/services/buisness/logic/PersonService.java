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
		boolean result = true;
		if(password.length()<=10) {
			throw new InvalidPasswordChoice("Password must be at least 10 characters.");
		}else if(password.length()>30) {
			throw new InvalidPasswordChoice("Password must be 30 characters or less.");
		}else if(!password.matches(".*[a-z].*")) {
			throw new InvalidPasswordChoice("Password must contain at least one lowercase letter");
		}else if(!password.matches(".*[A-Z].*")) {
			throw new InvalidPasswordChoice("Password must contain at least one uppercase letter");
		}else if(!password.matches(".*[0-9].*")) {
			throw new InvalidPasswordChoice("Password must contain at least one number");
		}
		return result;
	}
	public Person submitNewUser(String username, String password) {
		Person personToCreate = new Person(username, password);
		return new PersonHandler().create(personToCreate);
	}
}
