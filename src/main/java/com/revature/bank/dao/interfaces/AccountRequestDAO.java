package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.AccountRequest;

public interface AccountRequestDAO {
	//SECTION: variables
	//SECTION: constructors
	//SECTION: getters & setters
	//SECTION: methods
	List<AccountRequest> listAccountRequest();
	AccountRequest getAccountRequest(int accountRequestId);
	boolean updateAccountRequest(AccountRequest accountRequestToUpdate);
	boolean saveAccountRequest(AccountRequest accountRequestToSave);
	boolean deleteAccountRequest(AccountRequest accountRequestToDelete);
	boolean deleteAccountRequest(int accountRequestId);
	/**
	 * Gets the highest id for the AccountRequest objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
	//SECTION: hash && equals
	//SECTION: toString
}
