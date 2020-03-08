package com.revature.bank.dao.implementations;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.revature.bank.dao.DAOUtilities;
import com.revature.bank.dao.interfaces.PermissionRankDAO;
import com.revature.bank.model.PermissionRank;
import com.revature.bank.model.Person;
import com.revature.bank.services.helpers.LoggerSingleton;

public class PermissionRankDAOImpl implements PermissionRankDAO {

	@Override
	public PermissionRank create(PermissionRank permissionToCreate) {
		PermissionRank result = null;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "call admin.create_rank(?,?)";
			try(CallableStatement stmt = conn.prepareCall(sql)){
				stmt.registerOutParameter(1, Types.INTEGER);
				stmt.setString(2, permissionToCreate.getLabel());
				stmt.execute();
				int resultId = (Integer) stmt.getObject(1);
				System.out.println(resultId);
				permissionToCreate.setId(resultId);
				result = permissionToCreate;
			}
			DAOUtilities.commit(conn);
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to create permission",e);
		}
		return result;
	}
	
	@Override
	public boolean assign(Person person, PermissionRank rank) {
		boolean result = false;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "SELECT MAX(person) FROM PERMISSION_RANK_JT WHERE person = ? "
					+ "AND permission_rank_label_id = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, person.getId());
				stmt.setInt(2, rank.getId());
				try(ResultSet rs = stmt.executeQuery()){
					if(! (rs.getInt(1) > 0)) {//If it does not already exist
						String sql2 = "INSERT INTO PERMISSION_RANK_JT VALUES(?,?)";
						try(PreparedStatement stmt2 = conn.prepareStatement(sql2)){
							stmt2.setInt(1, person.getId());
							stmt2.setInt(2, rank.getId());
							if (stmt2.execute()) {
								DAOUtilities.commit(conn);
								result = true;
							}
						}
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to create permission",e);
		}
		return result;
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
	public boolean remove(Person person, PermissionRank rank) {
		return false;
	}

	@Override
	public int getHighestId() {
		// TODO Auto-generated method stub
		return 0;
	}
}