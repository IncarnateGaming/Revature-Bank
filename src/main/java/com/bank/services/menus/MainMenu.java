package com.bank.services.menus;

import java.util.List;

import com.bank.exceptions.ForceCloseThread;
import com.bank.exceptions.UnsupportedInteger;
import com.bank.model.PermissionRank;
import com.bank.model.Person;
import com.bank.services.helpers.MenuHelper;

public class MainMenu extends AbstractMenu{
	private Person person;
	private List<PermissionRank> permissions;
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public List<PermissionRank> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<PermissionRank> permissions) {
		this.permissions = permissions;
	}
	/**
	 * Checks to see if the currently logged in person has a particular permission
	 * @param permissionLabel
	 * @return boolean
	 */
	public boolean containsPermission(String permissionLabel) {
		boolean result = false;
		for (PermissionRank permission : permissions) {
			if(permission.getLabel() == permissionLabel) {
				result = true;
				break;
			}
		}
		return result;
	}
	/**
	 * Checks to see if the currently logged in person has a particular permission
	 * @param checkPermission
	 * @return boolean
	 */
	public boolean containsPermission(PermissionRank checkPermission) {
		boolean result = false;
		for (PermissionRank permission : permissions) {
			if(permission.equals(checkPermission)) {
				result = true;
				break;
			}
		}
		return result;
	}
	public void run() throws ForceCloseThread {
		try {
			do {
				System.out.println("Press 1 to login or 2 to create a new account. Press 0 to exit.");
				setInput(MenuHelper.inputPositiveInt(s));
				switch(getInput()) {
				case 0:
					break;
				case 1:
					LoginMenu loginMenu = new LoginMenu(this);
					loginMenu.run();
					break;
				case 2:
					NewPersonMenu newPersonMenu = new NewPersonMenu(this);
					newPersonMenu.run();
					break;
				default:
					Exception newException = new UnsupportedInteger("The integer: " + getInput() + " is unsupported in this menu.");
					log.warn(newException.getMessage(), newException);
					System.out.println("No accepted number entered, please try again");
				}
			}while (getInput() != 0);
		}finally {
			log.trace("Program Closed");
		}
	}
}
