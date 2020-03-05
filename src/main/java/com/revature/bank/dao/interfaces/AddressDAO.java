package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.Address;

public interface AddressDAO {
	Address create(Address addressToSave);

	List<Address> list();

	Address get(int addressId);
	Address update(Address addressToUpdate);

	Address delete(Address addressToDelete);
	Address delete(int addressId);
	/**
	 * Gets the highest id for the Address objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
}
