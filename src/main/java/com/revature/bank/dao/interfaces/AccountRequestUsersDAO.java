package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.AccountRequest;
import com.revature.bank.model.AccountRequestUsers;
import com.revature.bank.model.Person;

public interface AccountRequestUsersDAO {
	AccountRequestUsers create(AccountRequestUsers accountRequestUsersToSave);

	List<AccountRequestUsers> list();
	List<Integer> list(AccountRequest accountRequest);
	List<Integer> list(Person person);
	AccountRequestUsers get(AccountRequest accountRequest, Person person);
	AccountRequestUsers get(int accountId, int personId);

	boolean delete(AccountRequestUsers accountRequestUsersToDelete);
	boolean delete(int accId, int perId);
	boolean delete(int accId);
}
