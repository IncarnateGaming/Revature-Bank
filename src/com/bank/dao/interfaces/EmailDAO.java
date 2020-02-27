package com.bank.dao.interfaces;

import java.util.List;

import com.bank.model.Email;

public interface EmailDAO {
	//SECTION: variables
	//SECTION: constructors
	//SECTION: getters & setters
	//SECTION: methods
	List<Email> listEmail();
	Email getEmail(int emailId);
	boolean updateEmail(Email emailToUpdate);
	boolean saveEmail(Email emailToSave);
	boolean deleteEmail(Email emailToDelete);
	boolean deleteEmail(int emailId);
	/**
	 * Gets the highest id for the Email objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
	//SECTION: hash && equals
	//SECTION: toString
}
