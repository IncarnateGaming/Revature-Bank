package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.PersonStanding;

public interface PersonStandingDAO {
	//SECTION: variables
	//SECTION: constructors
	//SECTION: getters & setters
	//SECTION: methods
	List<PersonStanding> listPersonStanding();
	PersonStanding getPersonStanding(int personStandingId);
	boolean updatePersonStanding(PersonStanding personStandingToUpdate);
	boolean savePersonStanding(PersonStanding personStandingToSave);
	boolean deletePersonStanding(PersonStanding personStandingToDelete);
	boolean deletePersonStanding(int personStandingId);
	/**
	 * Gets the highest id for the PersonStanding objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
	//SECTION: hash && equals
	//SECTION: toString
}
