package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.Account;
import com.revature.bank.model.AccountRequestUsers;
import com.revature.bank.model.Person;

public interface AccountRequestUsersDAO {
	AccountRequestUsers create(AccountRequestUsers accountRequestUsersToSave);

	List<AccountRequestUsers> list();
	List<Integer> list(Account account);
	List<Integer> list(Person person);
	AccountRequestUsers get(Account account, Person person);
	AccountRequestUsers get(int accountId, int personId);

	boolean delete(AccountRequestUsers accountRequestUsersToDelete);
	boolean delete(int accId, int perId);
}
