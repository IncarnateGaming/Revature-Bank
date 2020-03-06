package com.revature.bank.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			String sql = "INSERT INTO ADMIN.ACCOUNT (account_type, balance, overdraft_protection, active) VALUES (?,?,?,?)";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, accountToCreate.getAccountTypeId());
				stmt.setDouble(2, accountToCreate.getBalance());
				stmt.setInt(3, accountToCreate.getOverdraftProtection());
				stmt.setInt(4, accountToCreate.getActive() ? 1 : 0);
				try(ResultSet rs = stmt.executeQuery()){
					LoggerSingleton.getLogger().warn("result from account creation: "+rs);
					//TODO mark as successful if certain return
				}
			}
			try(Statement stmt = conn.createStatement()){
				String sql2 = "SELECT * FROM ADMIN.ACCOUNT WHERE account_id = (SELECT MAX(account_id) FROM ADMIN.ACCOUNT)";
				try(ResultSet rs = stmt.executeQuery(sql2)){
					while(rs.next()) {
						result = objectBuilder(rs);
					}
				}
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
//		try (Connection conn = ConnectionUtil.getConnection()){
//			String sql = "INSERT INTO employees (first_name, last_name, email, salary) VALUES (?,?,?,?)";
//			PreparedStatement stmt = conn.prepareStatement(sql);
//			stmt.setString(1, emp.getFirstName());
//			stmt.setString(2, emp.getLastName());
//			stmt.setString(3, emp.getEmail());
//			stmt.setDouble(4, emp.getSalary());
//			return stmt.execute();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return false;

		List<Account> list = new ArrayList<>();
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "SELECT * FROM ADMIN.ACCOUNT";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				//TODO limit to only accounts that are owned by the person
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
		//TODO complete;
		return null;
	}

	@Override
	public Account get(int accountId) {
		Account result = null;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "SELECT * FROM ADMIN.ACCOUNT WHERE account_id = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
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
		//TODO complete
		return null;
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
				try(ResultSet rs = stmt.executeQuery()){
					LoggerSingleton.getLogger().warn("rs from delete" + rs);
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to delete record.",e);
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
