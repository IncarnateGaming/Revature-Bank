package com.revature.bank.services.handlers;

import java.util.List;

import com.revature.bank.dao.DAOUtilities;
import com.revature.bank.dao.interfaces.PersonDAO;
import com.revature.bank.model.Person;

public class PersonHandler {
	private PersonDAO repository;
	public PersonHandler() {
		super();
		this.repository = DAOUtilities.getPersonDao();
	}
	public PersonHandler(PersonDAO repository) {
		super();
		this.repository = repository;
	}
	public Person create(Person personToCreate) {
		return repository.create(personToCreate);
	}
	public List<Person> list() {
		return repository.list();
	}
	public List<Integer> listIds(){
		return repository.listIds();
	}
	public Person get(int personId) {
		return repository.get(personId);
	}
	public Person get(String username) {
		return repository.get(username);
	}
	public Person update(Person personToUpdate) {
		return repository.update(personToUpdate);
	}
	public boolean delete(Person personToDelete) {
		return repository.delete(personToDelete);
	}
	public boolean delete(int personId) {
		return repository.delete(personId);
	}
	public int getHighestId() {
		return repository.getHighestId();
	}
}
