package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.AccountRequest;

public interface AccountRequestDAO {
	AccountRequest create(AccountRequest accountRequestToSave);

	List<AccountRequest> list();
	AccountRequest get(int accountRequestId);

	AccountRequest update(AccountRequest accountRequestToUpdate);

	AccountRequest delete(AccountRequest accountRequestToDelete);
	AccountRequest delete(int accountRequestId);
	/**
	 * Gets the highest id for the AccountRequest objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
}
