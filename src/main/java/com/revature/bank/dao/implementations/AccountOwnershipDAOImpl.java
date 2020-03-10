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
import com.revature.bank.dao.interfaces.AccountOwnershipDAO;
import com.revature.bank.model.Account;
import com.revature.bank.model.AccountOwnership;
import com.revature.bank.model.Person;
import com.revature.bank.services.helpers.LoggerSingleton;

public class AccountOwnershipDAOImpl implements AccountOwnershipDAO {
	@Override
	public AccountOwnership create(Account account, Person owner) {
		AccountOwnership accOwn = new AccountOwnership(
				account.getId(),
				owner.getId()
				);
		return create(accOwn);
	}

	@Override
	public AccountOwnership create(AccountOwnership accountOwnershipToCreate) {
		AccountOwnership result = null;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "call admin.create_account_ownership_jt(?,?,?,?)";
			try(CallableStatement stmt = conn.prepareCall(sql)){
				stmt.registerOutParameter(1, Types.INTEGER);
				stmt.setInt(2, accountOwnershipToCreate.getAccountId());
				stmt.setInt(3, accountOwnershipToCreate.getOwnerId());
				stmt.setDate(4, new java.sql.Date(new java.util.Date().getTime()));
				stmt.execute();
				int resultId = (Integer) stmt.getObject(1);
				accountOwnershipToCreate.setId(resultId);
				result = accountOwnershipToCreate;
			}
			DAOUtilities.commit(conn);
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to create account ownership",e);
		}
		return result;
	}

	@Override
	public List<AccountOwnership> list() {
		List<AccountOwnership> list = new ArrayList<>();
		try (Connection conn = DAOUtilities.getConnection()){
			try(Statement stmt = conn.createStatement()){
				String sql = "SELECT * FROM ADMIN.ACCOUNT_OWNERSHIP";
				try(ResultSet rs = stmt.executeQuery(sql)){
					while(rs.next()) {
						AccountOwnership obj = objectBuilder(rs);
						list.add(obj);
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get ownership",e);
		}
		return list;
	}

	@Override
	public List<AccountOwnership> list(int userId) {
		List<AccountOwnership> list = new ArrayList<>();
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "SELECT * FROM ADMIN.ACCOUNT_OWNERSHIP_JT"
					+ "INNER JOIN ADMIN.PERSON"
					+ "ON ADMIN.PERSON.person_id = ADMIN.ACCOUNT_OWNERSHIP_JT.owner"
					+ "WHERE ADMIN.PERSON.person_id = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, userId);
				try(ResultSet rs = stmt.executeQuery(sql)){
					while(rs.next()) {
						AccountOwnership obj = objectBuilder(rs);
						list.add(obj);
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get ownership",e);
		}
		return list;
	}

	@Override
	public List<Integer> listIds(int userId) {
		List<AccountOwnership> listOwn = list(userId);
		List<Integer> list = new ArrayList<>();
		for (AccountOwnership accOwn : listOwn) {
			list.add(accOwn.getAccountId());
		}
		return list;
	}

	@Override
	public AccountOwnership get(int accountOwnershipId) {
		AccountOwnership result = null;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "SELECT * FROM ADMIN.ACCOUNT_OWNERSHIP_JT "
					+ "WHERE ownership_id = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, accountOwnershipId);
				try(ResultSet rs = stmt.executeQuery()){
					while(rs.next()) {
						result = objectBuilder(rs);
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get account ownership",e);
		}
		return result;
	}
	
	@Override
	public boolean checkOwned(Account account, Person person) {
		boolean result = false;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "SELECT MIN(ownership_id) FROM ADMIN.ACCOUNT_OWNERSHIP_JT "
					+ "WHERE account = ? AND owner = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, account.getId());
				stmt.setInt(2, person.getId());
				try(ResultSet rs = stmt.executeQuery()){
					rs.next();
					result = rs.getInt(1) > 0;
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get account ownership",e);
		}
		return result;
	}

	@Override
	public AccountOwnership update(AccountOwnership accountOwnershipToUpdate) {
		AccountOwnership result = null;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "UPDATE ADMIN.ACCOUNT_OWNERSHIP_JT "
					+ "SET owner = ?, account = ?, date_added = ? "
					+ "WHERE ADMIN.ACCOUNT_OWNERSHIP_JT.ownership_id = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, accountOwnershipToUpdate.getOwnerId());
				stmt.setInt(2, accountOwnershipToUpdate.getAccountId());
				stmt.setDate(3, new java.sql.Date(accountOwnershipToUpdate.getDate().getTime()));
				stmt.setInt(4, accountOwnershipToUpdate.getId());
				int rs = stmt.executeUpdate();
				if (rs > 0) {
					result = accountOwnershipToUpdate;
				}
			}
			DAOUtilities.commit(conn);
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to update account ownership",e);
		}
		return result;
	}

	@Override
	public boolean delete(AccountOwnership accountOwnershipToDelete) {
		return delete(accountOwnershipToDelete.getId());
	}

	@Override
	public boolean delete(int accountOwnershipId) {
		Boolean result = false;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "DELETE FROM ADMIN.ACCOUNT_OWNERSHIP_JT WHERE accountOwnership_id = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, accountOwnershipId);
				int rs = stmt.executeUpdate();
				if (rs > 0) {
					result = true;
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to delete account ownership.",e);
		}
		return result;
	}

	@Override
	public int getHighestId() {
		int result = 0;
		try (Connection conn = DAOUtilities.getConnection()){
			try(Statement stmt = conn.createStatement()){
				String sql = "SELECT MAX(ownership_id) FROM ADMIN.ACCOUNT_OWNERSHIP_JT";
				try(ResultSet rs = stmt.executeQuery(sql)){
					rs.next();
					result = rs.getInt(1);
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get ownership max id",e);
		}
		return result;
	}
	
	private AccountOwnership objectBuilder(ResultSet rs) throws SQLException {
		AccountOwnership accountOwnership = new AccountOwnership(
				rs.getInt("owner"),
				rs.getInt("account")
				);
		accountOwnership.setDate(rs.getDate("date_added"));
		accountOwnership.setId(rs.getInt("ownership_id"));
		return accountOwnership;
	}
}