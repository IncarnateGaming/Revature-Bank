package com.revature.bank.services.handlers;

import com.revature.bank.model.Person;

public class PersonHandler {
	private PersonHandler() {
	}
	/**
	 * Tests to see if a username is already in use. If so returns true otherwise false
	 * @param username
	 * @return boolean
	 */
	public static boolean usernameTaken(String username) {
		//TODO add buisness logic
		return false;
	}
	public static boolean passwordAccepted(String password) {
		// TODO Auto-generated method stub
		return true;
	}
	public static Person submitNewUser(String username, String password) {
		//TODO add logic
		return null;
	}
}
