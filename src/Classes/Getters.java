package src.Classes;

import java.util.Scanner;

public class Getters {
    static Scanner in = new Scanner(System.in);

    // return a name
    public static String getName() {
        String firstName = in.next();
        String lastName = in.nextLine();
        return (firstName + lastName).trim();
    }

    // return an email
    public static String getEmail() {
        String email = in.next();
        while (!Checkers.checkValidEmail(email, "^(.+)@(\\S+)$")) {
            System.out.println("unvalid email, please try again");
            email = in.next();
        }
        return email.trim();
    }

    // return a phonenumber
    public static String getPhoneNumber() {
        String phoneNumber = in.next();
        try {
            while (phoneNumber.length() != 10) {
                System.out.println("unvalid phonenumber, it must be 10 integers long");
                phoneNumber = in.next();
            }
            Long.parseLong(phoneNumber);
        } catch (NumberFormatException e) {
            System.out.println("unvalid number it must = 10 chars");
            System.out.println("please try again and enter a valid phone nubmer 09_ _ _ _,_ _,_ _");
            getPhoneNumber();
        }

        return phoneNumber.trim();
    }

    // return a number
    public static int getNumber() {
        try {
            int quantity = in.nextInt();
            if (quantity < 1) {
                System.out.println("please enter a number greater than 0");
                getNumber();
            }
            return quantity;
        } catch (Exception e) {
            System.out.println("please enter a valid number");
            getNumber();
        }
        return 0;
    }

    // return a float
    public static float getFloat() {
        try {
            float quantity = in.nextFloat();
            if (quantity < 1) {
                System.out.println("please enter a number greater than 0");
                getFloat();
            }
            return quantity;
        } catch (Exception e) {
            System.out.println("please enter a valid number");
            getFloat();
        }
        return 0;
    }
}
