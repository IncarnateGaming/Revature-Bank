package com.revature.bank.services.buisness.logic;

import java.util.ArrayList;
import java.util.List;

import com.revature.bank.model.Person;
import com.revature.bank.services.handlers.AssociatedPersonHandler;
import com.revature.bank.services.handlers.PersonHandler;

public class AssociatePersonService {
	private AssociatedPersonHandler associatedPersonHandler;
	public AssociatePersonService() {
		super();
		this.associatedPersonHandler = new AssociatedPersonHandler();
	}
	public AssociatePersonService(AssociatedPersonHandler associatedPersonHandler) {
		super();
		this.associatedPersonHandler = associatedPersonHandler;
	}
	public List<Person> getPeople(Person person) {
		List<Integer> listIds = associatedPersonHandler.list(person);
		List<Person> result = new ArrayList<>();
		for (Integer integer : listIds) {
			result.add(new PersonHandler().get(integer));
		}
		return result;
	}
}
