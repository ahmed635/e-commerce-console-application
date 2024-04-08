package menu.impl;

import configs.ApplicationContext;
import menu.Menu;
import services.UserManagementService;
import services.impl.DefaultUserManagementService;
import entities.*;
import java.util.List;

public class CustomerListMenu implements Menu {
    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
		List<User> users = userManagementService.getUsers();
		
		if (users.size() == 0) {
			System.out.println("Unfortunately, there are no customers.");
		} else {
			for (User user : users) {
				System.out.println(user);
			}
		}
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** Users ***");
    }
}
