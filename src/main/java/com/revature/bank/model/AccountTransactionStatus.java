package com.revature.bank.model;

import java.util.Objects;

public class AccountTransactionStatus {
	//SECTION: variables
	
	private static int maxId =0;
	private static int pendingId = 1;
	private static int approvedId = 2;
	private static int rejectedId = 3;
	private int id;
	private String label;
	
	//SECTION: constructors
	
	public AccountTransactionStatus(String label) {
		super();
		id = getNextMaxId();
		setLabel(label);
	}
	
	//SECTION: getters & setters
	
	public static int getNextMaxId() {
		return ++maxId;
	}
	public static int getMaxId() {
		return maxId;
	}
	public static void setMaxId(int maxId) {
		AccountTransactionStatus.maxId = maxId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public static int getPendingId() {
		return pendingId;
	}
	public static int getApprovedId() {
		return approvedId;
	}
	public static int getRejectedId() {
		return rejectedId;
	}
	//SECTION: methods
	//SECTION: hash && equals
	@Override
	public int hashCode() {
		return Objects.hash(id, label);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AccountTransactionStatus)) {
			return false;
		}
		AccountTransactionStatus other = (AccountTransactionStatus) obj;
		return id == other.id && Objects.equals(label, other.label);
	}

	//SECTION: toString

	@Override
	public String toString() {
		return "AccountTransactionStatus [id=" + id + ", label=" + label + "]";
	}

}
