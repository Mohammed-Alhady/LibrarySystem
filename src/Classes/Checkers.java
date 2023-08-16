package src.Classes;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Checkers {

    static Scanner in = new Scanner(System.in);

    // related to admin class
    // chech if a name in data file called admins.txt in folder data
    public static boolean checkNameInAdmins(String name) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\admins.txt"));) {
            String line = br.readLine();
            while (line != null) {
                String fullData[] = line.split(",");
                for (String data : fullData) {
                    String info[] = data.split(":");
                    if (info[0].trim().equals("adminName")) {
                        if (info[1].trim().toLowerCase().equals(name.toLowerCase())) {
                            return true;
                        }
                        return false;
                    }
                }
                line = br.readLine();
            }
            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong please try again\n");
            return false;
        }
    } // end of the method

    // check if a password is correct
    public static boolean checkAdminPassword(String password) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\admins.txt"));) {
            String line = br.readLine();
            while (line != null) {
                String fullData[] = line.split(",");
                for (String data : fullData) {
                    String info[] = data.split(":");
                    if (info[0].trim().equals("password")) {
                        if (info[1].trim().toLowerCase().equals(password.toLowerCase())) {
                            return true;
                        }
                        return false;
                    }
                }
                line = br.readLine();
            }
            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong please try again\n");
            return false;
        }
    } // end of the method

    // password checker
    // you have 3 chances berfore the system out
    static int count = 4;

    public static boolean passwordCheck() {
        while (count > 1) {
            count--;
            String password = Getters.getName();
            if (!Checkers.checkAdminPassword(password.trim())) {
                System.out.println("Uncorrect password, you have " + (count - 1) + " chance\\s");
                passwordCheck();
            }
            if (count == 1) {
                return false;
            }
            return true;
        }
        return false;
    } // end of the method

    // emial validition checher
    public static boolean checkValidEmail(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern).matcher(emailAddress).matches();
    } // end of the method

    // check if admin is exist
    public static boolean checkAdminIsValid(Admin admin) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\Admins.txt"))) {
            String line = br.readLine();
            while (line != null) {
                boolean email = true, phoneNumber = true, id = true;
                String fullData[] = line.split(",");
                for (String data : fullData) {
                    String info[] = data.split(":");
                    switch (info[0].trim()) {
                        case "id":
                            if (Integer.parseInt(info[1].trim()) == admin.getAdminId()) {
                                id = false;
                            }
                            break;
                        case "email":
                            if (info[1].trim().toLowerCase().equals(admin.getEmail().toLowerCase())) {
                                System.out
                                        .println("the email is already exist in the system, please try another emial");
                                email = false;
                            }
                            break;
                        case "phoneNumber":
                            if (admin.getphoneNumber().toString() == info[1].trim()) {
                                System.out
                                        .println(
                                                "the phone number is already exist in the system, please try another emial");
                                phoneNumber = false;
                            }
                            break;
                    }
                }
                if (!(email || phoneNumber || id)) {
                    return false;
                }
                line = br.readLine();
            }
            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong please try again\n");
            return false;
        }
    }

    // check if id is exist in the memory
    public static boolean checkIdInAdminData(int id) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\admins.txt"));) {
            String line = br.readLine();
            while (line != null) {
                String fullData[] = line.split(",");
                for (String data : fullData) {
                    String info[] = data.split(":");
                    switch (info[0].trim()) {
                        case "id":
                            if (Integer.parseInt(info[1].trim()) == id) {
                                return false;
                            }
                            break;
                    }
                }
                line = br.readLine();
            }
            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong please try again\n");
            return false;
        }
    }

    // check admin is exist in the memory
    public static boolean checkAdminIsExist(String adminName, String Adminemail) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\admins.txt"));) {
            String line = br.readLine();
            while (line != null) {
                boolean name = false, email = false;
                String fullData[] = line.split(",");
                for (String data : fullData) {
                    String info[] = data.split(":");
                    switch (info[0].trim()) {
                        case "adminName":
                            if (info[1].trim().toLowerCase().equals(adminName.toLowerCase()))
                                name = true;
                            break;
                        case "email":
                            if (info[1].trim().toLowerCase().equals(Adminemail.toLowerCase()))
                                email = true;
                            break;
                    }
                }
                if (name && email) {
                    return true;
                }
                line = br.readLine();
            }
            return false;
        } catch (Exception e) {
            System.out.println("Something went wrong please try again\n");
            return false;
        }
    }

    // related to tanate class
    // check if a tenate is exist in the memory
    public static boolean checkTenateIsValid(Tenate tenate) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\users.txt"))) {
            String line = br.readLine();
            while (line != null) {
                boolean email = true, id = true, phoneNumber = true;
                String fullData[] = line.split(",");
                for (String data : fullData) {
                    String info[] = data.split(":");
                    switch (info[0].trim()) {
                        case "name":
                            break;
                        case "id":
                            if (Integer.parseInt(info[1].trim()) == tenate.getUserId()) {
                                id = false;
                            }
                            break;
                        case "email":
                            if (info[1].trim().toLowerCase().equals(tenate.getEmail().toLowerCase())) {
                                System.out
                                        .println("the email is already exist in the system, please try another emial");
                                email = false;
                            }
                            break;
                        case "phoneNumber":
                            if (tenate.getphoneNumber().toString() == info[1].trim()) {
                                System.out
                                        .println(
                                                "the phone number is already exist in the system, please try another emial");
                                phoneNumber = false;
                            }
                            break;
                        default:
                            System.out.println("something went wrong");
                    }
                }
                if (!id || !email || !phoneNumber) {
                    return false;
                }
                line = br.readLine();
            }
            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong please try again\n");
            return false;
        }
    } // end of the method

    // check if tenate is exist in the memory
    public static boolean checkTenateIsExist(Tenate tenate) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\users.txt"));) {
            String line = br.readLine();
            while (line != null) {
                boolean name = false, email = false, id = false, phoneNumber = false;
                String fullData[] = line.split(",");
                for (String data : fullData) {
                    String info[] = data.split(":");
                    switch (info[0].trim()) {
                        case "name":
                            if (info[1].trim().toLowerCase().equals(tenate.getName().toLowerCase()))
                                ;
                            name = true;
                            break;
                        case "id":
                            if (Integer.parseInt(info[1].trim()) == tenate.getUserId())
                                ;
                            id = true;
                            break;
                        case "email":
                            if (info[1].trim().toLowerCase().equals(tenate.getEmail().toLowerCase()))
                                ;
                            email = true;
                            break;
                        case "phoneNumber":
                            if (info[1].trim().toLowerCase().equals(tenate.getphoneNumber().toLowerCase()))
                                ;
                            phoneNumber = true;
                            break;
                        default:
                            System.out.println("something went wrong");
                    }
                }
                if (name && email && id && phoneNumber) {
                    return true;
                }
                line = br.readLine();
            }
            return false;
        } catch (Exception e) {
            System.out.println("Something went wrong please try again\n");
            return false;
        }
    } // end of the function

    // check if id is exist in the memory
    public static boolean checkIdInData(int id) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\users.txt"));) {
            String line = br.readLine();
            while (line != null) {
                String fullData[] = line.split(",");
                for (String data : fullData) {
                    String info[] = data.split(":");
                    switch (info[0].trim()) {
                        case "id":
                            if (Integer.parseInt(info[1].trim()) == id) {
                                return false;
                            }
                            break;
                    }
                }
                line = br.readLine();
            }
            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong please try again\n");
            return false;
        }
    }

    // check user is exist in the memory
    public static boolean checkUserIsExist(String userName, String userEmail) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\users.txt"));) {
            String line = br.readLine();
            while (line != null) {
                boolean name = false, email = false;
                String fullData[] = line.split(",");
                for (String data : fullData) {
                    String info[] = data.split(":");
                    switch (info[0].trim()) {
                        case "name":
                            if (info[1].trim().toLowerCase().equals(userName.toLowerCase()))
                                name = true;
                            break;
                        case "email":
                            if (info[1].trim().toLowerCase().equals(userEmail.toLowerCase()))
                                email = true;
                            break;
                    }
                }
                if (name && email) {
                    return true;
                }
                line = br.readLine();
            }
            return false;
        } catch (Exception e) {
            System.out.println("Something went wrong please try again\n");
            return false;
        }
    }

    // related to book class
    // check if book is not exist in the memory
    public static boolean checKBookIsValid(Book book) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\books.txt"));) {
            String line = br.readLine();
            while (line != null) {
                boolean name = false, author = false;
                String fullData[] = line.split(",");
                for (String data : fullData) {
                    String info[] = data.split(":");
                    switch (info[0].trim()) {
                        case "bookName":
                            if (info[1].trim().toLowerCase().equals(book.getBookName().toLowerCase()))
                                ;
                            name = true;
                            break;
                        case "author":
                            if (info[1].trim().toLowerCase().equals(book.getAuthor().toLowerCase()))
                                ;
                            author = true;
                            break;
                    }
                }
                if (name && author) {
                    return true;
                }
                line = br.readLine();
            }
            return false;
        } catch (Exception e) {
            System.out.println("Something went wrong please try again\n");
            return false;
        }
    }

    // check if id of the book is exist in the memory
    public static boolean checkCodeINBooksData(String id) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\books.txt"));) {
            String line = br.readLine();
            while (line != null) {
                String fullData[] = line.split(",");
                for (String data : fullData) {
                    String info[] = data.split(":");
                    switch (info[0].trim()) {
                        case "code":
                            if (info[1].trim().toLowerCase().equals(id)) {
                                return false;
                            }
                            break;
                    }
                }
                line = br.readLine();
            }
            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong please try again\n");
            return false;
        }
    }

    // check if book is exist
    public static boolean checkBookIsExist(String book, String AuthonName) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\books.txt"));) {
            String line = br.readLine();
            while (line != null) {
                boolean bookName = false, author = false, quantity = false;
                String fullData[] = line.split(",");
                for (String data : fullData) {
                    String info[] = data.split(":");
                    switch (info[0].trim()) {
                        case "bookName":
                            if (info[1].trim().toLowerCase().equals(book.toLowerCase()))
                                bookName = true;
                            break;
                        case "author":
                            if (info[1].trim().toLowerCase().equals(AuthonName.toLowerCase()))
                                author = true;
                            break;
                        case "quantity":
                            if (Integer.parseInt(info[1].trim()) > 0)
                                quantity = true;
                            break;
                    }
                }
                if (bookName && author && quantity) {
                    return true;
                }
                line = br.readLine();
            }
            return false;
        } catch (Exception e) {
            System.out.println("Something went wrong please try again\n");
            return false;
        }
    }

    // check if user in borrowed data
    public static boolean checkIfUserInBorrowedData(String userName, String userEmail, String bookName, String author) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\booksBorrowed.txt"));) {
            String line = br.readLine();
            while (line != null) {
                boolean name = false, email = false, book = false, authorName = false;
                String fullData[] = line.split(",");
                for (String data : fullData) {
                    String info[] = data.split(":");
                    switch (info[0].trim()) {
                        case "username":
                            if (info[1].trim().toLowerCase().equals(userName.toLowerCase()))
                                name = true;
                            break;
                        case "email":
                            if (info[1].trim().toLowerCase().equals(userEmail.toLowerCase()))
                                email = true;
                            break;
                        case "book":
                            if (info[1].trim().toLowerCase().equals(bookName.toLowerCase()))
                                book = true;
                            break;
                        case "author":
                            if (info[1].trim().toLowerCase().equals(author.toLowerCase()))
                                authorName = true;
                            break;
                    }
                }
                if (name && email && book && authorName) {
                    return true;
                }
                line = br.readLine();
            }
            return false;
        } catch (Exception e) {
            System.out.println("Something went wrong please try again\n");
            return false;
        }
    }

    // overload for the same method
    public static boolean checkIfUserInBorrowedData(String userName, String userEmail) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\booksBorrowed.txt"));) {
            String line = br.readLine();
            while (line != null) {
                boolean name = false, email = false;
                String fullData[] = line.split(",");
                for (String data : fullData) {
                    String info[] = data.split(":");
                    switch (info[0].trim()) {
                        case "username":
                            if (info[1].trim().toLowerCase().equals(userName.toLowerCase()))
                                name = true;
                            break;
                        case "email":
                            if (info[1].trim().toLowerCase().equals(userEmail.toLowerCase()))
                                email = true;
                            break;
                    }
                }
                if (name && email) {
                    return true;
                }
                line = br.readLine();
            }
            return false;
        } catch (Exception e) {
            System.out.println("Something went wrong please try again\n");
            return false;
        }
    }
}