package com.revature.bank.model;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable{
	private static final long serialVersionUID = 4583212612792271521L;
	//SECTION: variables
	private static int maxId =0;
	private int id;
	private int accountTypeId;
	private double balance;
	private int overdraftProtection;
	private boolean active;
	
	//SECTION: constructors
	
	/**
	 * 
	 * @param accountTypeId
	 * @param balance
	 * @param overdraftProtection
	 */
	public Account(int accountTypeId, double balance, int overdraftProtection) {
		super();
		setAccountTypeId(accountTypeId);
		setBalance(balance);
		setOverdraftProtection(overdraftProtection);
		setActive(true);
	}
	public Account(int accountTypeId, double balance, int overdraftProtection, boolean active) {
		this(accountTypeId, balance, overdraftProtection);
		setActive(active);
	}
	/**
	 * 
	 * @param id
	 * @param accountTypeId
	 * @param balance
	 * @param overdraftProtection
	 * @param active
	 */
	public Account(int id, int accountTypeId, double balance, int overdraftProtection,boolean active) {
		this(accountTypeId,balance,overdraftProtection,active);
		this.id = id;
	}
	



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
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	//SECTION: methods
	//SECTION: hash && equals

	@Override
	public int hashCode() {
		return Objects.hash(accountTypeId, balance, id, overdraftProtection);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Account)) {
			return false;
		}
		Account other = (Account) obj;
		return accountTypeId == other.accountTypeId
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance) && id == other.id
				&& overdraftProtection == other.overdraftProtection;
	}
	
	//SECTION: toString

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountTypeId=" + accountTypeId + ", balance=" + balance
				+ ", overdraftProtection=" + overdraftProtection + "]";
	}
}