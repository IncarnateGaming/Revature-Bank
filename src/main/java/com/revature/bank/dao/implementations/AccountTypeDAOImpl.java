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
import com.revature.bank.dao.interfaces.AccountTypeDAO;
import com.revature.bank.model.AccountType;
import com.revature.bank.services.helpers.LoggerSingleton;

public class AccountTypeDAOImpl implements AccountTypeDAO {

	@Override
	public AccountType create(AccountType accountTypeToCreate) {
		AccountType result = null;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "call admin.create_account_type(?,?,?,?)";
			try(CallableStatement stmt = conn.prepareCall(sql)){
				stmt.registerOutParameter(1, Types.INTEGER);
				stmt.setString(2, accountTypeToCreate.getLabel());
				stmt.setInt(3, accountTypeToCreate.getMinBalance());
				stmt.setDouble(4, accountTypeToCreate.getInterest());
				stmt.execute();
				int resultId = (Integer) stmt.getObject(1);
				accountTypeToCreate.setId(resultId);
				result = accountTypeToCreate;
			}
			DAOUtilities.commit(conn);
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to create account type",e);
		}
		return result;
	}

	@Override
	public List<AccountType> list() {
		List<AccountType> list = new ArrayList<>();
		try (Connection conn = DAOUtilities.getConnection()){
			try(Statement stmt = conn.createStatement()){
				String sql = "SELECT * FROM ADMIN.ACCOUNT_TYPE";
				try(ResultSet rs = stmt.executeQuery(sql)){
					while(rs.next()) {
						AccountType obj = objectBuilder(rs);
						list.add(obj);
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get account type ranks",e);
		}
		return list;
	}

	@Override
	public AccountType get(int accountTypeId) {
		AccountType result = null;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "SELECT * FROM ADMIN.ACCOUNT_TYPE WHERE account_type_id = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, accountTypeId);
				try(ResultSet rs = stmt.executeQuery()){
					while(rs.next()) {
						result = objectBuilder(rs);
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get account type rank",e);
		}
		return result;
	}

	@Override
	public AccountType update(AccountType accountTypeToUpdate) {
		AccountType result = null;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "UPDATE ADMIN.ACCOUNT_TYPE "
					+ "SET label = ?, min_balance = ?, interest = ? "
					+ "WHERE ADMIN.ACCOUNT_TYPE.account_type_id = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setString(1, accountTypeToUpdate.getLabel());
				stmt.setInt(2, accountTypeToUpdate.getMinBalance());
				stmt.setDouble(3, accountTypeToUpdate.getInterest());
				stmt.setInt(4, accountTypeToUpdate.getId());
				int rs = stmt.executeUpdate();
				if (rs > 0) {
					result = accountTypeToUpdate;
				}
			}
			DAOUtilities.commit(conn);
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to update account type",e);
		}
		return result;
	}

	@Override
	public boolean delete(AccountType accountTypeToDelete) {
		return delete(accountTypeToDelete.getId());
	}

	@Override
	public boolean delete(int accountTypeId) {
		Boolean result = false;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "DELETE FROM ADMIN.ACCOUNT_TYPE WHERE account_type_id = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, accountTypeId);
				int rs = stmt.executeUpdate();
				if (rs > 0) {
					result = true;
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to delete account type.",e);
		}
		return result;
	}

	@Override
	public int getHighestId() {
		int result = 0;
		try (Connection conn = DAOUtilities.getConnection()){
			try(Statement stmt = conn.createStatement()){
				String sql = "SELECT MAX(account_type_id) FROM ADMIN.ACCOUNT_TYPE";
				try(ResultSet rs = stmt.executeQuery(sql)){
					result = rs.getInt(1);
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get max account type id",e);
		}
		return result;
	}

	private AccountType objectBuilder(ResultSet rs) throws SQLException {
		AccountType accType = new AccountType(
				rs.getString("label"),
				rs.getInt("min_balance"),
				rs.getDouble("interest")
				);
		accType.setId(rs.getInt("account_type_id"));
		return accType;
	}
}
