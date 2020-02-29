package com.revature.bank.model;

import java.util.Objects;

public class AccountTransactionType {
	//SECTION: variables
	private static int maxId =0;
	private static int depositId = 1;
	private static int withrawId = 2;
	private static int transferId = 3;
	private int id;
	private String label;
	//SECTION: constructors
	public AccountTransactionType(String label) {
		super();
		this.label = label;
		this.id = getNextMaxId();
	}
	//SECTION: getters & setters
	public static int getNextMaxId() {
		return ++maxId;
	}
	public static int getMaxId() {
		return maxId;
	}
	public static void setMaxId(int maxId) {
		AccountTransactionType.maxId = maxId;
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
	public static int getDepositId() {
		return depositId;
	}
	public static int getWithrawId() {
		return withrawId;
	}
	public static int getTransferId() {
		return transferId;
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
		if (!(obj instanceof AccountTransactionType)) {
			return false;
		}
		AccountTransactionType other = (AccountTransactionType) obj;
		return id == other.id && Objects.equals(label, other.label);
	}
	//SECTION: toString
	@Override
	public String toString() {
		return "AccountTransactionType [id=" + id + ", label=" + label + "]";
	}
}
