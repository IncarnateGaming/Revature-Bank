package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.AccountRequestUsers;

public interface AccountRequestUsersDAO {
	//SECTION: variables
	//SECTION: constructors
	//SECTION: getters & setters
	//SECTION: methods
	List<AccountRequestUsers> listAccountRequest();
	AccountRequestUsers getAccountRequest(int accountRequestUsersId);
	boolean updateAccountRequest(AccountRequestUsers accountRequestUsersToUpdate);
	boolean saveAccountRequest(AccountRequestUsers accountRequestUsersToSave);
	boolean deleteAccountRequest(AccountRequestUsers accountRequestUsersToDelete);
	boolean deleteAccountRequest(int accountRequestUsersId);
	/**
	 * Gets the highest id for the AccountRequestUsers objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
	//SECTION: hash && equals
	//SECTION: toString
}
