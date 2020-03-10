package com.revature.bank.dao.implementations;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.bank.dao.DAOUtilities;
import com.revature.bank.dao.interfaces.AccountTransactionDAO;
import com.revature.bank.model.Account;
import com.revature.bank.model.AccountTransaction;
import com.revature.bank.model.Person;
import com.revature.bank.services.helpers.LoggerSingleton;

public class AccountTransactionDAOImpl implements AccountTransactionDAO {

	@Override
	public boolean createDeposit(Account account, double value) {
		boolean result = false;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "call admin.create_deposit(?,?)";
			try(CallableStatement stmt = conn.prepareCall(sql)){
				stmt.setInt(1, account.getId());
				stmt.setDouble(2, value);
				if(stmt.execute()) {
					result = true;
				}
			}
			DAOUtilities.commit(conn);
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to create deposit",e);
		}
		return result;
	}

	@Override
	public boolean createWithdraw(Account account, double value) {
		boolean result = false;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "call admin.create_withdraw(?,?)";
			try(CallableStatement stmt = conn.prepareCall(sql)){
				stmt.setInt(1, account.getId());
				stmt.setDouble(2, value);
				if(stmt.execute()) {
					result = true;
				}
			}
			DAOUtilities.commit(conn);
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to create withdraw",e);
		}
		return result;
	}

	@Override
	public boolean createTransfer(Account originAccount, Account targetAccount, double value) {
		boolean result = false;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "call admin.create_transfer(?,?,?)";
			try(CallableStatement stmt = conn.prepareCall(sql)){
				stmt.setInt(1, originAccount.getId());
				stmt.setInt(2, targetAccount.getId());
				stmt.setDouble(3, value);
				if(stmt.execute()) {
					result = true;
				}
			}
			DAOUtilities.commit(conn);
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to create transfer",e);
		}
		return result;
	}

	@Override
	public List<AccountTransaction> list() {
		List<AccountTransaction> list = new ArrayList<>();
		try (Connection conn = DAOUtilities.getConnection()){
			try(Statement stmt = conn.createStatement()){
				String sql = "SELECT * FROM ADMIN.ACCOUNT_TRANSACTION";
				try(ResultSet rs = stmt.executeQuery(sql)){
					while(rs.next()) {
						AccountTransaction obj = objectBuilder(rs);
						list.add(obj);
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get accounts",e);
		}
		return list;
	}

	@Override
	public List<AccountTransaction> list(Person person) {
		List<AccountTransaction> list = new ArrayList<>();
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "SELECT * FROM ADMIN.ACCOUNT_TRANSACTION "
					+ "INNER JOIN ADMIN.ACCOUNT "
					+ " ON ADMIN.ACCOUNT.account_id = ADMIN.ACCOUNT_TRANSACTION.account "
					+ "INNER JOIN ACCOUNT_OWNERSHIP_JT"
					+ " ON ADMIN.ACCOUNT_OWNERSHIP_JT.account = ADMIN.ACCOUNT.account_id"
					+ "WHERE ADMIN.ACCOUNT_OWNERSHIP_JT.owner = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, person.getId());
				try(ResultSet rs = stmt.executeQuery(sql)){
					while(rs.next()) {
						AccountTransaction obj = objectBuilder(rs);
						list.add(obj);
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get account transactions",e);
		}
		return list;
	}

	@Override
	public List<AccountTransaction> list(Account account) {
		List<AccountTransaction> list = new ArrayList<>();
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "SELECT * FROM ADMIN.ACCOUNT_TRANSACTION "
					+ "INNER JOIN ADMIN.ACCOUNT "
					+ " ON ADMIN.ACCOUNT.account_id = ADMIN.ACCOUNT_TRANSACTION.account "
					+ "WHERE ADMIN.ACCOUNT.account_id = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, account.getId());
				try(ResultSet rs = stmt.executeQuery(sql)){
					while(rs.next()) {
						AccountTransaction obj = objectBuilder(rs);
						list.add(obj);
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get account transactions",e);
		}
		return list;
	}

	@Override
	public AccountTransaction get(int accountTransactionId) {
		AccountTransaction result = null;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "SELECT * FROM ADMIN.ACCOUNT_TRANSACTION "
					+ "WHERE transaction_id = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, accountTransactionId);
				try(ResultSet rs = stmt.executeQuery(sql)){
					while(rs.next()) {
						result = objectBuilder(rs);
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get account transaction",e);
		}
		return result;
	}

	@Override
	public int getHighestId() {
		int result = 0;
		try (Connection conn = DAOUtilities.getConnection()){
			try(Statement stmt = conn.createStatement()){
				String sql = "SELECT MAX(transaction_id) FROM ADMIN.ACCOUNT_TRANSACTION";
				try(ResultSet rs = stmt.executeQuery(sql)){
					result = rs.getInt(1);
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get maximum transaction id",e);
		}
		return result;
	}
	private AccountTransaction objectBuilder(ResultSet rs) throws SQLException {
		AccountTransaction accountTransaction = new AccountTransaction(
				rs.getInt("account"),
				rs.getInt("status"),
				rs.getInt("transaction_type"),
				rs.getString("notes")
				);
		accountTransaction.setId(rs.getInt("transaction_id"));
		accountTransaction.setRelatedTransactionId(rs.getInt("related_transaction"));
		accountTransaction.setTransactionDate(rs.getDate("transaction_date"));
		return accountTransaction;
	}
}
