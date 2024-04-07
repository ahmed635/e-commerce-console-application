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
        System.out.println(user);
        if (user != null && user.getPassword().equalsIgnoreCase(password)){
            System.out.printf("Glad to see you back %s %s", user.getFirstName(),
                user.getLastName() + System.lineSeparator());
            context.setLoggedInUser(user);
        } else 
            System.out.println("Unfortunately, such login and password doesn't exist");
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** SIGN IN ***");
    }
}
