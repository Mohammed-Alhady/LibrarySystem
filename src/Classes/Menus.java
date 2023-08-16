package src.Classes;

import java.util.Scanner;

public class Menus {

    static Scanner in = new Scanner(System.in);

    // admin menu
    public static void adminMenu() {
        try {
            System.out.println("1: add a tenate");
            System.out.println("2: remove a tenate");
            System.out.println("3: add a book");
            System.out.println("4: remover a book");
            System.out.println("5: add a new admin");
            System.out.println("6: remove am admin");
            System.out.println("7: show all books");
            int numberOfMethod = in.nextInt();

            switch (numberOfMethod) {
                case 1:
                    AdminMethods.addUser();
                    break;
                case 2:
                    AdminMethods.removerUser();
                    break;
                case 3:
                    AdminMethods.addBook();
                    break;
                case 4:
                    AdminMethods.removerBook();
                    break;
                case 5:
                    AdminMethods.addANewAdmin();
                    break;
                case 6:
                    AdminMethods.removeAdmin();
                    break;
                case 7:
                    AdminMethods.showAllBooks();
                    break;
                default:
                    System.out.println("please enter a valid number");
                    adminMenu();
            }
        } catch (Exception e) {
            System.out.println("something went wrong, please try again");
            adminMenu();
        }
    }

    // user menu
    public static void userMenu(String name, String email) {
        try {
            System.out.println("1: borrow a book");
            System.out.println("2: return a book");
            System.out.println("3: buy a book");
            System.out.println("4: show all books");
            System.out.println("5: show my books");
            System.out.println("6: find a book");
            int numberOfMethod = in.nextInt();

            switch (numberOfMethod) {
                case 1:
                    TenateMethods.borrowABook(name, email);
                    break;
                case 2:
                    TenateMethods.returnABook(name, email);
                    break;
                case 3:
                    TenateMethods.buyABook(name, email);
                    break;
                case 4:
                    AdminMethods.showAllBooks();
                    break;
                case 5:
                    TenateMethods.showMyBooks(name, email);
                    break;
                case 6:
                    TenateMethods.findABook(name, email);
                    break;
                default:
                    System.out.println("please enter a valid number");
                    userMenu(name, email);
            }
        } catch (Exception e) {
            System.out.println("please enter a valid number");
            userMenu(name, email);
        }
    }
}
