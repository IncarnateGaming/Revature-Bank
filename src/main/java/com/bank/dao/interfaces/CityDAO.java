package com.bank.dao.interfaces;

import java.util.List;

import com.bank.model.City;

public interface CityDAO {
	//SECTION: variables
	//SECTION: constructors
	//SECTION: getters & setters
	//SECTION: methods
	List<City> listCity();
	City getCity(int cityId);
	boolean updateCity(City cityToUpdate);
	boolean saveCity(City cityToSave);
	boolean deleteCity(City cityToDelete);
	boolean deleteCity(int cityId);
	/**
	 * Gets the highest id for the City objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
	//SECTION: hash && equals
	//SECTION: toString
}
