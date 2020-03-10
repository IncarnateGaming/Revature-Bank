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
import com.revature.bank.dao.interfaces.PersonDAO;
import com.revature.bank.model.Person;
import com.revature.bank.services.helpers.LoggerSingleton;

public class PersonDAOImpl implements PersonDAO {

	/**
	 * Persists a person into memory with only their username and password. If you have more information
	 * than that then you should immediately pass it into an update call.
	 */
	@Override
	public Person create(Person personToCreate) {
		Person result = null;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "call admin.create_person(?,?,?)";
			try(CallableStatement stmt = conn.prepareCall(sql)){
				stmt.registerOutParameter(1, Types.INTEGER);
				stmt.setString(2, personToCreate.getPassword());
				stmt.setString(3, personToCreate.getUsername());
				stmt.execute();
				int resultId = (Integer) stmt.getObject(1);
				personToCreate.setId(resultId);
				result = personToCreate;
			}
			DAOUtilities.commit(conn);
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to create person",e);
		}
		return result;
	}

	@Override
	public List<Person> list() {
		List<Person> list = new ArrayList<>();
		try (Connection conn = DAOUtilities.getConnection()){
			try(Statement stmt = conn.createStatement()){
				String sql = "SELECT * FROM ADMIN.PERSON";
				try(ResultSet rs = stmt.executeQuery(sql)){
					while(rs.next()) {
						Person obj = objectBuilder(rs);
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
	public List<Integer> listIds(){
		List<Person> listPeople = list();
		List<Integer> list = new ArrayList<>();
		for(Person obj : listPeople) {
			list.add(obj.getId());
		}
		return list;
	}

	@Override
	public List<Person> get(String firstName, String lastName) {
		List<Person> list = new ArrayList<>();
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "SELECT * FROM ADMIN.PERSON WHERE first_name = ? AND last_name = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setString(1, firstName);
				stmt.setString(2, lastName);
				try(ResultSet rs = stmt.executeQuery(sql)){
					while(rs.next()) {
						Person obj = objectBuilder(rs);
						list.add(obj);
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get people",e);
		}
		return list;
	}

	@Override
	public Person get(int personId) {
		Person result = null;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "SELECT * FROM ADMIN.PERSON WHERE person_id = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, personId);
				try(ResultSet rs = stmt.executeQuery()){
					while(rs.next()) {
						result = objectBuilder(rs);
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get person",e);
		}
		return result;
	}

	@Override
	public Person get(String username) {
		Person result = null;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "SELECT * FROM ADMIN.PERSON WHERE username = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setString(1, username);
				try(ResultSet rs = stmt.executeQuery()){
					while(rs.next()) {
						result = objectBuilder(rs);
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get person",e);
		}
		return result;
	}

	@Override
	public Person update(Person personToUpdate) {
		Person result = null;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "UPDATE ADMIN.Person "
					+ "SET first_name = ?, last_name = ?, social_sec_num = ?, standing = ?, "
					+ "password = ?, city = ?, address = ?, username = ?"
					+ "WHERE ADMIN.PERSON.person_id = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setString(1, personToUpdate.getFirstName());
				stmt.setString(2, personToUpdate.getLastName());
				stmt.setString(3, personToUpdate.getSocialSecurityNumber());
				stmt.setInt(4, personToUpdate.getStanding());
				stmt.setString(5, personToUpdate.getPassword());
				//TODO move password to its own more secure updating procedure instead of lumping in here
				stmt.setInt(6, personToUpdate.getCity());
				stmt.setInt(7, personToUpdate.getAddress());
				stmt.setString(8, personToUpdate.getUsername());
				stmt.setInt(9, personToUpdate.getId());
				int rs = stmt.executeUpdate();
				if (rs > 0) {
					result = personToUpdate;
				}
			}
			DAOUtilities.commit(conn);
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to create person",e);
		}
		return result;
	}

	@Override
	public boolean delete(Person personToDelete) {
		return delete(personToDelete.getId());
	}

	@Override
	public boolean delete(int personId) {
		Boolean result = false;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "DELETE FROM ADMIN.PERSON WHERE person_id = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, personId);
				int rs = stmt.executeUpdate();
				if (rs > 0) {
					result = true;
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to delete person.",e);
		}
		return result;
	}

	@Override
	public int getHighestId() {
		int result = 0;
		try (Connection conn = DAOUtilities.getConnection()){
			try(Statement stmt = conn.createStatement()){
				String sql = "SELECT MAX(person_id) FROM ADMIN.PERSON";
				try(ResultSet rs = stmt.executeQuery(sql)){
					result = rs.getInt(1);
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get people",e);
		}
		return result;
	}
	
	private Person objectBuilder(ResultSet rs) throws SQLException {
		Person person = new Person(
				rs.getString("username"),
				rs.getString("password")
				);
		person.setFirstName(rs.getString("first_name"));
		person.setLastName(rs.getString("last_name"));
		person.setId(rs.getInt("person_id"));
		person.setSocialSecurityNumber(rs.getString("social_sec_num"));
		person.setStanding(rs.getInt("standing"));
		person.setCity(rs.getInt("city"));
		person.setAddress(rs.getInt("address"));
		return person;
	}
}