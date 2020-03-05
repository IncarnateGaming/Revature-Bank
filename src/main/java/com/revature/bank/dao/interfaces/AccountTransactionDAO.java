package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.AccountTransaction;

public interface AccountTransactionDAO {
	AccountTransaction create(AccountTransaction accountTransactionToSave);

	List<AccountTransaction> list();
	AccountTransaction get(int accountTransactionId);

	AccountTransaction update(AccountTransaction accountTransactionToUpdate);

	AccountTransaction delete(AccountTransaction accountTransactionToDelete);
	AccountTransaction delete(int accountTransactionId);
	/**
	 * Gets the highest id for the AccountTransaction objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
}
