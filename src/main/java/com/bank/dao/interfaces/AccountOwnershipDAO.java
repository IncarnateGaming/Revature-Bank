package com.bank.dao.interfaces;

import java.util.List;

import com.bank.model.AccountOwnership;

public interface AccountOwnershipDAO {
	//SECTION: variables
	//SECTION: constructors
	//SECTION: getters & setters
	//SECTION: methods
	List<AccountOwnership> listAccountOwnership();
	List<AccountOwnership> listAccountOwnership(int accountId);
	List<Integer> listAccountOwnershipIds(int accountId);
	AccountOwnership getAccountOwnership(int accountOwnershipId);
	boolean updateAccountOwnership(AccountOwnership accountOwnershipToUpdate);
	boolean saveAccountOwnership(AccountOwnership accountOwnershipToSave);
	boolean deleteAccountOwnership(AccountOwnership accountOwnershipToDelete);
	boolean deleteAccountOwnership(int accountOwnershipId);
	/**
	 * Gets the highest id for the AccountOwnershipOwnership objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
	//SECTION: hash && equals
	//SECTION: toString
}
