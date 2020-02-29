package com.revature.bank.dao.interfaces;

import java.util.List;

import com.revature.bank.model.PermissionRank;

public interface PermissionRankDAO {
	//SECTION: variables
	//SECTION: constructors
	//SECTION: getters & setters
	//SECTION: methods
	List<PermissionRank> listPermission();
	List<String> listPermission(int personId);
	PermissionRank getPermission(int permissionId);
	boolean updatePermission(PermissionRank permissionToUpdate);
	boolean savePermission(PermissionRank permissionToSave);
	boolean deletePermission(PermissionRank permissionToDelete);
	boolean deletePermission(int permissionId);
	/**
	 * Gets the highest id for the Permission objects in persisted memory
	 * @return Integer
	 */
	int getHighestId();
	//SECTION: hash && equals
	//SECTION: toString
}
