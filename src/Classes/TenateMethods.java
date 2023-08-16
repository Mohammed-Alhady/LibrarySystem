package src.Classes;

import java.io.*;

// usersmethods
public class TenateMethods {
    // borrow a book
    public static void borrowABook(String name, String email) {
        // name
        System.out.println("enter the book name");
        String bookName = Getters.getName();
        // author name
        System.out.println("enter the book author");
        String author = Getters.getName();
        // check if book is exist
        if (!Checkers.checkBookIsExist(bookName, author)) {
            System.out.println("this book is not exist, please try anther book");
            borrowABook(name, email);
        }
        // borrow the book
        borrow(name, email, bookName, author);
    }

    // return a book
    public static void returnABook(String name, String email) {
        // name
        System.out.println("enter the book name");
        String bookName = Getters.getName();
        // author name
        System.out.println("enter the book author");
        String author = Getters.getName();
        // check if user has this book
        if (Checkers.checkIfUserInBorrowedData(name, email, bookName, author)) {
            System.out.println("you dont have this book, please try again");
            returnABook(name, email);
        }
        // return the book
        retrunBook(name, email, bookName, author);
    }

    // buy a book
    public static void buyABook(String name, String email) {
        // name
        System.out.println("enter the book name");
        String bookName = Getters.getName();
        // author
        System.out.println("enter the book author");
        String author = Getters.getName();
        // check if book is exist
        if (!Checkers.checkBookIsExist(bookName, author)) {
            System.out.println("this book is not exist, please try anther book");
            buyABook(name, email);
        }
        // buy the book
        buy(name, email, bookName, author);
    }

    // show the user book
    public static void showMyBooks(String name, String email) {
        // if user hasnt the book stop
        if (!Checkers.checkIfUserInBorrowedData(name, email)) {
            System.out.println("you didnt borrow any book");
            return;
        }
        // show the book
        show(name, email);
    }

    // find a book
    public static void findABook(String name, String email) {
        // name
        System.out.println("enter the book name");
        String bookName = Getters.getName();
        // author name
        System.out.println("enter the book author");
        String author = Getters.getName();
        // check if this book is exist
        if (!Checkers.checkBookIsExist(bookName, author)) {
            System.out.println("this book is not exist, please try anther book");
            findABook(bookName, email);
        }
        // find it
        find(bookName, author);
    }

    // private methods help to do some word

    // borrow
    private static void borrow(String name, String email, String bookName, String author) {
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
                boolean isBook = false, isAuthor = false;
                int quantity = 0;
                String data[] = line.split(",");
                for (String info : data) {
                    String type[] = info.split(":");
                    switch (type[0].trim()) {
                        case "bookName":
                            if (type[1].trim().toLowerCase().equals(bookName))
                                isBook = true;
                            break;
                        case "author":
                            if (type[1].trim().toLowerCase().equals(author))
                                isAuthor = true;
                            break;
                        case "quantity":
                            quantity = Integer.parseInt(type[1].trim());
                            break;
                    }
                }
                if (isBook && isAuthor) {
                    if (addToBooksBorrowed(name, email, bookName, author)) {
                        String newLine = line.replaceAll("quantity : " + quantity, "quantity : " + (quantity - 1));
                        pw.println(newLine);
                        pw.flush();
                    } else {
                        System.out.println("you already has this book");
                    }

                } else {
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

    // add to booksBorrowed.txt
    private static boolean addToBooksBorrowed(String name, String email, String bookName, String author) {
        try {
            // check if user exist
            if (Checkers.checkIfUserInBorrowedData(name, email, bookName, author)) {
                System.out.println("you already has this book");
                return false;
            }

            BufferedWriter br = new BufferedWriter(
                    new FileWriter("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\booksBorrowed.txt", true));

            br.write("\nusername : " + name + " , email : " + email + " , bookname : " + bookName + ", author : "
                    + author);
            br.close();
            // unless content matches data to be removed.
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // return a book
    private static void retrunBook(String name, String email, String bookName, String author) {
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
                boolean isBook = false, isAuthor = false;
                int quantity = 0;
                String data[] = line.split(",");
                for (String info : data) {
                    String type[] = info.split(":");
                    switch (type[0].trim()) {
                        case "bookName":
                            if (type[1].trim().toLowerCase().equals(bookName))
                                isBook = true;
                            break;
                        case "author":
                            if (type[1].trim().toLowerCase().equals(author))
                                isAuthor = true;
                            break;
                        case "quantity":
                            quantity = Integer.parseInt(type[1].trim());
                            break;
                    }
                }
                if (isBook && isAuthor) {
                    removeBooksBorrowed(name, email, bookName, author);
                    String newLine = line.replaceAll("quantity : " + quantity, "quantity : " + (quantity + 1));
                    pw.println(newLine);
                    pw.flush();
                } else {
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

    // remove borrowed book
    private static void removeBooksBorrowed(String name, String email, String bookName, String author) {
        try {
            File inFile = new File("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\booksBorrowed.txt");

            // Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".txt");

            BufferedReader br = new BufferedReader(
                    new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\booksBorrowed.txt"));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            // unless content matches data to be removed.
            while ((line = br.readLine()) != null) {
                String data[] = line.split(",");
                String username[] = data[0].split(":");
                String userEmail[] = data[1].split(":");
                String userBook[] = data[2].split(":");
                String userAuthor[] = data[3].split(":");
                boolean deleate = (username[1].trim().toLowerCase().equals(name.toLowerCase()))
                        && (userEmail[1].trim().toLowerCase().equals(email.toLowerCase()))
                        && (userBook[1].trim().toLowerCase().equals(bookName.toLowerCase()))
                        && (userAuthor[1].trim().toLowerCase().equals(author.toLowerCase()));
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

    // buy a book
    private static void buy(String name, String email, String bookName, String author) {
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
                boolean isBook = false, isAuthor = false;
                int quantity = 0;
                String data[] = line.split(",");
                for (String info : data) {
                    String type[] = info.split(":");
                    switch (type[0].trim()) {
                        case "bookName":
                            if (type[1].trim().toLowerCase().equals(bookName))
                                isBook = true;
                            break;
                        case "author":
                            if (type[1].trim().toLowerCase().equals(author))
                                isAuthor = true;
                            break;
                        case "quantity":
                            quantity = Integer.parseInt(type[1].trim());
                            break;
                    }
                }
                if (isBook && isAuthor && quantity > 0) {
                    String newLine = line.replaceAll("quantity : " + quantity, "quantity : " + (quantity - 1));
                    pw.println(newLine);
                    pw.flush();
                } else {
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

    // show my books
    private static void show(String name, String email) {
        int count = 1;
        try (BufferedReader br = new BufferedReader(
                new FileReader(
                        new File("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\booksBorrowed.txt")))) {
            String line = br.readLine();
            while (line != null) {
                String bookName = "null", author = "null";
                boolean isName = false, isEmail = false;
                String types[] = line.split(",");
                for (String type : types) {
                    String data[] = type.split(":");
                    switch (data[0].trim()) {
                        case "bookname":
                            bookName = data[1];
                            break;
                        case "author":
                            author = data[1];
                            break;
                        case "username":
                            if (name.equals(data[1].trim())) {
                                isName = true;
                            }
                            break;
                        case "email":
                            if (email.equals(data[1].trim())) {
                                isEmail = true;
                            }
                    }
                }
                if (isEmail && isName) {
                    System.out.println(
                            count++ + ": book name is \"" + bookName.trim() + "\" author is \"" + author + "\"");
                }
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // find a book
    private static void find(String bookName, String bookAuthor) {
        try {
            File inFile = new File("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\books.txt");

            // Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".txt");

            BufferedReader br = new BufferedReader(
                    new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\books.txt"));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;
            boolean exist = false;
            // unless content matches data to be removed.
            while ((line = br.readLine()) != null) {
                boolean isBook = false, isAuthor = false;
                String code = "";
                int quantity = 0;
                String data[] = line.split(",");
                for (String info : data) {
                    String type[] = info.split(":");
                    switch (type[0].trim()) {
                        case "bookName":
                            if (type[1].trim().toLowerCase().equals(bookName))
                                isBook = true;
                            break;
                        case "author":
                            if (type[1].trim().toLowerCase().equals(bookAuthor))
                                isAuthor = true;
                            break;
                        case "quantity":
                            quantity = Integer.parseInt(type[1].trim());
                            break;
                        case "code":
                            code = type[1].trim();
                    }
                }
                if (isBook && isAuthor && quantity > 0) {
                    System.out.println("book : " + bookName + " author : " + bookAuthor + " code : " + code);
                    exist = true;
                }
                pw.println(line);
                pw.flush();
            }

            if (!exist) {
                System.out.println("we cant find this book");
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
        } catch (

        FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
