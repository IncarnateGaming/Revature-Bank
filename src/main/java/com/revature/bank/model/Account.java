package com.revature.bank.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import com.revature.bank.services.helpers.LoggerSingleton;

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
	
	public Account(int accountTypeId, double balance, int overdraftProtection) {
		super();
		id = getNextMaxId();
		setAccountTypeId(accountTypeId);
		setBalance(balance);
		setOverdraftProtection(overdraftProtection);
		setActive(true);
	}
	

	public Account(ResultSet rs) {
		super();
		try {
			setId(rs.getInt("account_id"));
			setAccountTypeId(rs.getInt("account_type"));
			setBalance(rs.getDouble("balance"));
			setOverdraftProtection(rs.getInt("overdraft_protection"));
			setActive(rs.getBoolean("active"));
		}catch(SQLException e) {
			LoggerSingleton.getLogger().warn("Failed account creation",e);
		}
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
	public boolean isActive() {
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