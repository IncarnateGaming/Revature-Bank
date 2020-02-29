package com.revature.bank.model;

import java.util.Objects;

public class AccountType {
	//SECTION: variables
		private static int maxId =0;
		private int id;
		private String label;
		private int minBalance;
		private double interest;
	//SECTION: constructors
		public AccountType(String label, int minBalance, double interest) {
			super();
			id = getNextMaxId();
			setLabel(label);
			setMinBalance(minBalance);
			setInterest(interest);
		}
	//SECTION: getters & setters
		public static int getNextMaxId() {
			return ++maxId;
		}
		public static int getMaxId() {
			return maxId;
		}
		public static void setMaxId(int maxId) {
			AccountType.maxId = maxId;
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
		public int getMinBalance() {
			return minBalance;
		}
		public void setMinBalance(int minBalance) {
			this.minBalance = minBalance;
		}
		public double getInterest() {
			return interest;
		}
		public void setInterest(double interest) {
			this.interest = interest;
		}
	//SECTION: methods
	//SECTION: hash && equals
		@Override
		public int hashCode() {
			return Objects.hash(id, interest, label, minBalance);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof AccountType)) {
				return false;
			}
			AccountType other = (AccountType) obj;
			return id == other.id && Double.doubleToLongBits(interest) == Double.doubleToLongBits(other.interest)
					&& Objects.equals(label, other.label) && minBalance == other.minBalance;
		}
	//SECTION: toString
		@Override
		public String toString() {
			return "AccountType [id=" + id + ", label=" + label + ", minBalance=" + minBalance + ", interest="
					+ interest + "]";
		}
}
