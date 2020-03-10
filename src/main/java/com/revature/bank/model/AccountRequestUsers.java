package com.revature.bank.model;

import java.util.Objects;

public class AccountRequestUsers {
	//SECTION: variables
		private int personId;
		private int accountRequestId;
	//SECTION: constructors
		public AccountRequestUsers(int personId, int accountRequestId) {
			super();
			setPersonId(personId);
			setAccountRequestId(accountRequestId);
		}
	//SECTION: getters & setters
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
			return Objects.hash(accountRequestId, personId);
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
			return accountRequestId == other.accountRequestId &&  personId == other.personId;
		}
	//SECTION: toString
		@Override
		public String toString() {
			return "AccountRequestUsers [personId=" + personId + ", accountRequestId=" + accountRequestId
					+ "]";
		}

}
