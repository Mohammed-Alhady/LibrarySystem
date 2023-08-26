package src.Classes;

import java.util.Scanner;

public class Menus {

    static Scanner in = new Scanner(System.in);

    // admin menu
    public static void adminMenu() {
        System.out.println("#1: Add a user#");
        System.out.println("#2: Remove a user#");
        System.out.println("#3: Add a book#");
        System.out.println("#4: Remover a book#");
        System.out.println("#5: Add a new admin#");
        System.out.println("#6: Remove am admin#");
        System.out.println("#7: Show all books#");
        System.out.println("#8: Close the system#");

        String numberOfMethod = in.next();
        try {
            switch (Integer.parseInt(numberOfMethod.trim())) {
                case 1:
                    AdminMethods.addUser();
                    System.out.println("#added successfully#");
                    adminMenu();
                    break;
                case 2:
                    AdminMethods.removerUser();
                    System.out.println("#removed successfully#");
                    adminMenu();
                    break;
                case 3:
                    AdminMethods.addBook();
                    System.out.println("#added successfully#");
                    adminMenu();
                    break;
                case 4:
                    AdminMethods.removerBook();
                    System.out.println("#removed successfully#");
                    adminMenu();
                    break;
                case 5:
                    AdminMethods.addANewAdmin();
                    System.out.println("#added successfully#");
                    adminMenu();
                    break;
                case 6:
                    AdminMethods.removeAdmin();
                    System.out.println("#removed successfully#");
                    adminMenu();
                    break;
                case 7:
                    AdminMethods.showAllBooks();
                    adminMenu();
                    break;
                case 8:
                    System.out.println("bye bye :)");
                    stop();
                default:
                    System.out.println("#Error: Please enter a valid number#");
                    adminMenu();
            }
        } catch (Exception e) {
            System.out.println("#Error: Something went wrong, please try again#");
            adminMenu();
        }
    }

    // user menu
    public static void userMenu(String name, String email) {
        System.out.println("#1: Borrow a book#");
        System.out.println("#2: Return a book#");
        System.out.println("#3: Buy a book#");
        System.out.println("#4: Show all books#");
        System.out.println("#5: Show my books#");
        System.out.println("#6: Find a book#");
        System.out.println("#7: Close the system#");

        String numberOfMethod = in.next();
        try {
            switch (Integer.parseInt(numberOfMethod.trim())) {
                case 1:
                    UserMethods.borrowABook(name, email);
                    userMenu(name, email);
                    break;
                case 2:
                    UserMethods.returnABook(name, email);
                    userMenu(name, email);
                    break;
                case 3:
                    UserMethods.buyABook(name, email);
                    userMenu(name, email);
                    break;
                case 4:
                    AdminMethods.showAllBooks();
                    userMenu(name, email);
                    break;
                case 5:
                    UserMethods.showMyBooks(name, email);
                    userMenu(name, email);
                    break;
                case 6:
                    UserMethods.findABook(name, email);
                    userMenu(name, email);
                    break;
                case 7:
                    System.out.println("bye bye :)");
                    stop();
                default:
                    System.out.println("#Error: Please enter a valid number#");
                    Menus.userMenu(name, email);
            }
        } catch (Exception e) {
            System.out.println("#Please enter a valid number#");
            userMenu(name, email);
        }
    }

    public static void stop() {
        System.exit(0);
    }
}
