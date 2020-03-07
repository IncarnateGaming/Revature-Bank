package com.revature.bank.model;

import java.util.Date;
import java.util.Objects;

public class AccountTransaction {
	//SECTION: variables
	private static int maxId =0;
	private int id;
	private int accountId;
	private int statusId;
	private int transactionType;
	private String notes;
	private int relatedTransactionId;
	private Date transactionDate;
	//SECTION: constructors
	public AccountTransaction(int accountId, int statusId, int transactionType, String notes) {
		super();
		id = getNextMaxId();
		setAccountId(accountId);
		setStatusId(statusId);
		setTransactionType(transactionType);
		setNotes(notes);
		setTransactionDate(new Date());
	}
	public AccountTransaction(int accountId, int statusId, int transactionType, String notes,
			int relatedTransactionId) {
		this(accountId,statusId,transactionType,notes);
		setRelatedTransactionId(relatedTransactionId);
	}
	
	//SECTION: getters & setters
	
	public static int getNextMaxId() {
		return ++maxId;
	}
	public static int getMaxId() {
		return maxId;
	}
	public static void setMaxId(int maxId) {
		AccountTransaction.maxId = maxId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public int getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public int getRelatedTransactionId() {
		return relatedTransactionId;
	}
	public void setRelatedTransactionId(int relatedTransactionId) {
		this.relatedTransactionId = relatedTransactionId;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	//SECTION: methods
	//SECTION: hash && equals
	
	@Override
	public int hashCode() {
		return Objects.hash(accountId, id, notes, relatedTransactionId, statusId, transactionDate, transactionType);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AccountTransaction)) {
			return false;
		}
		AccountTransaction other = (AccountTransaction) obj;
		return accountId == other.accountId && id == other.id && Objects.equals(notes, other.notes)
				&& relatedTransactionId == other.relatedTransactionId && statusId == other.statusId
				&& Objects.equals(transactionDate, other.transactionDate) && transactionType == other.transactionType;
	}
	
	//SECTION: toString
	
	@Override
	public String toString() {
		return "AccountTransaction [id=" + id + ", accountId=" + accountId + ", statusId=" + statusId
				+ ", transactionType=" + transactionType + ", notes=" + notes + ", relatedTransactionId="
				+ relatedTransactionId + ", transactionDate=" + transactionDate + "]";
	}

}
