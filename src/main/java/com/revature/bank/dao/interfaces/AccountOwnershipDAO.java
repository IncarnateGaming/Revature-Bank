package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.AccountOwnership;

public interface AccountOwnershipDAO {
	AccountOwnership create(AccountOwnership accountOwnershipToSave);

	List<AccountOwnership> list();
	List<AccountOwnership> list(int accountId);
	List<Integer> listIds(int accountId);
	AccountOwnership get(int accountOwnershipId);

	AccountOwnership update(AccountOwnership accountOwnershipToUpdate);

	AccountOwnership delete(AccountOwnership accountOwnershipToDelete);
	AccountOwnership delete(int accountOwnershipId);
	/**
	 * Gets the highest id for the AccountOwnershipOwnership objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
}
