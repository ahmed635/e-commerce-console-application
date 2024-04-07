package menu.impl;

import configs.ApplicationContext;
import menu.Menu;
import entities.*;
import java.util.Scanner;

public class ChangePasswordMenu implements Menu {
    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        context.getLoggedInUser().setPassword(password);
        System.out.println("Your password has been successfully changed");
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** Change Password");
        System.out.println("Enter new password: ");
    }
}
