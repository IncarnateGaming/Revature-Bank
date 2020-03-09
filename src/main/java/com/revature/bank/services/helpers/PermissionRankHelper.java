package com.revature.bank.services.helpers;

import com.revature.bank.model.PermissionRank;
import com.revature.bank.services.handlers.PermissionRankHandler;

public class PermissionRankHelper {
	private static String permissionCustomer = "Customer";
	private static String permissionEmployee = "Employee";
	private static String permissionAdmin = "Admin";
	private static PermissionRank customer;
	private static PermissionRank employee;
	private static PermissionRank admin;
	private PermissionRankHelper() {
	}
	public static String getPermissionCustomer() {
		return permissionCustomer;
	}
	public static String getPermissionEmployee() {
		return permissionEmployee;
	}
	public static String getPermissionAdmin() {
		return permissionAdmin;
	}
	public static PermissionRank getCustomer() {
		if(customer == null) {
			customer = new PermissionRankHandler().create(
					new PermissionRank(PermissionRankHelper.permissionCustomer)
					);
		}
		return customer;
	}
	public static PermissionRank getEmployee() {
		if(employee == null) {
			employee = new PermissionRankHandler().create(
					new PermissionRank(PermissionRankHelper.permissionEmployee)
					);
		}
		return employee;
	}
	public static PermissionRank getAdmin() {
		if(admin == null) {
			admin = new PermissionRankHandler().create(
					new PermissionRank(PermissionRankHelper.permissionAdmin)
					);
		}
		return admin;
	}
}
