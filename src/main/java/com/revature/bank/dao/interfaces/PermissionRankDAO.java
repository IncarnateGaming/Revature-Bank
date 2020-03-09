package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.PermissionRank;
import com.revature.bank.model.Person;

public interface PermissionRankDAO {
	PermissionRank create(PermissionRank permissionToCreate);
	boolean assign(Person person, PermissionRank rank);

	List<PermissionRank> list();
	List<PermissionRank> list(Person person);
	List<String> listLabels(Person person);
	PermissionRank get(int permissionId);

	PermissionRank update(PermissionRank permissionToUpdate);

	boolean delete(PermissionRank permissionToDelete);
	boolean delete(int permissionId);
	boolean remove(Person person, PermissionRank rank);
	/**
	 * Gets the highest id for the Permission objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
}
