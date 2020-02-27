package com.bank.model;

import java.util.Objects;

/**
 * Tracks the standing/credibility/integrity of an individual with the bank
 * @author ProNobis
 *
 */
public class PersonStanding {
	//SECTION: variables
		private static int maxId =0;
		private int id;
		private String label;
	//SECTION: constructors
		public PersonStanding(String label) {
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
			PersonStanding.maxId = maxId;
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
			if (!(obj instanceof PersonStanding)) {
				return false;
			}
			PersonStanding other = (PersonStanding) obj;
			return id == other.id && Objects.equals(label, other.label);
		}
	//SECTION: toString
		@Override
		public String toString() {
			return "PersonStanding [id=" + id + ", label=" + label + "]";
		}

}
