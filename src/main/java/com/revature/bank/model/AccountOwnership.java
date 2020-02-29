package com.revature.bank.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class AccountOwnership implements Serializable {
	private static final long serialVersionUID = 2554185222397117453L;
	//SECTION: variables

	private static int maxId =0;
	private int id;
	private int ownerId;
	private int accountId;
	private Date date;
	
	//SECTION: constructors
	
	public AccountOwnership(int ownerId, int accountId) {
		super();
		id = getNextMaxId();
		setOwnerId(ownerId);
		setAccountId(accountId);
		setDateToday();
	}
	
	//SECTION: getters & setters

	public static int getNextMaxId() {
		return ++maxId;
	}
	public static int getMaxId() {
		return maxId;
	}
	public static void setMaxId(int maxId) {
		AccountOwnership.maxId = maxId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setDateToday() {
		this.date = new Date();
	}


	//SECTION: methods
	//SECTION: hash && equals

	@Override
	public int hashCode() {
		return Objects.hash(accountId, date, id, ownerId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AccountOwnership)) {
			return false;
		}
		AccountOwnership other = (AccountOwnership) obj;
		return accountId == other.accountId && Objects.equals(date, other.date) && id == other.id
				&& ownerId == other.ownerId;
	}

	//SECTION: toString

	@Override
	public String toString() {
		return "AccountOwnership [id=" + id + ", ownerId=" + ownerId + ", accountId=" + accountId + ", date=" + date
				+ "]";
	}

}
