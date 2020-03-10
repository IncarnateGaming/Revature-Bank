package com.revature.bank.services.buisness.logic;

import java.util.List;

import com.revature.bank.model.PermissionRank;

public class PermissionRankService {
	public PermissionRankService() {
		super();
	}
	/**
	 * Checks to see if the currently logged in person has a particular permission
	 * @param permissionLabel
	 * @return boolean
	 */
	public boolean containsPermission(String permissionLabel, List<PermissionRank> permissions) {
		boolean result = false;
		for (PermissionRank permission : permissions) {
			if(permission.getLabel() == permissionLabel) {
				result = true;
				break;
			}
		}
		return result;
	}
	/**
	 * Checks to see if the currently logged in person has a particular permission
	 * @param checkPermission
	 * @return boolean
	 */
	public boolean containsPermission(PermissionRank checkPermission, List<PermissionRank> permissions) {
		boolean result = false;
		for (PermissionRank permission : permissions) {
			if(permission.equals(checkPermission)) {
				result = true;
				break;
			}
		}
		return result;
	}
}
