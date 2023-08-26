package src.Classes;

import java.io.*;
import java.util.Scanner;

public class AdminMethods {

    static Scanner in = new Scanner(System.in);

    // add a new user in users.txt file
    public static void addUser() {
        // name
        System.out.println("#Enter a user name#");
        User tenate = new User();
        String name = Getters.getName();
        tenate.setName(name);

        // email
        System.out.println("#Enter a user email#");
        String email = Getters.getEmail();
        tenate.setEmail(email);

        // phone number
        System.out.println("#Enter a phonenumber#");
        String phoneNumber = Getters.getPhoneNumber();
        tenate.setphoneNumber(phoneNumber);

        // check if user is exist
        if (!Checkers.checkTenateIsValid(tenate)) {
            System.out.println("#Error: This user info are already exist in the memory#");
            Menus.adminMenu();
        }

        // write the new user
        try {
            BufferedWriter br = new BufferedWriter(
                    new FileWriter("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\users.txt", true));
            br.write("\nname : " + tenate.getName() + ", id : " + tenate.getUserId() + ", email : " + tenate.getEmail()
                    + ", phoneNumber : " + tenate.getphoneNumber());
            br.flush();
            br.close();
        } catch (Exception e) {
            System.out.println("#Error: Something went wrong please try again#");
            Menus.adminMenu();
        }
    }

    // add a new book in books.txt file
    public static void addBook() {
        try {
            // book name
            System.out.println("#Enter the book name#");
            Book book = new Book();
            String bookName = Getters.getName();
            book.setBookName(bookName);

            // book Quantity
            System.out.println("#Enter the book Quantity#");
            int quantity = Getters.getNumber();
            book.setQuantity(quantity);

            // author name
            System.out.println("#Enter a name for " + bookName + "`s author#");
            String AuthonName = Getters.getName();
            book.setAuthor(AuthonName);

            // description
            System.out.println("#Enter the " + bookName + "`s description#");
            String description = Getters.getName();
            book.setDescription(description);

            // price
            System.out.println("#Enter the " + bookName + "`s price#");
            float price = Getters.getFloat();
            book.setPrice(price);

            // check if book is exist and then write the info
            if (!Checkers.checKBookIsValid(book)) {
                System.out.println("#Error: This book info is already exist in the memory#");
                Menus.adminMenu();
            }

            // write the new book in books.txt file
            BufferedWriter br = new BufferedWriter(
                    new FileWriter("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\books.txt", true));
            br.write("\nbookName : " + book.getBookName() + ", quantity : " + book.getQuantity() + ", author : "
                    + book.getAuthor()
                    + ", description : " + book.getDescription() + ", code : " + book.getCode() + ", price : "
                    + book.getPrice());
            br.flush();
            br.close();

        } catch (Exception e) {
            System.out.println("#Error: Something went wrong, please try again#");
            Menus.adminMenu();
        }
    }

    // add a new admin in admins.txt file
    public static void addANewAdmin() {
        Admin admin = new Admin();
        // name
        System.out.println("#Enter a name for the new admin#");
        String name = Getters.getName();
        admin.setName(name);

        // password
        System.out.println("#Enter a password for " + name + "#");
        String password = Getters.getName();
        admin.setPassword(password);

        // email
        System.out.println("#Enter a valid email for " + name + "#");
        String email = Getters.getEmail();
        admin.setEmail(email);

        // phone number
        System.out.println("#Enter a phonenumber#");
        String phoneNumber = Getters.getPhoneNumber();
        admin.setphoneNumber(phoneNumber);

        // check if exist in the memory
        if (!Checkers.checkAdminIsValid(admin)) {
            System.out.println("#Enter: This admin is already exist, please try again#");
            Menus.adminMenu();
        }

        // add the admin in admins.txt
        try {
            BufferedWriter br = new BufferedWriter(
                    new FileWriter("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\admins.txt", true));
            br.write("\nname: " + admin.getName() + ", password : " + admin.getPassword() + ", id = "
                    + admin.getAdminId() + ", email : " + admin.getEmail() + ", phoneNumber : "
                    + admin.getphoneNumber());
            br.flush();
            br.close();
        } catch (Exception e) {
            System.out.println("#Error: Something went wrong, please try again#");
            Menus.adminMenu();
        }
    }

    // remove an old user from users.txt
    public static void removerUser() {
        // name
        System.out.println("#Enter the user name#");
        String userName = Getters.getName();

        // email
        System.out.println("#Enter the emial for " + userName + "#");
        String email = Getters.getEmail();

        // check if exist
        if (!Checkers.checkUserIsExist(userName, email)) {
            System.out.println("#Error: This user is not found, please try again#");
            Menus.adminMenu();
        }

        // write the new user in users.txt file
        try {
            File inFile = new File("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\users.txt");

            // Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".txt");

            BufferedReader br = new BufferedReader(
                    new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\users.txt"));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            // unless content matches data to be removed.
            while ((line = br.readLine()) != null) {
                String data[] = line.split(",");
                String dataAdminName[] = data[0].split(":");
                String dataAdminEmail[] = data[2].split(":");
                boolean deleate = (dataAdminName[1].trim().toLowerCase().equals(userName.toLowerCase()))
                        && (dataAdminEmail[1].trim().toLowerCase().equals(email.toLowerCase()));
                if (!deleate) {
                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            // Delete the original file
            if (!inFile.delete()) {
                System.out.println("#Could not delete file#");
                Menus.stop();
            }

            // Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile))
                System.out.println("#Could not rename file#");
        } catch (Exception e) {
            System.out.println("#Error: Something went wrong, please try again#");
        }
    }

    // remove an old book from books.txt
    public static void removerBook() {

        // book name
        System.out.println("#Enter the book name#");
        String bookName = Getters.getName();

        // author name
        System.out.println("#Enter the author for " + bookName + "#");
        String AuthonName = Getters.getName();

        // check if book is exist
        // if the book is not exist try again
        if (!Checkers.checkBookIsExistToDelete(bookName, AuthonName)) {
            System.out.println("#Error: This book is not found, please try again#");
            Menus.adminMenu();
        }

        // remove the book if is exist
        try {
            File inFile = new File("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\books.txt");

            // Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".txt");

            BufferedReader br = new BufferedReader(
                    new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\books.txt"));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            // unless content matches data to be removed.
            while ((line = br.readLine()) != null) {
                String data[] = line.split(",");
                String dataBookName[] = data[0].split(":");
                String dataAuthor[] = data[2].split(":");
                boolean deleate = (dataBookName[1].trim().toLowerCase().equals(bookName.toLowerCase()))
                        && (dataAuthor[1].trim().toLowerCase().equals(AuthonName.toLowerCase()));
                if (!deleate) {
                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            // Delete the original file
            if (!inFile.delete()) {
                System.out.println("#Could not delete file#");
                Menus.stop();
            }

            // Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile))
                System.out.println("#Could not rename file#");
        } catch (Exception e) {
            System.out.println("#Error: Something went wrong, please try again#");
            Menus.adminMenu();
        }
    }

    // remove an old admin
    public static void removeAdmin() {
        // name
        System.out.println("#Enter the admin name#");
        String adminName = Getters.getName();

        // email
        System.out.println("#Enter the emial for " + adminName + "#");
        String email = Getters.getEmail();

        // check if admin is exist to remove him
        if (!Checkers.checkAdminIsExist(adminName, email)) {
            System.out.println("#Error: This admin is not found, please try again#");
            Menus.adminMenu();
        }

        if (adminName.equalsIgnoreCase("mohammed ali") && email.equalsIgnoreCase("mohammed@example.com")) {
            System.out.println("#Error: You can not remove this admin#");
            Menus.adminMenu();
        }

        // remove the admin from admins.txt
        try {
            File inFile = new File("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\admins.txt");

            // Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".txt");

            BufferedReader br = new BufferedReader(
                    new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\admins.txt"));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            // unless content matches data to be removed.
            while ((line = br.readLine()) != null) {
                String data[] = line.split(",");
                String dataAdminName[] = data[0].split(":");
                String dataAdminEmail[] = data[3].split(":");
                boolean deleate = (dataAdminName[1].trim().toLowerCase().equals(adminName.toLowerCase()))
                        && (dataAdminEmail[1].trim().toLowerCase().equals(email.toLowerCase()));
                if (!deleate) {
                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            // Delete the original file
            if (!inFile.delete()) {
                System.out.println("#Could not delete file#");
                Menus.stop();
            }

            // Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile))
                System.out.println("#Could not rename file#");
        } catch (Exception e) {
            System.out.println("#Error: Something went wrong, please try again#");
            Menus.adminMenu();
        }
    }

    // show all books in books.txt
    public static void showAllBooks() {
        int count = 1;
        try (BufferedReader br = new BufferedReader(
                new FileReader(new File("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\books.txt")))) {
            String line = br.readLine();
            while (line != null) {
                String bookName = "null", author = "null", description = "null", code = "null", price = "null";
                boolean valid = true;
                String data[] = line.split(",");
                for (String subData : data) {
                    String info[] = subData.split(":");
                    switch (info[0].trim()) {
                        case "book-name":
                            bookName = info[1];
                            break;
                        case "author":
                            author = info[1];
                            break;
                        case "description":
                            description = info[1];
                            break;
                        case "code":
                            code = info[1];
                            break;
                        case "price":
                            price = info[1];
                            break;
                        case "quantity":
                            if (Integer.parseInt(info[1].trim()) <= 0) {
                                valid = false;
                            }
                            break;
                    }
                }
                if (valid) {
                    System.out.println(count++ + ": book name : " + bookName + "\nauthor : " + author
                            + " \ndescription : " + description + " \ncode : " + code + "\nprice : " + price + "\n");
                }
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            System.out.println("#Error: Something went wrong, please try again#");
            Menus.adminMenu();
        }
    }

}