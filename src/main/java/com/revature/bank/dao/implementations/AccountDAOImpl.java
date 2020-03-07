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
import com.revature.bank.dao.interfaces.AccountDAO;
import com.revature.bank.model.Account;
import com.revature.bank.model.Person;
import com.revature.bank.services.helpers.LoggerSingleton;

public class AccountDAOImpl implements AccountDAO {
	@Override
	public Account create(Account accountToCreate) {
		Account result = null;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "call admin.create_account(?,?,?,?,?)";
			try(CallableStatement stmt = conn.prepareCall(sql)){
				stmt.registerOutParameter(1, Types.INTEGER);
				stmt.setInt(2, accountToCreate.getAccountTypeId());
				stmt.setDouble(3, accountToCreate.getBalance());
				stmt.setInt(4, accountToCreate.getOverdraftProtection());
				stmt.setInt(5, accountToCreate.getActive() ? 1 : 0);
				System.out.println("Target Location!");
				stmt.execute();
				int resultId = (Integer) stmt.getObject(1);
				System.out.println(resultId);
				accountToCreate.setId(resultId);
				result = accountToCreate;
			}
			DAOUtilities.commit(conn);
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to create account",e);
		}
		return result;
	}

	@Override
	public List<Account> list() {
		List<Account> list = new ArrayList<>();
		try (Connection conn = DAOUtilities.getConnection()){
			try(Statement stmt = conn.createStatement()){
				String sql = "SELECT * FROM ADMIN.ACCOUNT";
				try(ResultSet rs = stmt.executeQuery(sql)){
					while(rs.next()) {
						Account a = objectBuilder(rs);
						list.add(a);
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get accounts",e);
		}
		return list;
	}

	@Override
	public List<Account> list(Person owner) {
		List<Account> list = new ArrayList<>();
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "SELECT * FROM ADMIN.ACCOUNT_OWNERSHIP_JT WHERE "
					+ "ADMIN.ACCOUNT_OWNERSHIP_JT.owner = ? INNER JOIN ADMIN.ACCOUNT"
					+ "ON ADMIN.ACCOUNT_OWNERSHIP_JT.account = ADMIN.ACCOUNT.account_id";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, owner.getId());
				try(ResultSet rs = stmt.executeQuery()){
					while(rs.next()) {
						Account a = objectBuilder(rs);
						list.add(a);
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get accounts",e);
		}
		return null;
	}

	@Override
	public List<Integer> listIds(){
		List<Account> listAccounts = list();
		List<Integer> list = new ArrayList<>();
		for(Account a : listAccounts) {
			list.add(a.getId());
		}
		return list;
	}

	@Override
	public Account get(int accountId) {
		Account result = null;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "SELECT * FROM ADMIN.ACCOUNT WHERE account_id = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, accountId);
				try(ResultSet rs = stmt.executeQuery()){
					while(rs.next()) {
						result = objectBuilder(rs);
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get accounts",e);
		}
		return result;
	}

	@Override
	public Account update(Account accountToUpdate) {
		Account result = null;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "UPDATE ADMIN.ACCOUNT "
					+ "SET account_type = ?, balance = ?, overdraft_protection = ?, active = ?"
					+ "WHERE ADMIN.ACCOUNT.account_id = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setDouble(1, accountToUpdate.getBalance());
				stmt.setInt(2, accountToUpdate.getOverdraftProtection());
				stmt.setInt(3, accountToUpdate.getActive() ? 1 : 0);
				stmt.setInt(4, accountToUpdate.getId());
				int rs = stmt.executeUpdate();
				if (rs > 0) {
					result = accountToUpdate;
				}
			}
			DAOUtilities.commit(conn);
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to create account",e);
		}
		return result;
	}

	@Override
	public boolean delete(Account accountToDelete) {
		return delete(accountToDelete.getId());
	}

	@Override
	public boolean delete(int accountId) {
		Boolean result = false;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "DELETE FROM ADMIN.ACCOUNT WHERE account_id = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, accountId);
				int rs = stmt.executeUpdate();
				if (rs > 0) {
					result = true;
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to delete account.",e);
		}
		return result;
	}

	@Override
	public int getHighestId() {
		int result = 0;
		try (Connection conn = DAOUtilities.getConnection()){
			try(Statement stmt = conn.createStatement()){
				String sql = "SELECT MAX(account_id) FROM ADMIN.ACCOUNT";
				try(ResultSet rs = stmt.executeQuery(sql)){
					result = rs.getInt(1);
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get accounts",e);
		}
		return result;
	}
	private Account objectBuilder(ResultSet rs) throws SQLException {
		return new Account(
				rs.getInt("account_id"),
				rs.getInt("account_type"),
				rs.getDouble("balance"),
				rs.getInt("overdraft_protection"),
				rs.getBoolean("active")
				);
	}
}
