package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.PhoneNumber;

public interface PhoneNumberDAO {
	PhoneNumber create(PhoneNumber phoneNumberToSave);

	List<PhoneNumber> list();
	PhoneNumber get(int phoneNumberId);

	PhoneNumber update(PhoneNumber phoneNumberToUpdate);

	PhoneNumber delete(PhoneNumber phoneNumberToDelete);
	PhoneNumber delete(int phoneNumberId);
	/**
	 * Gets the highest id for the PhoneNumber objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
}
