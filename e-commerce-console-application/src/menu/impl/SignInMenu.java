package menu.impl;

import configs.ApplicationContext;
import menu.Menu;
import services.UserManagementService;
import services.impl.DefaultUserManagementService;
import java.util.Scanner;
import entities.*;

public class SignInMenu implements Menu {
    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        context = ApplicationContext.getInstance();
        userManagementService = DefaultUserManagementService.getInstance();
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your eamil:");
        String email = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        User user = userManagementService.getUserByEmail(email);
        if (user != null && user.getPassword().equals(password))
            System.out.println("Glad to see you back " + user.getFirstName() + " " + user.getLastName());
        else 
            System.out.println("Unfortunately, such login and password doesn't exist");
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** SIGN IN ***");
    }
}
