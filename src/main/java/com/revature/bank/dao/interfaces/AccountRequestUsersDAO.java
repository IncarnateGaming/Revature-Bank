package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.AccountRequestUsers;

public interface AccountRequestUsersDAO {
	AccountRequestUsers create(AccountRequestUsers accountRequestUsersToSave);

	List<AccountRequestUsers> list();
	AccountRequestUsers get(int accountRequestUsersId);

	AccountRequestUsers update(AccountRequestUsers accountRequestUsersToUpdate);

	AccountRequestUsers delete(AccountRequestUsers accountRequestUsersToDelete);
	AccountRequestUsers delete(int accountRequestUsersId);
	/**
	 * Gets the highest id for the AccountRequestUsers objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
}
