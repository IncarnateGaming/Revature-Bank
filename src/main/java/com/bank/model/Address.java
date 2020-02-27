package com.bank.model;

import java.util.Objects;

public class Address {
	//SECTION: variables

	private static int maxId =0;
	private int id;
	private String address;
	
	//SECTION: constructors

	public Address(String address) {
		super();
		id = getNextMaxId();
		setAddress(address);
	}
	
	//SECTION: getters & setters

	public static int getNextMaxId() {
		return ++maxId;
	}
	public static int getMaxId() {
		return maxId;
	}
	public static void setMaxId(int maxId) {
		Address.maxId = maxId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	//SECTION: methods
	//SECTION: hash && equals

	@Override
	public int hashCode() {
		return Objects.hash(address, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Address)) {
			return false;
		}
		Address other = (Address) obj;
		return Objects.equals(address, other.address) && id == other.id;
	}

	//SECTION: toString

	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + "]";
	}

}
