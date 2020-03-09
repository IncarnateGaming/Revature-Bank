package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.Account;
import com.revature.bank.model.AccountOwnership;
import com.revature.bank.model.Person;

public interface AccountOwnershipDAO {
	AccountOwnership create(Account account, Person owner);
	AccountOwnership create(AccountOwnership accountOwnershipToSave);

	List<AccountOwnership> list();
	List<AccountOwnership> list(int userId);
	List<Integer> listIds(int userId);
	AccountOwnership get(int accountOwnershipId);
	boolean checkOwned(Account account, Person person);

	AccountOwnership update(AccountOwnership accountOwnershipToUpdate);

	boolean delete(AccountOwnership accountOwnershipToDelete);
	boolean delete(int accountOwnershipId);
	/**
	 * Gets the highest id for the AccountOwnershipOwnership objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();

}
