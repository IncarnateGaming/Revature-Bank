package com.revature.bank.model;

import java.util.Objects;

public class PermissionRank {
	//SECTION: variables
		private int id;
		private String label;
	//SECTION: constructors
		public PermissionRank(String label) {
			super();
			setLabel(label);
		}
		public PermissionRank(String label, int id) {
			this(label);
			setId(id);
		}
	//SECTION: getters & setters
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
		if (!(obj instanceof PermissionRank)) {
			return false;
		}
		PermissionRank other = (PermissionRank) obj;
		return Objects.equals(label, other.label);
	}
	//SECTION: toString
	@Override
	public String toString() {
		return "Permission [id=" + id + ", label=" + label + "]";
	}

}
