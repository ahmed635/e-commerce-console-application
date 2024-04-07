package menu.impl;

import configs.ApplicationContext;
import menu.Menu;
import services.UserManagementService;
import services.impl.DefaultUserManagementService;
import java.util.Scanner;
import entities.*;
import entities.impl.DefaultUser;

public class SignUpMenu implements Menu {
    private UserManagementService userManagementService;
    private ApplicationContext context;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        DefaultUser user = new DefaultUser();

        printMenuHeader();

        System.out.println("Enter first name: ");
        user.setFirstName(scanner.nextLine());
        System.out.println("Enter last name: ");
        user.setLasttName(scanner.nextLine());
        System.out.println("Enter email: ");
        user.setEmail(scanner.nextLine());
        System.out.println("Enter password: ");
        user.setPassword(scanner.nextLine());

        String noteficationMessage = userManagementService.registerUser(user);
        if(!noteficationMessage.isEmpty())
            System.out.println(noteficationMessage);
        else 
            System.out.println("New user is created");
            context.setLoggedInUser(user);
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** SIGN UP *****");
    }
}
