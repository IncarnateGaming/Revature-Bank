package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.AssociatedPeople;

public interface AssociatedPeopleDAO {
	AssociatedPeople create(AssociatedPeople associatedPeopleToSave);

	List<AssociatedPeople> list();
	AssociatedPeople get(int associatedPeopleId);

	AssociatedPeople update(AssociatedPeople associatedPeopleToUpdate);

	AssociatedPeople delete(AssociatedPeople associatedPeopleToDelete);
	AssociatedPeople delete(int associatedPeopleId);
	/**
	 * Gets the highest id for the AssociatedPeople objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
}
