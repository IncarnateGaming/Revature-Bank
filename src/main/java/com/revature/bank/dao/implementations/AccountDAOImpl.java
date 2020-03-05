package com.revature.bank.dao.implementations;

import java.sql.Connection;
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
	public Account create(Account accountToSave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> list() {
		List<Account> accountList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DAOUtilities.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM ACCOUNT";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Account a = new Account(rs);
				accountList.add(a);
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get accounts",e);
		}finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				LoggerSingleton.getLogger().warn("Failed to close connection",e);
			}
		}
		return accountList;
	}

	@Override
	public List<Account> list(Person owner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account get(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account update(Account accountToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account delete(Account accountToDelete) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account delete(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHighestId() {
		// TODO Auto-generated method stub
		return 0;
	}
}
