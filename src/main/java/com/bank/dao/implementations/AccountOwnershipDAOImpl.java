package com.bank.dao.implementations;

import java.util.List;

import com.bank.dao.interfaces.AccountOwnershipDAO;
import com.bank.model.AccountOwnership;

public class AccountOwnershipDAOImpl implements AccountOwnershipDAO {

	//SECTION: methods
	@Override
	public List<AccountOwnership> listAccountOwnership() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<AccountOwnership> listAccountOwnership(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Integer> listAccountOwnershipIds(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public AccountOwnership getAccountOwnership(int accountOwnershipId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean updateAccountOwnership(AccountOwnership accountOwnershipToUpdate) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean saveAccountOwnership(AccountOwnership accountOwnershipToSave) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteAccountOwnership(AccountOwnership accountOwnershipToDelete) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteAccountOwnership(int accountOwnershipId) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int getHighestId() {
		// TODO Auto-generated method stub
		return 0;
	}
}