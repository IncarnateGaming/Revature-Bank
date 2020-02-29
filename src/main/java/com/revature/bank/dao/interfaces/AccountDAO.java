package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.Account;
import com.revature.bank.model.Person;

public interface AccountDAO {
	//SECTION: variables
	//SECTION: constructors
	//SECTION: getters & setters
	//SECTION: methods
	List<Account> listAccounts();
	List<Account> listAccounts(Person owner);
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
