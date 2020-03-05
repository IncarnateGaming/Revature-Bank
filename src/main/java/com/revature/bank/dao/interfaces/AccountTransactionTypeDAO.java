package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.AccountTransactionType;

public interface AccountTransactionTypeDAO {
	AccountTransactionType create(AccountTransactionType accountTransactionTypeToSave);

	List<AccountTransactionType> list();
	AccountTransactionType get(int accountTransactionTypeId);

	AccountTransactionType update(AccountTransactionType accountTransactionTypeToUpdate);

	AccountTransactionType delete(AccountTransactionType accountTransactionTypeToDelete);
	AccountTransactionType delete(int accountTransactionTypeId);
	/**
	 * Gets the highest id for the AccountTransactionType objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
}
