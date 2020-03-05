package com.revature.bank.dao.implementations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.bank.dao.DAOUtilities;
import com.revature.bank.dao.interfaces.PersonDAO;
import com.revature.bank.model.Person;
import com.revature.bank.services.helpers.LoggerSingleton;

public class PersonDAOImpl implements PersonDAO {

	@Override
	public Person create(Person personToSave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> list() {
		List<Person> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DAOUtilities.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM PERSON";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(personBuilder(rs));
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
		return list;
	}

	@Override
	public Person get(int personId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person get(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> get(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person update(Person personToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person delete(Person personToDelete) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person delete(int personId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHighestId() {
		// TODO Auto-generated method stub
		return 0;
	}
	private Person personBuilder(ResultSet rs) {
//		return new Person();
		return null;
	}
}