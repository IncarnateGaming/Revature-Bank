package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.AssociatedPeople;
import com.revature.bank.model.Person;

public interface AssociatedPeopleDAO {
	AssociatedPeople create(Person person1, Person person2);
	AssociatedPeople create(AssociatedPeople associatedPeopleToSave);

	List<AssociatedPeople> list();
	List<Integer> list(Person person);
	boolean check(Person person1, Person person2);

	boolean delete(AssociatedPeople associatedPeopleToDelete);
	boolean delete(int person1Id, int person2Id);
}
