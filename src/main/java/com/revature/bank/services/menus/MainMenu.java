package com.revature.bank.services.menus;

import java.util.List;

import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.Logout;
import com.revature.bank.exceptions.ReturnMainMenu;
import com.revature.bank.exceptions.UnsupportedInteger;
import com.revature.bank.model.PermissionRank;
import com.revature.bank.model.Person;
import com.revature.bank.services.helpers.MenuHelper;

public class MainMenu extends AbstractMenu implements Runnable{
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
	public AbstractMenu menuFactory() throws ForceCloseThread, ReturnMainMenu {
		AbstractMenu result = null;
		do {
			System.out.println("Press 1 to login or 2 to create a new account. Press 0 to exit."); 
			setInput(MenuHelper.inputPositiveInt(s));
			switch(getInput()) {
			case 0:
				System.out.println("Turning off.");
                System.exit(0);
				break;
			case 1:
				result = new LoginMenu(this);
				break;
			case 2:
				result = new NewPersonMenu(this);
				break;
			default:
				Exception newException = new UnsupportedInteger("The integer: " + getInput() + " is unsupported in this menu.");
				log.warn(newException.getMessage(), newException);
				System.out.println("No accepted number entered, please try again");
			}
		}while((result == null) && (getInput() != 0));
		return result;
	}
	public void runMenu(AbstractMenu thisMenu) throws ForceCloseThread, ReturnMainMenu{
		AbstractMenu nextMenu = thisMenu.menuFactory();
		if(nextMenu != null) {
			runMenu(nextMenu);
		}
	}
	public void run() {
		do {
			try {
				do {
					if(person == null) {
						runMenu(menuFactory());
					}else {
						LoginMenu loginMenu = new LoginMenu(this);
						runMenu(loginMenu);
					}
				}while (getInput() != 0);
			}catch(Logout e) {
				person = null;
				permissions = null;
				System.out.println("Logged out.");
			}catch(ForceCloseThread e) {
				Thread.currentThread().interrupt();
				return;
			}catch(ReturnMainMenu e) {
				System.out.println("Returned to Main Menu");
			}
		}while (getInput() != 0);
		System.out.println("Thread Terminated");
	}
}
