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
import com.revature.bank.dao.interfaces.AccountRequestDAO;
import com.revature.bank.model.AccountRequest;
import com.revature.bank.services.helpers.LoggerSingleton;

public class AccountRequestDAOImpl implements AccountRequestDAO {

	@Override
	public AccountRequest create(AccountRequest accountRequestToCreate) {
		AccountRequest result = null;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "call admin.create_account_request(?,?,?)";
			try(CallableStatement stmt = conn.prepareCall(sql)){
				stmt.registerOutParameter(1, Types.INTEGER);
				stmt.setInt(2, accountRequestToCreate.getAccountTypeId());
				stmt.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
				stmt.execute();
				int resultId = (Integer) stmt.getObject(1);
				java.sql.Date resultDate = stmt.getDate(3);
				accountRequestToCreate.setId(resultId);
				accountRequestToCreate.setCreationDate(resultDate);
				result = accountRequestToCreate;
			}
			DAOUtilities.commit(conn);
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to create account request",e);
		}
		return result;
	}

	@Override
	public List<AccountRequest> list() {
		List<AccountRequest> list = new ArrayList<>();
		try (Connection conn = DAOUtilities.getConnection()){
			try(Statement stmt = conn.createStatement()){
				String sql = "SELECT * FROM ADMIN.ACCOUNT_REQUEST";
				try(ResultSet rs = stmt.executeQuery(sql)){
					while(rs.next()) {
						AccountRequest a = objectBuilder(rs);
						list.add(a);
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get account requests",e);
		}
		return list;
	}

	@Override
	public AccountRequest get(int accountRequestId) {
		AccountRequest result = null;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "SELECT * FROM ADMIN.ACCOUNT_REQUEST WHERE acc_request_id = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, accountRequestId);
				try(ResultSet rs = stmt.executeQuery()){
					while(rs.next()) {
						result = objectBuilder(rs);
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get account request",e);
		}
		return result;
	}

	@Override
	public AccountRequest update(AccountRequest accountRequestToUpdate) {
		AccountRequest result = null;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "UPDATE ADMIN.ACCOUNT_REQUEST "
					+ "SET account_type = ?, date_of_request = ?"
					+ "WHERE ADMIN.ACCOUNT_REQUEST.acc_request_id = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, accountRequestToUpdate.getAccountTypeId());
				stmt.setDate(2, new java.sql.Date(accountRequestToUpdate.getCreationDate().getTime()));
				stmt.setInt(3, accountRequestToUpdate.getId());
				int rs = stmt.executeUpdate();
				if (rs > 0) {
					result = accountRequestToUpdate;
				}
			}
			DAOUtilities.commit(conn);
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to create account request",e);
		}
		return result;
	}

	@Override
	public boolean delete(AccountRequest accountRequestToDelete) {
		return delete(accountRequestToDelete.getAccountTypeId());
	}

	@Override
	public boolean delete(int accountRequestId) {
		Boolean result = false;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "DELETE FROM ADMIN.ACCOUNT_REQUEST WHERE acc_request_id = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, accountRequestId);
				int rs = stmt.executeUpdate();
				if (rs > 0) {
					result = true;
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to delete account request.",e);
		}
		return result;
	}

	@Override
	public int getHighestId() {
		int result = 0;
		try (Connection conn = DAOUtilities.getConnection()){
			try(Statement stmt = conn.createStatement()){
				String sql = "SELECT MAX(acc_request_id) FROM ADMIN.ACCOUNT_REQUEST";
				try(ResultSet rs = stmt.executeQuery(sql)){
					rs.next();
					result = rs.getInt(1);
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get account request max id",e);
		}
		return result;
	}
	private AccountRequest objectBuilder(ResultSet rs) throws SQLException {
		AccountRequest accountOwnership = new AccountRequest(
				rs.getInt("account_type"),
				rs.getDate("date_of_request")
				);
		accountOwnership.setId(rs.getInt("acc_request_id"));
		return accountOwnership;
	}
}
