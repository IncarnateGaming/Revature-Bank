package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.Account;
import com.revature.bank.model.AccountTransaction;
import com.revature.bank.model.Person;

public interface AccountTransactionDAO {
	boolean createDeposit(Account account, double value);
	boolean createWithdraw(Account account, double value);
	boolean createTransfer(Account originAccount, Account targetAccount, double value);

	List<AccountTransaction> list();
	List<AccountTransaction> list(Person person);
	List<AccountTransaction> list(Account account);
	AccountTransaction get(int accountTransactionId);

	/**
	 * Gets the highest id for the AccountTransaction objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
}
