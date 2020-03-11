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
import com.revature.bank.dao.interfaces.AccountRequestUsersDAO;
import com.revature.bank.model.AccountRequest;
import com.revature.bank.model.AccountRequestUsers;
import com.revature.bank.model.Person;
import com.revature.bank.services.helpers.LoggerSingleton;

public class AccountRequestUsersDAOImpl implements AccountRequestUsersDAO {

	@Override
	public AccountRequestUsers create(AccountRequestUsers accountRequestUsersToCreate) {
		AccountRequestUsers result = null;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "call admin.create_account_req_users_jt(?,?,?)";
			try(CallableStatement stmt = conn.prepareCall(sql)){
				stmt.setInt(1, accountRequestUsersToCreate.getPersonId());
				stmt.setInt(2, accountRequestUsersToCreate.getAccountRequestId());
				stmt.registerOutParameter(3, Types.INTEGER);
				stmt.execute();
				result = accountRequestUsersToCreate;
			}
			DAOUtilities.commit(conn);
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to create account request user",e);
		}
		return result;
	}

	@Override
	public List<AccountRequestUsers> list() {
		List<AccountRequestUsers> list = new ArrayList<>();
		try (Connection conn = DAOUtilities.getConnection()){
			try(Statement stmt = conn.createStatement()){
				String sql = "SELECT * FROM ADMIN.ACCOUNT_REQUEST_USERS_JT";
				try(ResultSet rs = stmt.executeQuery(sql)){
					while(rs.next()) {
						AccountRequestUsers a = objectBuilder(rs);
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
	public List<Integer> list(AccountRequest accountRequest){
		List<Integer> result = new ArrayList<>();
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "SELECT person FROM ADMIN.ACCOUNT_REQUEST_USERS_JT "
					+ "WHERE acc_request = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, accountRequest.getId());
				try(ResultSet rs = stmt.executeQuery()){
					while(rs.next()) {
						result.add(rs.getInt("person"));
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get account request users ids",e);
		}
		return result;
	}
	@Override
	public List<Integer> list(Person person){
		List<Integer> result = new ArrayList<>();
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "SELECT person FROM ADMIN.ACCOUNT_REQUEST_USERS_JT "
					+ "WHERE person = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, person.getId());
				try(ResultSet rs = stmt.executeQuery()){
					while(rs.next()) {
						result.add(rs.getInt("acc_request"));
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get account request account ids",e);
		}
		return result;
	}
	@Override
	public AccountRequestUsers get(AccountRequest accountRequest, Person person) {
		return get(accountRequest.getId(), person.getId());
	}
	@Override
	public AccountRequestUsers get(int accountId, int personId) {
		AccountRequestUsers result = null;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "SELECT * FROM ADMIN.ACCOUNT_REQUEST_USERS_JT "
					+ "WHERE acc_request = ? AND person = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, accountId);
				stmt.setInt(2, personId);
				try(ResultSet rs = stmt.executeQuery()){
					while(rs.next()) {
						result = objectBuilder(rs);
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get account request user",e);
		}
		return result;
	}

	@Override
	public boolean delete(AccountRequestUsers accountRequestUsersToDelete) {
		return delete(accountRequestUsersToDelete.getAccountRequestId(), accountRequestUsersToDelete.getPersonId());
	}

	@Override
	public boolean delete(int accId, int perId) {
		Boolean result = false;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "DELETE FROM ADMIN.ACCOUNT_REQUEST_USERS_JT "
					+ "WHERE acc_request = ? AND person = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, accId);
				stmt.setInt(2, perId);
				int rs = stmt.executeUpdate();
				if (rs > 0) {
					result = true;
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to delete account request user.",e);
		}
		return result;
	}

	@Override
	public boolean delete(int accId) {
		Boolean result = false;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "DELETE FROM ADMIN.ACCOUNT_REQUEST_USERS_JT "
					+ "WHERE acc_request = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, accId);
				int rs = stmt.executeUpdate();
				if (rs > 0) {
					result = true;
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to delete account request user.",e);
		}
		return result;
	}

	private AccountRequestUsers objectBuilder(ResultSet rs) throws SQLException {
		return new AccountRequestUsers(
				rs.getInt("person"),
				rs.getInt("acc_request")
				);
	}
}
