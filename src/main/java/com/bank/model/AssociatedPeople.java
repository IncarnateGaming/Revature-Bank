package com.bank.model;

import java.util.Objects;

/**
 * Connects one person to another allowing people to connect identities and request
 * joint accounts.
 * @author Philip Lawrence
 *
 */
public class AssociatedPeople {
	//SECTION: variables
		private static int maxId =0;
		private int id;
		private int firstPersonId;
		private int secondPersonId;
	//SECTION: constructors
		public AssociatedPeople(int firstPersonId, int secondPersonId) {
			super();
			id = getNextMaxId();
			setFirstPersonId(firstPersonId);
			setSecondPersonId(secondPersonId);
		}
	//SECTION: getters & setters
		public static int getNextMaxId() {
			return ++maxId;
		}
		public static int getMaxId() {
			return maxId;
		}
		public static void setMaxId(int maxId) {
			AssociatedPeople.maxId = maxId;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getFirstPersonId() {
			return firstPersonId;
		}
		public void setFirstPersonId(int firstPersonId) {
			this.firstPersonId = firstPersonId;
		}
		public int getSecondPersonId() {
			return secondPersonId;
		}
		public void setSecondPersonId(int secondPersonId) {
			this.secondPersonId = secondPersonId;
		}
	//SECTION: methods
	//SECTION: hash && equals
		@Override
		public int hashCode() {
			return Objects.hash(firstPersonId, id, secondPersonId);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof AssociatedPeople)) {
				return false;
			}
			AssociatedPeople other = (AssociatedPeople) obj;
			return firstPersonId == other.firstPersonId && id == other.id && secondPersonId == other.secondPersonId;
		}
	//SECTION: toString
		@Override
		public String toString() {
			return "AssociatedPeople [id=" + id + ", firstPersonId=" + firstPersonId + ", secondPersonId="
					+ secondPersonId + "]";
		}

}