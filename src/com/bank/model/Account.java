package com.bank.model;

public class Account {
	//SECTION: variables
	static private int maxId =0;
	private int id;
	private int accountTypeId;
	private double balance;
	private int overdraftProtection;
	
	//SECTION: constructors
	
	
	//SECTION: getters & setters
	public static int getNextMaxId() {
		return ++maxId;
	}
	public static int getMaxId() {
		return maxId;
	}
	public static void setMaxId(int maxId) {
		Account.maxId = maxId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccountTypeId() {
		return accountTypeId;
	}
	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getOverdraftProtection() {
		return overdraftProtection;
	}
	public void setOverdraftProtection(int overdraftProtection) {
		this.overdraftProtection = overdraftProtection;
	}
	//SECTION: methods
	//SECTION: hash && equals
	//SECTION: toString
}
