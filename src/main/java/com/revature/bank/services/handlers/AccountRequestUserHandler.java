package com.revature.bank.services.handlers;

import java.util.List;

import com.revature.bank.dao.DAOUtilities;
import com.revature.bank.dao.interfaces.AccountRequestUsersDAO;
import com.revature.bank.model.AccountRequest;
import com.revature.bank.model.AccountRequestUsers;
import com.revature.bank.model.Person;

public class AccountRequestUserHandler {
	private AccountRequestUsersDAO repository;
	public AccountRequestUserHandler() {
		repository = DAOUtilities.getAccountRequestUsersDao();
	}
	public AccountRequestUsers create(AccountRequestUsers accountRequestUsersToCreate) {
		return repository.create(accountRequestUsersToCreate);
	}
	public List<AccountRequestUsers> list() {
		return repository.list();
	}
	public List<Integer> list(AccountRequest accountRequest){
		return repository.list(accountRequest);
	}
	public List<Integer> list(Person person){
		return repository.list(person);
	}
	public boolean check(AccountRequest accountRequest, Person person) {
		return repository.check(accountRequest, person);
	}
	public AccountRequestUsers get(AccountRequest accountRequest, Person person) {
		return repository.get(accountRequest, person);
	}
	public AccountRequestUsers get(int accountId, int personId) {
		return repository.get(accountId, personId);
	}
	public boolean delete(AccountRequestUsers accountRequestUsersToDelete) {
		return repository.delete(accountRequestUsersToDelete);
	}
	public boolean delete(int accId, int perId) {
		return repository.delete(accId, perId);
	}
	public boolean delete(int accId) {
		return repository.delete(accId);
	}
}
