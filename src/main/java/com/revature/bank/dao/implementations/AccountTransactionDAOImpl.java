package com.revature.bank.dao.implementations;

import java.util.List;

import com.revature.bank.dao.interfaces.AccountTransactionDAO;
import com.revature.bank.model.AccountTransaction;

public class AccountTransactionDAOImpl implements AccountTransactionDAO {

	//SECTION: methods
	@Override
	public List<AccountTransaction> listAccountTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountTransaction getAccountTransaction(int accountTransactionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAccountTransaction(AccountTransaction accountTransactionToUpdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveAccountTransaction(AccountTransaction accountTransactionToSave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccountTransaction(AccountTransaction accountTransactionToDelete) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccountTransaction(int accountTransactionId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getHighestId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
