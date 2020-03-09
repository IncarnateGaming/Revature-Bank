package com.revature.bank.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class AccountOwnership implements Serializable {
	private static final long serialVersionUID = 2554185222397117453L;
	//SECTION: variables

	private int id;
	private int ownerId;
	private int accountId;
	private Date date;
	
	//SECTION: constructors
	
	public AccountOwnership(int accountId, int ownerId) {
		super();
		setAccountId(accountId);
		setOwnerId(ownerId);
		setDateToday();
	}
	
	//SECTION: getters & setters

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
