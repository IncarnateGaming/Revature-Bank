package com.bank.dao.interfaces;

import java.util.List;

import com.bank.model.Account;

public interface AccountDAO {
	//SECTION: variables
	//SECTION: constructors
	//SECTION: getters & setters
	//SECTION: methods
	List<Account> listAccount();
	Account getAccount(int accountId);
	boolean updateAccount(Account accountToUpdate);
	boolean saveAccount(Account accountToSave);
	boolean deleteAccount(Account accountToDelete);
	boolean deleteAccount(int accountId);
	/**
	 * Gets the highest id for the Account objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
	//SECTION: hash && equals
	//SECTION: toString
}
