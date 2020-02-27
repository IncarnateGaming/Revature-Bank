package com.bank.dao.interfaces;

import java.util.List;

import com.bank.model.AssociatedPeople;

public interface AssociatedPeopleDAO {
	//SECTION: variables
	//SECTION: constructors
	//SECTION: getters & setters
	//SECTION: methods
	List<AssociatedPeople> listAssociatedPeople();
	AssociatedPeople getAssociatedPeople(int associatedPeopleId);
	boolean updateAssociatedPeople(AssociatedPeople associatedPeopleToUpdate);
	boolean saveAssociatedPeople(AssociatedPeople associatedPeopleToSave);
	boolean deleteAssociatedPeople(AssociatedPeople associatedPeopleToDelete);
	boolean deleteAssociatedPeople(int associatedPeopleId);
	/**
	 * Gets the highest id for the AssociatedPeople objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
	//SECTION: hash && equals
	//SECTION: toString
}
