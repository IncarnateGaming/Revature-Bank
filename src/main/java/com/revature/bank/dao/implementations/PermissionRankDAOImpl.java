package com.revature.bank.dao.implementations;

import java.util.List;

import com.revature.bank.dao.interfaces.PermissionRankDAO;
import com.revature.bank.model.PermissionRank;

public class PermissionRankDAOImpl implements PermissionRankDAO {

	@Override
	public boolean create(PermissionRank permissionToSave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PermissionRank> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> list(int personId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PermissionRank get(int permissionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(PermissionRank permissionToUpdate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(PermissionRank permissionToDelete) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int permissionId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getHighestId() {
		// TODO Auto-generated method stub
		return 0;
	}
}