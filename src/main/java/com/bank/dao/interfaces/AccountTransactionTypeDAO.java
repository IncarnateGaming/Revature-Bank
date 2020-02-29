package com.bank.dao.interfaces;

import java.util.List;

import com.bank.model.AccountTransactionType;

public interface AccountTransactionTypeDAO {
	//SECTION: variables
	//SECTION: constructors
	//SECTION: getters & setters
	//SECTION: methods
	List<AccountTransactionType> listAccountTransactionType();
	AccountTransactionType getAccountTransactionType(int accountTransactionTypeId);
	boolean updateAccountTransactionType(AccountTransactionType accountTransactionTypeToUpdate);
	boolean saveAccountTransactionType(AccountTransactionType accountTransactionTypeToSave);
	boolean deleteAccountTransactionType(AccountTransactionType accountTransactionTypeToDelete);
	boolean deleteAccountTransactionType(int accountTransactionTypeId);
	/**
	 * Gets the highest id for the AccountTransactionType objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
	//SECTION: hash && equals
	//SECTION: toString
}
