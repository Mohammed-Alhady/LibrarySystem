package src;

import java.util.Scanner;

import src.Classes.*;

public class Main {

    static Scanner in = new Scanner(System.in);

    // main method
    public static void main(String[] args) {
        System.out.println("#Welcome to the system :)#");
        type();
    }

    // chose a type
    public static void type() {
        System.out.println("#Are you a User or an Admin#");
        String type = in.nextLine().trim().toLowerCase();
        switch (type) {
            case "user":
                runAsUser();
                break;
            case "admin":
                runAsAdmin();
                break;
            default:
                System.err.println("Error: #Please enter a correct value#");
                type();
        }
    }

    // check if you an admin
    public static void runAsAdmin() {
        System.out.println("#Please Enter your name#");
        String name = Getters.getName();

        // check name in amins.txt
        if (!Checkers.checkNameInAdmins(name.trim())) {
            System.out.println("#Error: Sorry. you do not hava an access to this system#");
            Menus.stop();
            ;
        }
        System.out.println(
                "#Welcome Mr\\s. " + name + ", I hope that you have a great day, may you please Enter your password#");

        // check password in admins.txt
        if (!Checkers.passwordCheck(name.trim())) {
            System.out.println("#Error: Sorry. you do not hava an access to this system#");
            Menus.stop();
        }
        System.out.println("#Welcome to the system#");
        Menus.adminMenu();
    }

    // check if you a user
    public static void runAsUser() {
        System.out.println("#1: Sign up#");
        System.out.println("#2: Log in#");
        String type = in.next();
        try {
            switch (Integer.parseInt(type.trim())) {
                case 1:
                    AdminMethods.addUser();
                    System.out.println("#Please log in#");
                case 2:
                    // name
                    System.out.println("#Enter your name#");
                    String name = Getters.getName();

                    // email
                    System.out.println("#Enter your email#");
                    String email = Getters.getEmail();

                    // check if user is in users.txt
                    if (!Checkers.checkUserIsExist(name, email)) {
                        System.out.println("#Your information is not exist, please try again#");
                        runAsUser();
                    }
                    // run the user menu
                    Menus.userMenu(name, email);
                    break;
                default:
                    System.out.println("#Please enter a valid value: 1 or 2#");
                    runAsUser();
            }
        } catch (Exception e) {
            System.out.println("#Please enter a valid value: 1 or 2#");
            runAsUser();
        }
    }
}