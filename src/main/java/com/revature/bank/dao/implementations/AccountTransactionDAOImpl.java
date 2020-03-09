package com.revature.bank.dao.implementations;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountTransaction> list(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountTransaction> list(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountTransaction get(int accountTransactionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountTransaction update(AccountTransaction accountTransactionToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(AccountTransaction accountTransactionToDelete) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int accountTransactionId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getHighestId() {
		// TODO Auto-generated method stub
		return 0;
	}
}
