package com.bank.dao.interfaces;

import java.util.List;

import com.bank.model.Person;

public interface PersonDAO {
	//SECTION: variables
	//SECTION: constructors
	//SECTION: getters & setters
	//SECTION: methods
	/**
	 * @return list of all persisted Person objects
	 */
	List<Person> ListPerson();
	/**
	 * @param personToSave
	 * @return boolean true if successful, false if failed
	 */
	boolean savePerson(Person personToSave);
	/**
	 * Find a Person by their id
	 * @param personId
	 * @return Person object
	 */
	Person getPerson(int personId);
	/**
	 * Find a Person by their username
	 * @param username
	 * @return Person object
	 */
	Person getPerson(String username);
	/**
	 * Find possible Person objects by their first and last name
	 * Multiple values are possible so list is returned
	 * @param firstName
	 * @param lastName
	 * @return List<Person>
	 */
	List<Person> getPerson(String firstName, String lastName);
	/**
	 * Updates a Person object within persisted memory
	 * @param personToUpdate
	 * @return boolean true if successful, false if failed
	 */
	boolean updatePerson(Person personToUpdate);
	/**
	 * Deletes a Person by a Person object
	 * @param personToDelete
	 * @return boolean true if successful, false if failed
	 */
	boolean deletePerson(Person personToDelete);
	/**
	 * Deletes a Person by an id
	 * @param personId
	 * @return boolean true if successful, false if failed
	 */
	boolean deletePerson(int personId);
	/**
	 * Gets the highest id for the Person objects in persisted memory
	 * @return
	 */
	int getHighestId();
	//SECTION: hash && equals
	//SECTION: toString

}
