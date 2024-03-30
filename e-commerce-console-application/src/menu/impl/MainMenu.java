package menu.impl;

import configs.ApplicationContext;
import menu.Menu;

import java.util.Scanner;

public class MainMenu implements Menu {
    public static final String MENU_COMMAND = "menu";

    private static final String MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER = "Please, enter number in console to proceed." + System.lineSeparator()
            + "1. Sign Up" + System.lineSeparator() + "2. Sign In"
            + System.lineSeparator() + "3. Product Catalog" + System.lineSeparator()
            + "4. My Orders" + System.lineSeparator() + "5. Settings" + System.lineSeparator() +
            "6. Customer List";

    private static final String MAIN_MENU_TEXT_FOR_LOGGED_IN_USER = "Please, enter number in console to proceed." + System.lineSeparator()
            + "1. Sign Up" + System.lineSeparator() + "2. Sign Out"
            + System.lineSeparator() + "3. Product Catalog" + System.lineSeparator()
            + "4. My Orders" + System.lineSeparator() + "5. Settings" + System.lineSeparator() +
            "6. Customer List";;

    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        boolean isValidInput = true;
        Scanner scanner = new Scanner(System.in);
        String userInput;

        while (isValidInput){
            printMenuHeader();
            System.out.print("User Input: ");
            userInput = scanner.next();

            switch (userInput){
                case "1":
                    System.out.println("Sign Up");
                    isValidInput = false;
                    break;
                case "2":
                    System.out.println("Sign In");
                    isValidInput = false;
                    break;
                case "3":
                    System.out.println("Product Catalog");
                    isValidInput = false;
                    break;
                case "4":
                    System.out.println("My Orders");
                    isValidInput = false;
                    break;
                case "5":
                    System.out.println("Settings");
                    isValidInput = false;
                    break;
                case "6":
                    System.out.println("Customer List");
                    isValidInput = false;
                    break;
                case "exit":
                    System.out.println("Exiting the app");
                    isValidInput = false;
                    break;
                default:
                    System.out.println("Only 1, 2, 3, 4, 5 is allowed. Try one more time");
                    break;
            }
        }

    }

    @Override
    public void printMenuHeader() {
        System.out.println("******** Main Menu ********");
        System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER);
    }
}
