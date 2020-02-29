package com.bank.dao.implementations;

import java.util.List;

import com.bank.dao.interfaces.PermissionRankDAO;
import com.bank.model.PermissionRank;

public class PermissionRankDAOImpl implements PermissionRankDAO {

	//SECTION: methods
	@Override
	public List<PermissionRank> listPermission() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<String> listPermission(int personId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PermissionRank getPermission(int permissionId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean updatePermission(PermissionRank permissionToUpdate) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean savePermission(PermissionRank permissionToSave) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deletePermission(PermissionRank permissionToDelete) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deletePermission(int permissionId) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int getHighestId() {
		// TODO Auto-generated method stub
		return 0;
	}
}