package com.revature.bank.model;

import java.util.Objects;

import com.revature.bank.resources.State;

public class City {
	//SECTION: variables

	private static int maxId =0;
	private int id;
	private String city;
	private State state;
	private int zip;
	//SECTION: constructors
	
	public City(String city, State state, int zip) {
		super();
		id = getNextMaxId();
		setCity(city);
		setState(state);
		setZip(zip);
	}
	
	//SECTION: getters & setters
	
	public static int getNextMaxId() {
		return ++maxId;
	}
	public static int getMaxId() {
		return maxId;
	}
	public static void setMaxId(int maxId) {
		City.maxId = maxId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	
	//SECTION: methods
	//SECTION: hash && equals

	@Override
	public int hashCode() {
		return Objects.hash(city, id, state, zip);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof City)) {
			return false;
		}
		City other = (City) obj;
		return Objects.equals(city, other.city) && id == other.id && state == other.state && zip == other.zip;
	}

	//SECTION: toString

	@Override
	public String toString() {
		return "City [id=" + id + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}

}
