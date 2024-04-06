package menu.impl;

import configs.ApplicationContext;
import menu.Menu;
import java.util.Scanner;
import entities.*;

public class ChangeEmailMenu implements Menu {
    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine();
        context.getLoggedInUser().setEmail(email);
        System.out.println("Your email has been successfully changed");
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** Change Email ***");
        System.out.println("Enter new email: ");
    }
}
