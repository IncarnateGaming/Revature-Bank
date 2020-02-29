package com.revature.bank.model;

import java.util.Objects;

public class Email {
	//SECTION: variables
		private static int maxId =0;
		private int id;
		private int personId;
		private String email;
	//SECTION: constructors
		public Email(int personId, String email) {
			super();
			id = getNextMaxId();
			setPersonId(personId);
			setEmail(email);
		}
	//SECTION: getters & setters
	public static int getNextMaxId() {
		return ++maxId;
	}
	public static int getMaxId() {
		return maxId;
	}
	public static void setMaxId(int maxId) {
		Email.maxId = maxId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//SECTION: methods
	//SECTION: hash && equals
	@Override
	public int hashCode() {
		return Objects.hash(email, id, personId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Email)) {
			return false;
		}
		Email other = (Email) obj;
		return Objects.equals(email, other.email) && id == other.id && personId == other.personId;
	}
	//SECTION: toString
	@Override
	public String toString() {
		return "Email [id=" + id + ", personId=" + personId + ", email=" + email + "]";
	}

}
