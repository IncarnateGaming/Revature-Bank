package com.revature.bank.dao.implementations;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
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
			String sql = "SELECT MAX(person) FROM ADMIN.PERMISSION_RANK_JT WHERE person = ? "
					+ "AND permission_rank_label_id = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, person.getId());
				stmt.setInt(2, rank.getId());
				try(ResultSet rs = stmt.executeQuery()){
					rs.next();
					if(! (rs.getInt(1) > 0)) {//If it does not already exist
						String sql2 = "INSERT INTO ADMIN.PERMISSION_RANK_JT VALUES(?,?)";
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
		List<PermissionRank> list = new ArrayList<>();
		try (Connection conn = DAOUtilities.getConnection()){
			try(Statement stmt = conn.createStatement()){
				String sql = "SELECT * FROM ADMIN.PERMISSION_RANK_LABEL";
				try(ResultSet rs = stmt.executeQuery(sql)){
					while(rs.next()) {
						PermissionRank obj = objectBuilder(rs);
						list.add(obj);
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get permission ranks",e);
		}
		return list;
	}

	@Override
	public List<PermissionRank> list(Person person) {
		List<PermissionRank> list = new ArrayList<>();
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "SELECT * FROM ADMIN.PERMISSION_RANK_JT "
					+ "INNER JOIN ADMIN.PERMISSION_RANK_LABEL "
					+ "ON ADMIN.PERMISSION_RANK_JT.permission_rank_label_id = "
					+ "ADMIN.PERMISSION_RANK_LABEL.permission_rank_label_id "
					+ "WHERE ADMIN.PERMISSION_RANK_JT.person = ? "
					;
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, person.getId());
				try(ResultSet rs = stmt.executeQuery()){
					while(rs.next()) {
						PermissionRank obj = objectBuilder(rs);
						list.add(obj);
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get permission ranks for: "+ person.getFirstName(),e);
		}
		return list;
	}
	public List<String> listLabels(Person person){
		List<PermissionRank> listRanks = list(person);
		List<String> result = new ArrayList<>();
		for(PermissionRank rank : listRanks) {
			result.add(rank.getLabel());
		}
		return result;
	}

	@Override
	public PermissionRank get(int permissionId) {
		PermissionRank result = null;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "SELECT * FROM ADMIN.PERMISSION_RANK_LABEL WHERE permission_rank_label_id = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, permissionId);
				try(ResultSet rs = stmt.executeQuery()){
					while(rs.next()) {
						result = objectBuilder(rs);
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get permission rank",e);
		}
		return result;
	}

	@Override
	public PermissionRank update(PermissionRank rankToUpdate) {
		PermissionRank result = null;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "UPDATE ADMIN.PERMISSION_RANK_LABEL "
					+ "SET label = ?"
					+ "WHERE ADMIN.PERMISSION_RANK_LABEL.permission_rank_label_id = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setString(1, rankToUpdate.getLabel());
				stmt.setInt(2, rankToUpdate.getId());
				int rs = stmt.executeUpdate();
				if (rs > 0) {
					result = rankToUpdate;
				}
			}
			DAOUtilities.commit(conn);
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to create rank",e);
		}
		return result;
	}

	@Override
	public boolean delete(PermissionRank permissionToDelete) {
		return delete(permissionToDelete.getId());
	}

	@Override
	public boolean delete(int permissionId) {
		Boolean result = false;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "DELETE FROM ADMIN.PERMISSION_RANK_LABEL WHERE permission_rank_label_id = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, permissionId);
				int rs = stmt.executeUpdate();
				if (rs > 0) {
					result = true;
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to delete permission rank.",e);
		}
		return result;
	}
	
	@Override
	public boolean remove(Person person, PermissionRank rank) {
		Boolean result = false;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "DELETE FROM ADMIN.PERMISSION_RANK_JT WHERE permission_rank_label_id = ? AND"
					+ "person = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, rank.getId());
				stmt.setInt(2, person.getId());
				int rs = stmt.executeUpdate();
				if (rs > 0) {
					result = true;
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to remove rank " + rank.getLabel() + " from user " + person.getUsername(),e);
		}
		return result;
	}

	@Override
	public int getHighestId() {
		int result = 0;
		try (Connection conn = DAOUtilities.getConnection()){
			try(Statement stmt = conn.createStatement()){
				String sql = "SELECT MAX(permission_rank_label_id) FROM ADMIN.PERMISSION_RANK_LABEL";
				try(ResultSet rs = stmt.executeQuery(sql)){
					result = rs.getInt(1);
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get max permission id",e);
		}
		return result;
	}
	private PermissionRank objectBuilder(ResultSet rs) throws SQLException {
		return new PermissionRank(
				rs.getString("label"),
				rs.getInt("permission_rank_label_id")
				);
	}
}