package com.revature.bank.dao.implementations;

import java.util.List;

import com.revature.bank.dao.interfaces.PersonDAO;
import com.revature.bank.model.Person;

public class PersonDAOImpl implements PersonDAO {

	//SECTION: methods
	@Override
	public List<Person> ListPerson() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean savePerson(Person personToSave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Person getPerson(int personId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person getPerson(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getPerson(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatePerson(Person personToUpdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePerson(Person personToDelete) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePerson(int personId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getHighestId() {
		// TODO Auto-generated method stub
		return 0;
	}

}