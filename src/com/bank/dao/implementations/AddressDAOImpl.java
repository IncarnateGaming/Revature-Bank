package com.bank.dao.implementations;

import java.util.List;

import com.bank.dao.interfaces.AddressDAO;
import com.bank.model.Address;

public class AddressDAOImpl implements AddressDAO {

	//SECTION: methods
	@Override
	public List<Address> listAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address getAddress(int addressId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAddress(Address addressToUpdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveAddress(Address addressToSave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAddress(Address addressToDelete) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAddress(int addressId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getHighestId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
