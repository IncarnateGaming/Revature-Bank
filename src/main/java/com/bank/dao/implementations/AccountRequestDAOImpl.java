package com.bank.dao.implementations;

import java.util.List;

import com.bank.dao.interfaces.AccountRequestDAO;
import com.bank.model.AccountRequest;

public class AccountRequestDAOImpl implements AccountRequestDAO {

	//SECTION: methods
	@Override
	public List<AccountRequest> listAccountRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountRequest getAccountRequest(int accountRequestId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAccountRequest(AccountRequest accountRequestToUpdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveAccountRequest(AccountRequest accountRequestToSave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccountRequest(AccountRequest accountRequestToDelete) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccountRequest(int accountRequestId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getHighestId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
