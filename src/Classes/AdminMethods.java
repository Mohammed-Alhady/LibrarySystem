package src.Classes;

import java.io.*;
import java.util.Scanner;

public class AdminMethods {

    static Scanner in = new Scanner(System.in);

    // add a new user in users.txt file
    public static void addUser() {
        // name
        System.out.println("enter a user name");
        User tenate = new User();
        String name = Getters.getName();
        tenate.setName(name);

        // email
        System.out.println("enter a user email");
        String email = Getters.getEmail();
        tenate.setEmail(email);

        // phone number
        System.out.println("enter a phonenumber");
        String phoneNumber = Getters.getPhoneNumber();
        tenate.setphoneNumber(phoneNumber);

        // check if user is exist
        if (!Checkers.checkTenateIsValid(tenate)) {
            System.out.println("this tanate info are already exist in the memory");
            addUser();
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
            System.out.println("something went wrong please try again");
            addUser();
        }
    }

    // add a new book in books.txt file
    public static void addBook() {
        try {
            // book name
            System.out.println("enter the book name");
            Book book = new Book();
            String bookName = Getters.getName();
            book.setBookName(bookName);

            // book Quantity
            System.out.println("enter the book Quantity");
            int quantity = Getters.getNumber();
            book.setQuantity(quantity);

            // author name
            System.out.println("enter a name for " + bookName + "`s author");
            String AuthonName = Getters.getName();
            book.setAuthor(AuthonName);

            // description
            System.out.println("enter the " + bookName + "`s description");
            String description = Getters.getName();
            book.setDescription(description);

            // price
            System.out.println("enter the " + bookName + "`s price");
            float price = Getters.getFloat();
            book.setPrice(price);

            // check if book is exist and then write the info
            if (!Checkers.checKBookIsValid(book)) {
                System.out.println("this book info is already exist in the memory");
                addBook();
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
            System.out.println("Something went wrong, please try again");
            addBook();
        }
    }

    // add a new admin in admins.txt file
    public static void addANewAdmin() {
        Admin admin = new Admin();
        // name
        System.out.println("enter a name for the new admin");
        String name = Getters.getName();
        admin.setName(name);

        // password
        System.out.println("enter a password for " + name);
        String password = Getters.getName();
        admin.setPassword(password);

        // email
        System.out.println("enter a valid email for " + name);
        String email = Getters.getEmail();
        admin.setEmail(email);

        // phone number
        System.out.println("enter a phonenumber");
        String phoneNumber = Getters.getPhoneNumber();
        admin.setphoneNumber(phoneNumber);

        // check if exist in the memory
        if (!Checkers.checkAdminIsValid(admin)) {
            System.out.println("this admin is already exist, please try again");
            addANewAdmin();
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
            System.out.println("something went wrong please try again");
            addANewAdmin();
        }
    }

    // remove an old user from users.txt
    public static void removerUser() {
        // name
        System.out.println("enter the user name");
        String userNmae = Getters.getName();

        // email
        System.out.println("enter the emial for " + userNmae);
        String email = Getters.getEmail();

        // check if exist
        if (!Checkers.checkUserIsExist(userNmae, email)) {
            System.out.println("this admin is not found, please try again");
            removerUser();
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
                boolean deleate = (dataAdminName[1].trim().toLowerCase().equals(userNmae.toLowerCase()))
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
                System.out.println("Could not delete file");
                return;
            }

            // Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile))
                System.out.println("Could not rename file");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // remove an old book from books.txt
    public static void removerBook() {

        // book name
        System.out.println("enter the book name");
        String bookName = Getters.getName();

        // author name
        System.out.println("enter the author for " + bookName);
        String AuthonName = Getters.getName();

        // check if book is exist
        // if the book is not exist try again
        if (!Checkers.checkBookIsExistToDelete(bookName, AuthonName)) {
            System.out.println("this book is not found, please try again");
            removerBook();
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
                System.out.println("Could not delete file");
                return;
            }

            // Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile))
                System.out.println("Could not rename file");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // remove an old admin
    public static void removeAdmin() {
        // name
        System.out.println("enter the admin name");
        String adminName = Getters.getName();

        // email
        System.out.println("enter the emial for " + adminName);
        String email = Getters.getEmail();

        // check if admin is exist to remove him
        if (!Checkers.checkAdminIsExist(adminName, email)) {
            System.out.println("this admin is not found, please try again");
            removeAdmin();
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
                System.out.println("Could not delete file");
                return;
            }

            // Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile))
                System.out.println("Could not rename file");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
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
            System.out.println(e);
        }
    }

}