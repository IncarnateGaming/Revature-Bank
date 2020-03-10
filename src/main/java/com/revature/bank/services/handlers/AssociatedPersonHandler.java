package com.revature.bank.services.handlers;

import java.util.List;

import com.revature.bank.dao.DAOUtilities;
import com.revature.bank.dao.interfaces.AssociatedPeopleDAO;
import com.revature.bank.model.AssociatedPeople;
import com.revature.bank.model.Person;

public class AssociatedPersonHandler {
	private AssociatedPeopleDAO repository;
	public AssociatedPersonHandler() {
		super();
		this.repository = DAOUtilities.getAssociatedPeopleDao();
	}
	public AssociatedPersonHandler(AssociatedPeopleDAO repository) {
		super();
		this.repository = repository;
	}
	public AssociatedPeople create(Person person1, Person person2) {
		return repository.create(person1, person2);
	}
	public AssociatedPeople create(AssociatedPeople associatedPeopleToCreate) {
		return repository.create(associatedPeopleToCreate);
	}
	public List<AssociatedPeople> list() {
		return repository.list();
	}
	public List<Integer> list(Person person){
		return repository.list(person);
	}
	public boolean check(Person person1, Person person2) {
		return repository.check(person1, person2);
	}
	public boolean delete(AssociatedPeople associatedPeopleToDelete) {
		return repository.delete(associatedPeopleToDelete);
	}
	public boolean delete(int person1Id, int person2Id) {
		return repository.delete(person1Id, person2Id);
	}
}
