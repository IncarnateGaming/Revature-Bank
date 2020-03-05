package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.PermissionRank;

public interface PermissionRankDAO {
	boolean create(PermissionRank permissionToSave);

	List<PermissionRank> list();
	List<String> list(int personId);
	PermissionRank get(int permissionId);

	boolean update(PermissionRank permissionToUpdate);

	boolean delete(PermissionRank permissionToDelete);
	boolean delete(int permissionId);
	/**
	 * Gets the highest id for the Permission objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
}
