package com.bank.dao.implementations;

import java.util.List;

import com.bank.dao.interfaces.AccountDAO;
import com.bank.model.Account;

public class AccountDAOImpl implements AccountDAO {

	//SECTION: methods
	@Override
	public List<Account> listAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccount(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAccount(Account accountToUpdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveAccount(Account accountToSave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccount(Account accountToDelete) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccount(int accountId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getHighestId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
