package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.AccountTransaction;

public interface AccountTransactionDAO {
	//SECTION: variables
	//SECTION: constructors
	//SECTION: getters & setters
	//SECTION: methods
	List<AccountTransaction> listAccountTransaction();
	AccountTransaction getAccountTransaction(int accountTransactionId);
	boolean updateAccountTransaction(AccountTransaction accountTransactionToUpdate);
	boolean saveAccountTransaction(AccountTransaction accountTransactionToSave);
	boolean deleteAccountTransaction(AccountTransaction accountTransactionToDelete);
	boolean deleteAccountTransaction(int accountTransactionId);
	/**
	 * Gets the highest id for the AccountTransaction objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
	//SECTION: hash && equals
	//SECTION: toString
}
