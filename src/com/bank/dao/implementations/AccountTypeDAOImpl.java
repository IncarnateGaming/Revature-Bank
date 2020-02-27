package com.bank.dao.implementations;

import java.util.List;

import com.bank.dao.interfaces.AccountTypeDAO;
import com.bank.model.AccountType;

public class AccountTypeDAOImpl implements AccountTypeDAO {

	//SECTION: methods
	@Override
	public List<AccountType> listAccountType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountType getAccountType(int accountTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAccountType(AccountType accountTypeToUpdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveAccountType(AccountType accountTypeToSave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccountType(AccountType accountTypeToDelete) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccountType(int accountTypeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getHighestId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
