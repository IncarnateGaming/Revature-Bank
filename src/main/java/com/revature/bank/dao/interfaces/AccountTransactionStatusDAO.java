package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.AccountTransactionStatus;

public interface AccountTransactionStatusDAO {
	//SECTION: variables
	//SECTION: constructors
	//SECTION: getters & setters
	//SECTION: methods
	List<AccountTransactionStatus> listAccountTransactionStatus();
	AccountTransactionStatus getAccountTransactionStatus(int accountTransactionStatusId);
	boolean updateAccountTransactionStatus(AccountTransactionStatus accountTransactionStatusToUpdate);
	boolean saveAccountTransactionStatus(AccountTransactionStatus accountTransactionStatusToSave);
	boolean deleteAccountTransactionStatus(AccountTransactionStatus accountTransactionStatusToDelete);
	boolean deleteAccountTransactionStatus(int accountTransactionStatusId);
	/**
	 * Gets the highest id for the AccountTransactionStatus objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
	//SECTION: hash && equals
	//SECTION: toString
}
