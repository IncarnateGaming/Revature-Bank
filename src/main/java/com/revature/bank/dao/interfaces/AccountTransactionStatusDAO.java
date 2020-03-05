package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.AccountTransactionStatus;

public interface AccountTransactionStatusDAO {
	AccountTransactionStatus create(AccountTransactionStatus accountTransactionStatusToSave);

	List<AccountTransactionStatus> listAccountTransactionStatus();
	AccountTransactionStatus getAccountTransactionStatus(int accountTransactionStatusId);

	AccountTransactionStatus updateAccountTransactionStatus(AccountTransactionStatus accountTransactionStatusToUpdate);

	AccountTransactionStatus deleteAccountTransactionStatus(AccountTransactionStatus accountTransactionStatusToDelete);
	AccountTransactionStatus deleteAccountTransactionStatus(int accountTransactionStatusId);
	/**
	 * Gets the highest id for the AccountTransactionStatus objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
}
