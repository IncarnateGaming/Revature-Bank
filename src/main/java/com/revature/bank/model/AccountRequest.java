package com.revature.bank.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class AccountRequest implements Serializable {
	private static final long serialVersionUID = 6451961783162870844L;
	//SECTION: variables
		private int id;
		private int accountTypeId;
		private Date creationDate;
	//SECTION: constructors
		public AccountRequest(int accountTypeId) {
			super();
			setAccountTypeId(accountTypeId);
		}
		public AccountRequest(int accountTypeId, Date date) {
			this(accountTypeId);
			setCreationDate(date);
		}
	//SECTION: getters & setters
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
