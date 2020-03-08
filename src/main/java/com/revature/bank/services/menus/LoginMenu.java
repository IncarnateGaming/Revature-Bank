package com.revature.bank.services.menus;

import com.revature.bank.exceptions.ForceCloseThread;
import com.revature.bank.exceptions.ReturnMainMenu;
import com.revature.bank.model.Person;
import com.revature.bank.services.handlers.PersonHandler;
import com.revature.bank.services.helpers.MenuHelper;

public class LoginMenu extends AbstractMenu{
	
	public LoginMenu(MainMenu mainMenu) {
		super();
		setMainMenu(mainMenu);
	}

	@Override
	public AbstractMenu menuFactory() throws ForceCloseThread, ReturnMainMenu {
		AbstractMenu result = null;
		boolean loginSuccess = false;
		do {
			System.out.println("Enter Username:");
			String username = MenuHelper.inputToken(s);
			System.out.println("Enter Password:");
			String password = MenuHelper.inputToken(s);
			Person user = new PersonHandler().get(username);
			if(user != null && user.getPassword() == password) {
				loginSuccess = true;
				getMainMenu().setPerson(user);
//				getMainMenu().setPermissions();
				//TODO finish setting permissions
			}else {
				System.out.println("Login failed, try again.");
			}
		}while (loginSuccess == false);
//		do {
//			System.out.println("Press 1 to login as Customer, 2 for Employee, 3 for Admin. Press 0 to return to previous menu.");
//			setInput(MenuHelper.inputPositiveInt(s));
//			getMainMenu().setPerson(new Person("awesome","engage","Bob","Saget"));
//			switch(getInput()) {
//			case 0:
//				break;
//			case 1:
//				List<PermissionRank> customerPermission = new ArrayList<>(1);
//				customerPermission.add(new PermissionRank(1, "Customer"));
//				getMainMenu().setPermissions(customerPermission);
//				result = new CustomerMenu(getMainMenu());
//				break;
//			case 2:
//				List<PermissionRank> employeePermission = new ArrayList<>(1);
//				employeePermission.add(new PermissionRank(2, "Employee"));
//				getMainMenu().setPermissions(employeePermission);
//				result = new EmployeeMenu(getMainMenu());
//				break;
//			case 3:
//				List<PermissionRank> adminPermission = new ArrayList<>(1);
//				adminPermission.add(new PermissionRank(2, "Admin"));
//				getMainMenu().setPermissions(adminPermission);
//				result = new EmployeeMenu(getMainMenu());
//				break;
//			default:
//				System.out.println("No accepted number entered, please try again");
//			}
//		}while(getInput()!=0 && result == null);
		return result;
	}
}
