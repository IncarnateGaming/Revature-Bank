package com.bank.dao.implementations;

import java.util.List;

import com.bank.dao.interfaces.AccountRequestUsersDAO;
import com.bank.model.AccountRequestUsers;

public class AccountRequestUsersDAOImpl implements AccountRequestUsersDAO {

	//SECTION: methods
	@Override
	public List<AccountRequestUsers> listAccountRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountRequestUsers getAccountRequest(int accountRequestUsersId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAccountRequest(AccountRequestUsers accountRequestUsersToUpdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveAccountRequest(AccountRequestUsers accountRequestUsersToSave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccountRequest(AccountRequestUsers accountRequestUsersToDelete) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccountRequest(int accountRequestUsersId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getHighestId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
