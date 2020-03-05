package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.PersonStanding;

public interface PersonStandingDAO {
	PersonStanding create(PersonStanding personStandingToSave);

	List<PersonStanding> list();
	PersonStanding get(int personStandingId);

	PersonStanding update(PersonStanding personStandingToUpdate);

	PersonStanding delete(PersonStanding personStandingToDelete);
	PersonStanding delete(int personStandingId);
	/**
	 * Gets the highest id for the PersonStanding objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
}
