package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.Address;

public interface AddressDAO {
	//SECTION: variables
	//SECTION: constructors
	//SECTION: getters & setters
	//SECTION: methods
	List<Address> listAddress();
	Address getAddress(int addressId);
	boolean updateAddress(Address addressToUpdate);
	boolean saveAddress(Address addressToSave);
	boolean deleteAddress(Address addressToDelete);
	boolean deleteAddress(int addressId);
	/**
	 * Gets the highest id for the Address objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
	//SECTION: hash && equals
	//SECTION: toString
}
