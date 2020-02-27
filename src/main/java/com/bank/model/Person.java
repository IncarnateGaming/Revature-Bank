package com.bank.model;

import java.util.Objects;

public class Person {
	//SECTION: variables

	private static int maxId =0;
	private int id;
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	private int standing;// Good, bad or ugly standing with the bank
	private String password;
	private int city;
	private int address;
	private String username;//TODO make unique
	
	//SECTION: constructors

	public Person(String firstName, String lastName, String socialSecurityNumber, int standing, String password,
			int city, int address, String username) {
		super();
		id = getNextMaxId();
		setFirstName(firstName);
		setFirstName(firstName);
		setLastName(lastName);
		setSocialSecurityNumber(socialSecurityNumber);
		setStanding(standing);
		setPassword(password);
		setCity(city);
		setAddress(address);
		setUsername(username);
	}

	//SECTION: getters & setters

	public static int getNextMaxId() {
		return ++maxId;
	}
	public static int getMaxId() {
		return maxId;
	}

	public static void setMaxId(int maxId) {
		Person.maxId = maxId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public int getStanding() {
		return standing;
	}

	public void setStanding(int standing) {
		this.standing = standing;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getAddress() {
		return address;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	//SECTION: methods
	//SECTION: hash && equals
	@Override
	public int hashCode() {
		return Objects.hash(address, city, firstName, id, lastName, password, socialSecurityNumber, standing, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Person)) {
			return false;
		}
		Person other = (Person) obj;
		return address == other.address && city == other.city && Objects.equals(firstName, other.firstName)
				&& id == other.id && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password)
				&& Objects.equals(socialSecurityNumber, other.socialSecurityNumber) && standing == other.standing
				&& Objects.equals(username, other.username);
	}
	//SECTION: toString

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", socialSecurityNumber="
				+ socialSecurityNumber + ", standing=" + standing + ", password=" + password + ", city=" + city
				+ ", address=" + address + ", username=" + username + "]";
	}
}
