package com.revature.bank.model;

import java.util.Objects;

public class PermissionRank {
	//SECTION: variables
		private static int maxId =0;
		private int id;
		private int personId;
		private String label;
		private static String rankCustomer = "Customer";
		private static String rankEmployee = "Employee";
		private static String rankAdmin = "Admin";
	//SECTION: constructors
		public PermissionRank(int personId, String label) {
			super();
			id = getNextMaxId();
			setPersonId(personId);
			setLabel(label);
		}
	//SECTION: getters & setters
	public static int getNextMaxId() {
		return ++maxId;
	}
	public static int getMaxId() {
		return maxId;
	}
	public static void setMaxId(int maxId) {
		PermissionRank.maxId = maxId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public static String getRankCustomer() {
		return rankCustomer;
	}
	public static String getRankEmployee() {
		return rankEmployee;
	}
	public static String getRankAdmin() {
		return rankAdmin;
	}
	//SECTION: methods
	//SECTION: hash && equals
	@Override
	public int hashCode() {
		return Objects.hash(id, label, personId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PermissionRank)) {
			return false;
		}
		PermissionRank other = (PermissionRank) obj;
		return Objects.equals(label, other.label);
	}
	//SECTION: toString
	@Override
	public String toString() {
		return "Permission [id=" + id + ", personId=" + personId + ", label=" + label + "]";
	}

}
