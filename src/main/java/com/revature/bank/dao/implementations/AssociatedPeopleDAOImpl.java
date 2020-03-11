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
import com.revature.bank.dao.interfaces.AssociatedPeopleDAO;
import com.revature.bank.model.AssociatedPeople;
import com.revature.bank.model.Person;
import com.revature.bank.services.helpers.LoggerSingleton;

public class AssociatedPeopleDAOImpl implements AssociatedPeopleDAO {
	@Override
	public AssociatedPeople create(Person person1, Person person2) {
		AssociatedPeople assocPeople = new AssociatedPeople(person1.getId(),person2.getId());
		return create(assocPeople);
	}

	@Override
	public AssociatedPeople create(AssociatedPeople associatedPeopleToCreate) {
		AssociatedPeople result = null;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "call admin.create_associated_people_jt(?,?,?)";
			try(CallableStatement stmt = conn.prepareCall(sql)){
				stmt.setInt(1, associatedPeopleToCreate.getFirstPersonId());
				stmt.setDouble(2, associatedPeopleToCreate.getSecondPersonId());
				stmt.registerOutParameter(3, Types.INTEGER);
				stmt.execute();
				result = associatedPeopleToCreate;
			}
			DAOUtilities.commit(conn);
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to create associated people",e);
		}
		return result;
	}

	@Override
	public List<AssociatedPeople> list() {
		List<AssociatedPeople> list = new ArrayList<>();
		try (Connection conn = DAOUtilities.getConnection()){
			try(Statement stmt = conn.createStatement()){
				String sql = "SELECT * FROM ADMIN.ACCOUNT";
				try(ResultSet rs = stmt.executeQuery(sql)){
					while(rs.next()) {
						AssociatedPeople a = objectBuilder(rs);
						list.add(a);
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get associatedPeoples",e);
		}
		return list;
	}
	
	@Override
	public List<Integer> list(Person person){
		List<Integer> list = new ArrayList<>();
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "SELECT * FROM ADMIN.ASSOCIATED_PEOPLE_JT "
					+ "WHERE first_person = ? "
					;
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, person.getId());
				try(ResultSet rs = stmt.executeQuery()){
					while(rs.next()) {
						list.add(rs.getInt("second_person"));
					}
				}
			}
			String sql2 = "SELECT * FROM ADMIN.ASSOCIATED_PEOPLE_JT "
					+ "WHERE second_person = ? "
					;
			try(PreparedStatement stmt = conn.prepareStatement(sql2)){
				stmt.setInt(1, person.getId());
				try(ResultSet rs = stmt.executeQuery()){
					while(rs.next()) {
						list.add(rs.getInt("first_person"));
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get associated people ids",e);
		}
		return list;
	}
	
	@Override
	public boolean check(Person person1, Person person2) {
		boolean result = false;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "SELECT MIN(first_person) FROM ADMIN.ASSOCIATED_PEOPLE_JT "
					+ "WHERE first_person = ? AND second_person = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, person1.getId());
				stmt.setInt(2, person2.getId());
				try(ResultSet rs = stmt.executeQuery()){
					while(rs.next()) {
						if (rs.getInt(1)>0)result = true;
					}
				}
			}
			if (result == false) {
				String sql2 = "SELECT MIN(first_person) FROM ADMIN.ASSOCIATED_PEOPLE_JT "
						+ "WHERE first_person = ? AND second_person = ?";
				try(PreparedStatement stmt = conn.prepareStatement(sql2)){
					stmt.setInt(2, person1.getId());
					stmt.setInt(1, person2.getId());
					try(ResultSet rs = stmt.executeQuery()){
						while(rs.next()) {
							if (rs.getInt(1)>0)result = true;
						}
					}
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to get permission rank",e);
		}
		return result;
	}

	@Override
	public boolean delete(AssociatedPeople associatedPeopleToDelete) {
		return delete(associatedPeopleToDelete.getFirstPersonId(), associatedPeopleToDelete.getSecondPersonId());
	}

	@Override
	public boolean delete(int person1Id, int person2Id) {
		Boolean result = false;
		try (Connection conn = DAOUtilities.getConnection()){
			String sql = "DELETE FROM ADMIN.ASSOCIATED_PEOPLE_JT WHERE first_person = ? AND second_person = ?";
			try(PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, person1Id);
				stmt.setInt(2, person2Id);
				int rs = stmt.executeUpdate();
				if (rs > 0) {
					result = true;
				}
			}
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed to delete associated people.",e);
		}
		return result;
	}
	
	private AssociatedPeople objectBuilder(ResultSet rs) throws SQLException {
		return new AssociatedPeople(
				rs.getInt("first_person"),
				rs.getInt("second_person")
				);
	}
}
