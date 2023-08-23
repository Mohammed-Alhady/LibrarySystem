package src.Classes;

import java.util.Scanner;

public class Menus {

    static Scanner in = new Scanner(System.in);

    // admin menu
    public static void adminMenu() {
        System.out.println("#1: add a tenate");
        System.out.println("#2: remove a tenate");
        System.out.println("#3: add a book");
        System.out.println("#4: remover a book");
        System.out.println("#5: add a new admin");
        System.out.println("#6: remove am admin");
        System.out.println("#7: show all books");
        System.out.println("#8: close the system");

        try {
            int numberOfMethod = in.nextInt();
            switch (numberOfMethod) {
                case 1:
                    AdminMethods.addUser();
                    System.out.println("##added successfully##");
                    adminMenu();
                    break;
                case 2:
                    AdminMethods.removerUser();
                    System.out.println("##removed successfully##");
                    adminMenu();
                    break;
                case 3:
                    AdminMethods.addBook();
                    System.out.println("##added successfully##");
                    adminMenu();
                    break;
                case 4:
                    AdminMethods.removerBook();
                    System.out.println("##removed successfully##");
                    return;
                case 5:
                    AdminMethods.addANewAdmin();
                    System.out.println("##added successfully##");
                    adminMenu();
                    break;
                case 6:
                    AdminMethods.removeAdmin();
                    System.out.println("##removed successfully##");
                    adminMenu();
                    break;
                case 7:
                    AdminMethods.showAllBooks();
                    adminMenu();
                    break;
                case 8:
                    System.out.println("bye bye :)");
                    return;
                default:
                    System.out.println("please enter a valid number");
                    in.close();
                    adminMenu();
            }
        } catch (Exception e) {
            System.out.println("something went wrong, please try again");
            in.close();
        }
    }

    // user menu
    public static void userMenu(String name, String email) {
        System.out.println("#1: borrow a book");
        System.out.println("#2: return a book");
        System.out.println("#3: buy a book");
        System.out.println("#4: show all books");
        System.out.println("#5: show my books");
        System.out.println("#6: find a book");
        System.out.println("#7: close the system");

        try {
            int numberOfMethod = in.nextInt();
            try {
                switch (numberOfMethod) {
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
                        return;
                    default:
                        System.out.println("please enter a valid number");
                        Menus.stop();
                }
            } catch (Exception e) {
                System.out.println("please enter a valid number");
                Menus.stop();
            }
        } catch (Exception e) {
            System.out.println("please enter a valid number");
            userMenu(name, email);
        }
    }

    public static void stop() {
        return;
    }
}
