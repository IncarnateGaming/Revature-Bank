package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.Account;
import com.revature.bank.model.Person;

public interface AccountDAO {
	Account create(Account accountToSave);

	List<Account> list();
	List<Account> list(Person owner);
	List<Account> listJoin();
	List<Account> listJoin(Person owner);
	List<Integer> listIds();
	Account get(int accountId);

	Account update(Account accountToUpdate);

	boolean delete(Account accountToDelete);
	boolean delete(int accountId);
	/**
	 * Gets the highest id for the Account objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();

}
