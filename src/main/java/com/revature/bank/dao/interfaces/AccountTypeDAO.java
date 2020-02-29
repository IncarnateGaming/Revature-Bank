package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.AccountType;

public interface AccountTypeDAO {
	//SECTION: variables
	//SECTION: constructors
	//SECTION: getters & setters
	//SECTION: methods
	List<AccountType> listAccountType();
	AccountType getAccountType(int accountTypeId);
	boolean updateAccountType(AccountType accountTypeToUpdate);
	boolean saveAccountType(AccountType accountTypeToSave);
	boolean deleteAccountType(AccountType accountTypeToDelete);
	boolean deleteAccountType(int accountTypeId);
	/**
	 * Gets the highest id for the AccountType objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
	//SECTION: hash && equals
	//SECTION: toString
}
