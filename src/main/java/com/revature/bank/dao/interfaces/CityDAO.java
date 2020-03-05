package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.City;

public interface CityDAO {
	City create(City cityToSave);

	List<City> list();
	City get(int cityId);

	City update(City cityToUpdate);

	City delete(City cityToDelete);
	City delete(int cityId);
	/**
	 * Gets the highest id for the City objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
}
