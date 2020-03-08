package com.revature.bank.dao.implementations;

import java.util.List;

import com.revature.bank.dao.interfaces.AccountOwnershipDAO;
import com.revature.bank.model.AccountOwnership;

public class AccountOwnershipDAOImpl implements AccountOwnershipDAO {

	@Override
	public AccountOwnership create(AccountOwnership accountOwnershipToSave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountOwnership> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountOwnership> list(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> listIds(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountOwnership get(int accountOwnershipId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountOwnership update(AccountOwnership accountOwnershipToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(com.revature.bank.model.AccountOwnership accountOwnershipToDelete) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int accountOwnershipId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getHighestId() {
		// TODO Auto-generated method stub
		return 0;
	}
}