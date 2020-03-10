package com.revature.bank.services.handlers;

import com.revature.bank.dao.DAOUtilities;
import com.revature.bank.dao.interfaces.AssociatedPeopleDAO;
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
	public static void create(Person associatedPerson, Person newPerson) {
		// TODO Auto-generated method stub
		
	}

}
