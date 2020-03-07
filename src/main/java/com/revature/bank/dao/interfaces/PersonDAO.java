package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.Person;

public interface PersonDAO {
	/**
	 * @param personToSave
	 * @return Person true if successful, false if failed
	 */
	Person create(Person personToSave);
	/**
	 * @return list of all persisted Person objects
	 */
	List<Person> list();
	/**
	 * List all IDs for People
	 * @return list of integers
	 */
	List<Integer> listIds();
	/**
	 * Find a Person by their id
	 * @param personId
	 * @return Person object
	 */
	Person get(int personId);
	/**
	 * Find a Person by their username
	 * @param username
	 * @return Person object
	 */
	Person get(String username);
	/**
	 * Find possible Person objects by their first and last name
	 * Multiple values are possible so list is returned
	 * @param firstName
	 * @param lastName
	 * @return List<Person>
	 */
	List<Person> get(String firstName, String lastName);
	/**
	 * Updates a Person object within persisted memory
	 * @param personToUpdate
	 * @return Person true if successful, false if failed
	 */

	Person update(Person personToUpdate);
	/**
	 * Deletes a Person by a Person object
	 * @param personToDelete
	 * @return Person true if successful, false if failed
	 */

	boolean delete(Person personToDelete);
	/**
	 * Deletes a Person by an id
	 * @param personId
	 * @return Person true if successful, false if failed
	 */
	boolean delete(int personId);
	/**
	 * Gets the highest id for the Person objects in persisted memory
	 * @return
	 */
	int getHighestId();
}
