package src;

import java.util.Scanner;

import src.Classes.*;

public class Main {

    static Scanner in = new Scanner(System.in);

    // main method
    public static void main(String[] args) {
        System.out.println("welcome to the system :)");
        type();
    }

    // chose a type
    public static void type() {
        System.out.println("are you a User or an Admin");
        String type = in.nextLine().trim().toLowerCase();
        switch (type) {
            case "user":
                runAsUser();
                break;
            case "admin":
                runAsAdmin();
                break;
            default:
                System.err.println("please enter a correct answer");
                type();
        }
    }

    // check if you an admin
    public static void runAsAdmin() {
        System.out.println("please Enter your name");
        String name = Getters.getName();

        // check name in amins.txt
        if (!Checkers.checkNameInAdmins(name.trim())) {
            System.out.println("sorry. you do not hava an access to this system");
            return;
        }
        System.out.println(
                "welcome Mr\\s. " + name + ", I hope that you have a great day, may you please Enter your password");

        // check password in admins.txt
        if (!Checkers.passwordCheck(name.trim())) {
            System.out.println("sorry. you do not hava an access to this system");
            return;
        }
        System.out.println("welcome to the system");
        Menus.adminMenu();
    }

    // check if you a user
    public static void runAsUser() {
        System.out.println("1: Sign up");
        System.out.println("2: Log in");
        String type = in.next();
        try {
            switch (Integer.parseInt(type.trim())) {
                case 1:
                    System.out.println("sing up");
                    AdminMethods.addUser();
                    System.out.println("please log in");
                    runAsUser();
                    break;
                case 2:
                    // name
                    System.out.println("enter your name");
                    String name = Getters.getName();

                    // email
                    System.out.println("enter your email");
                    String email = Getters.getEmail();

                    // check if user is in users.txt
                    if (!Checkers.checkUserIsExist(name, email)) {
                        System.out.println("your information is not exist, please try again");
                        runAsUser();
                    }
                    // run the user menu
                    Menus.userMenu(name, email);
                    break;
                default:
                    System.out.println("please enter a valid value: 1 or 2");
                    runAsUser();
            }
        } catch (Exception e) {
            System.out.println("please enter a valid value: 1 or 2");
            runAsUser();
        }
    }
}