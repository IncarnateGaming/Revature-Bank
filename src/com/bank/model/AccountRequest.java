package com.bank.model;

import java.util.Date;
import java.util.Objects;

public class AccountRequest {
	//SECTION: variables
		private static int maxId =0;
		private int id;
		private int accountTypeId;
		private Date creationDate;
	//SECTION: constructors
		public AccountRequest(int accountTypeId, Date date) {
			super();
			id = getNextMaxId();
			setAccountTypeId(accountTypeId);
			setCreationDateToday();
		}
	//SECTION: getters & setters
	public static int getNextMaxId() {
		return ++maxId;
	}
	public static int getMaxId() {
		return maxId;
	}
	public static void setMaxId(int maxId) {
		AccountRequest.maxId = maxId;
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
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public void setCreationDateToday() {
		this.creationDate = new Date();
	}
	//SECTION: methods
	//SECTION: hash && equals
	@Override
	public int hashCode() {
		return Objects.hash(accountTypeId, creationDate, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AccountRequest)) {
			return false;
		}
		AccountRequest other = (AccountRequest) obj;
		return accountTypeId == other.accountTypeId && Objects.equals(creationDate, other.creationDate)
				&& id == other.id;
	}
	//SECTION: toString
	@Override
	public String toString() {
		return "AccountRequest [id=" + id + ", accountTypeId=" + accountTypeId + ", creationDate=" + creationDate + "]";
	}

}
