package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.PhoneNumber;

public interface PhoneNumberDAO {
	//SECTION: variables
	//SECTION: constructors
	//SECTION: getters & setters
	//SECTION: methods
	List<PhoneNumber> listPhoneNumber();
	PhoneNumber getPhoneNumber(int phoneNumberId);
	boolean updatePhoneNumber(PhoneNumber phoneNumberToUpdate);
	boolean savePhoneNumber(PhoneNumber phoneNumberToSave);
	boolean deletePhoneNumber(PhoneNumber phoneNumberToDelete);
	boolean deletePhoneNumber(int phoneNumberId);
	/**
	 * Gets the highest id for the PhoneNumber objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
	//SECTION: hash && equals
	//SECTION: toString
}
