package com.bank.model;

import java.util.Objects;

public class AccountRequestUsers {
	//SECTION: variables
		private static int maxId =0;
		private int id;
		private int personId;
		private int accountRequestId;
	//SECTION: constructors
		public AccountRequestUsers(int personId, int accountRequestId) {
			super();
			id = getNextMaxId();
			setPersonId(personId);
			setAccountRequestId(accountRequestId);
		}
	//SECTION: getters & setters
		public static int getNextMaxId() {
			return ++maxId;
		}
		public static int getMaxId() {
			return maxId;
		}
		public static void setMaxId(int maxId) {
			AccountRequestUsers.maxId = maxId;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getPersonId() {
			return personId;
		}
		public void setPersonId(int personId) {
			this.personId = personId;
		}
		public int getAccountRequestId() {
			return accountRequestId;
		}
		public void setAccountRequestId(int accountRequestId) {
			this.accountRequestId = accountRequestId;
		}
	//SECTION: methods
	//SECTION: hash && equals
		@Override
		public int hashCode() {
			return Objects.hash(accountRequestId, id, personId);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof AccountRequestUsers)) {
				return false;
			}
			AccountRequestUsers other = (AccountRequestUsers) obj;
			return accountRequestId == other.accountRequestId && id == other.id && personId == other.personId;
		}
	//SECTION: toString
		@Override
		public String toString() {
			return "AccountRequestUsers [id=" + id + ", personId=" + personId + ", accountRequestId=" + accountRequestId
					+ "]";
		}

}
