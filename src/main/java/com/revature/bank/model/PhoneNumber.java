package com.revature.bank.model;

import java.util.Objects;

public class PhoneNumber {
	//SECTION: variables
		private static int maxId =0;
		private int id;
		private int personId;
		private String number;
	//SECTION: constructors
		public PhoneNumber(int personId, String number) {
			super();
			id = getNextMaxId();
			setPersonId(personId);
			setNumber(number);
		}
	//SECTION: getters & setters
	public static int getNextMaxId() {
		return ++maxId;
	}
	public static int getMaxId() {
		return maxId;
	}
	public static void setMaxId(int maxId) {
		PhoneNumber.maxId = maxId;
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	//SECTION: methods
	//SECTION: hash && equals
	@Override
	public int hashCode() {
		return Objects.hash(id, number, personId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PhoneNumber)) {
			return false;
		}
		PhoneNumber other = (PhoneNumber) obj;
		return id == other.id && Objects.equals(number, other.number) && personId == other.personId;
	}
	//SECTION: toString
	@Override
	public String toString() {
		return "PhoneNumber [id=" + id + ", personId=" + personId + ", number=" + number + "]";
	}

}
