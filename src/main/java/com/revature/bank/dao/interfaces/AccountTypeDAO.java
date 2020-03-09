package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.AccountType;

public interface AccountTypeDAO {
	AccountType create(AccountType accountTypeToSave);

	List<AccountType> list();
	AccountType get(int accountTypeId);

	AccountType update(AccountType accountTypeToUpdate);

	boolean delete(AccountType accountTypeToDelete);
	boolean delete(int accountTypeId);
	/**
	 * Gets the highest id for the AccountType objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
}
