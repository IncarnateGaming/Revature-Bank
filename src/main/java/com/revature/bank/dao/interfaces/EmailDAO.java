package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.Email;

public interface EmailDAO {
	Email create(Email emailToSave);

	List<Email> list();
	Email get(int emailId);

	Email updateEmail(Email emailToUpdate);

	Email deleteEmail(Email emailToDelete);
	Email deleteEmail(int emailId);
	/**
	 * Gets the highest id for the Email objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
}
