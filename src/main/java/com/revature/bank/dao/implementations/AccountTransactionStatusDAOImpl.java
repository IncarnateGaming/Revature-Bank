package com.revature.bank.dao.implementations;

import java.util.List;

import com.revature.bank.dao.interfaces.AccountTransactionStatusDAO;
import com.revature.bank.model.AccountTransactionStatus;

public class AccountTransactionStatusDAOImpl implements AccountTransactionStatusDAO {

	//SECTION: methods
	@Override
	public List<AccountTransactionStatus> listAccountTransactionStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountTransactionStatus getAccountTransactionStatus(int accountTransactionStatusId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAccountTransactionStatus(AccountTransactionStatus accountTransactionStatusToUpdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveAccountTransactionStatus(AccountTransactionStatus accountTransactionStatusToSave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccountTransactionStatus(AccountTransactionStatus accountTransactionStatusToDelete) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccountTransactionStatus(int accountTransactionStatusId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getHighestId() {
		// TODO Auto-generated method stub
		return 0;
	}
}
