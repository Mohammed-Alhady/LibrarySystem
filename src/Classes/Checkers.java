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
                String data[] = line.split(",");
                for (String subData : data) {
                    String info[] = subData.split(":");
                    switch (info[0]) {
                        case "name":
                            if (info[1].trim().toLowerCase().equals(name.toLowerCase())) {
                                return true;
                            }
                    }
                }
                line = br.readLine();
            }
            return false;
        } catch (Exception e) {
            System.out.println("Something went wrong please try again\n");
            return false;
        }
    } // end of the method

    // check if a password is correct
    public static boolean checkAdminPassword(String password, String name) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\admins.txt"));) {
            String line = br.readLine();
            while (line != null) {
                boolean isName = false, isPassword = false;
                String data[] = line.split(",");
                for (String subData : data) {
                    String info[] = subData.split(":");
                    switch (info[0].trim()) {
                        case "password":
                            System.out.println(info[1].trim().toLowerCase().equals(password.toLowerCase()));
                            if (info[1].trim().toLowerCase().equals(password.toLowerCase())) {
                                isPassword = true;
                            }
                        case "name":
                            if (info[1].trim().toLowerCase().equals(name.toLowerCase())) {
                                isName = true;
                            }
                    }
                }
                if (isName && isPassword) {
                    return true;
                }
                line = br.readLine();
            }
            return false;
        } catch (Exception e) {
            System.out.println("Something went wrong please try again\n");
            return false;
        }
    } // end of the method

    // password checker
    // you have 3 chances berfore the system out
    static int counter = 0;

    public static boolean passwordCheck(String name) {
        while (counter < 3) {
            String password = Getters.getName();
            if (!Checkers.checkAdminPassword(password.trim(), name)) {
                System.out.println("Uncorrect password, you have " + (3 - counter++) + " chance\\s");
                passwordCheck(name);
            } else {
                return true;
            }
        }
        Menus.stop();
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
                boolean isEmail = true, isPhonenumber = true, isId = true;
                String data[] = line.split(",");
                for (String subData : data) {
                    String info[] = subData.split(":");
                    switch (info[0].trim()) {
                        case "id":
                            if (Integer.parseInt(info[1].trim()) == admin.getAdminId()) {
                                isId = false;
                            }
                            break;
                        case "email":
                            if (info[1].trim().toLowerCase().equals(admin.getEmail().toLowerCase())) {
                                System.out
                                        .println("the email is already exist in the system, please try another emial");
                                isEmail = false;
                            }
                            break;
                        case "phone-number":
                            if (admin.getphoneNumber().toString() == info[1].trim()) {
                                System.out
                                        .println(
                                                "the phone number is already exist in the system, please try another emial");
                                isPhonenumber = false;
                            }
                            break;
                    }
                }
                if (!(isEmail || isPhonenumber || isId)) {
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
                String data[] = line.split(",");
                for (String subData : data) {
                    String info[] = subData.split(":");
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
    public static boolean checkAdminIsExist(String name, String email) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\admins.txt"));) {
            String line = br.readLine();
            while (line != null) {
                boolean isName = false, isEmail = false;
                String data[] = line.split(",");
                for (String subData : data) {
                    String info[] = subData.split(":");
                    switch (info[0].trim()) {
                        case "name":
                            if (info[1].trim().toLowerCase().equals(name.toLowerCase()))
                                isName = true;
                            break;
                        case "email":
                            if (info[1].trim().toLowerCase().equals(email.toLowerCase()))
                                isEmail = true;
                            break;
                    }
                }
                if (isName && isEmail) {
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
    public static boolean checkTenateIsValid(User tenate) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\users.txt"))) {
            String line = br.readLine();
            while (line != null) {
                boolean isEmail = true, isId = true, isPhonenumber = true;
                String data[] = line.split(",");
                for (String subData : data) {
                    String info[] = subData.split(":");
                    switch (info[0].trim()) {
                        case "name":
                            break;
                        case "id":
                            if (Integer.parseInt(info[1].trim()) == tenate.getUserId()) {
                                isId = false;
                            }
                            break;
                        case "email":
                            if (info[1].trim().toLowerCase().equals(tenate.getEmail().toLowerCase())) {
                                System.out
                                        .println("the email is already exist in the system, please try another emial");
                                isEmail = false;
                            }
                            break;
                        case "phone-number":
                            if (tenate.getphoneNumber().toString() == info[1].trim()) {
                                System.out
                                        .println(
                                                "the phone number is already exist in the system, please try another emial");
                                isPhonenumber = false;
                            }
                            break;
                        default:
                            System.out.println("something went wrong");
                    }
                }
                if (!isId || !isEmail || !isPhonenumber) {
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
    public static boolean checkTenateIsExist(User tenate) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\users.txt"));) {
            String line = br.readLine();
            while (line != null) {
                boolean isName = false, isEmail = false, isId = false, isPhonenumber = false;
                String data[] = line.split(",");
                for (String subData : data) {
                    String info[] = subData.split(":");
                    switch (info[0].trim()) {
                        case "name":
                            if (info[1].trim().toLowerCase().equals(tenate.getName().toLowerCase()))
                                ;
                            isName = true;
                            break;
                        case "id":
                            if (Integer.parseInt(info[1].trim()) == tenate.getUserId())
                                ;
                            isId = true;
                            break;
                        case "email":
                            if (info[1].trim().toLowerCase().equals(tenate.getEmail().toLowerCase()))
                                ;
                            isEmail = true;
                            break;
                        case "phone-number":
                            if (info[1].trim().toLowerCase().equals(tenate.getphoneNumber().toLowerCase()))
                                ;
                            isPhonenumber = true;
                            break;
                        default:
                            System.out.println("something went wrong");
                    }
                }
                if (isName && isEmail && isId && isPhonenumber) {
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
                String data[] = line.split(",");
                for (String subData : data) {
                    String info[] = subData.split(":");
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
    public static boolean checkUserIsExist(String name, String email) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\users.txt"));) {
            String line = br.readLine();
            while (line != null) {
                boolean isName = false, isEmail = false;
                String data[] = line.split(",");
                for (String subData : data) {
                    String info[] = subData.split(":");
                    switch (info[0].trim()) {
                        case "name":
                            if (info[1].trim().toLowerCase().equals(name.toLowerCase()))
                                isName = true;
                            break;
                        case "email":
                            if (info[1].trim().toLowerCase().equals(email.toLowerCase()))
                                isEmail = true;
                            break;
                    }
                }
                if (isName && isEmail) {
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
                boolean isName = false, isAuthor = false;
                String data[] = line.split(",");
                for (String subData : data) {
                    String info[] = subData.split(":");
                    switch (info[0].trim()) {
                        case "book-name":
                            if (info[1].trim().toLowerCase().equals(book.getBookName().toLowerCase()))
                                ;
                            isName = true;
                            break;
                        case "author":
                            if (info[1].trim().toLowerCase().equals(book.getAuthor().toLowerCase()))
                                ;
                            isAuthor = true;
                            break;
                    }
                }
                if (isName && isAuthor) {
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
                String data[] = line.split(",");
                for (String subData : data) {
                    String info[] = subData.split(":");
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
    public static boolean checkBookIsExist(String name, String author) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\books.txt"));) {
            String line = br.readLine();
            while (line != null) {
                boolean isName = false, isAuthor = false, isQuantity = false;
                String data[] = line.split(",");
                for (String subData : data) {
                    String info[] = subData.split(":");
                    switch (info[0].trim()) {
                        case "book-name":
                            if (info[1].trim().toLowerCase().equals(name.toLowerCase()))
                                isName = true;
                            break;
                        case "author":
                            if (info[1].trim().toLowerCase().equals(author.toLowerCase()))
                                isAuthor = true;
                            break;
                        case "quantity":
                            if (Integer.parseInt(info[1].trim()) > 0)
                                isQuantity = true;
                            break;
                    }
                }
                if (isName && isAuthor && isQuantity) {
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

    // check if book is exist to delete it
    public static boolean checkBookIsExistToDelete(String name, String author) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\books.txt"));) {
            String line = br.readLine();
            while (line != null) {
                boolean isName = false, isAuthor = false;
                String data[] = line.split(",");
                for (String subData : data) {
                    String info[] = subData.split(":");
                    switch (info[0].trim()) {
                        case "book-name":
                            if (info[1].trim().toLowerCase().equals(name.toLowerCase()))
                                isName = true;
                            break;
                        case "author":
                            if (info[1].trim().toLowerCase().equals(author.toLowerCase()))
                                isAuthor = true;
                            break;
                    }
                }
                if (isName && isAuthor) {
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
    public static boolean checkIfUserInBorrowedData(String name, String email, String bookname, String author) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\booksBorrowed.txt"));) {
            String line = br.readLine();
            while (line != null) {
                boolean isName = false, isEmail = false, isBook = false, isAuthor = false;
                String data[] = line.split(",");
                for (String subData : data) {
                    String info[] = subData.split(":");
                    switch (info[0].trim()) {
                        case "user-name":
                            if (info[1].trim().toLowerCase().equals(name.toLowerCase()))
                                isName = true;
                            break;
                        case "email":
                            if (info[1].trim().toLowerCase().equals(email.toLowerCase()))
                                isEmail = true;
                            break;
                        case "book":
                            if (info[1].trim().toLowerCase().equals(bookname.toLowerCase()))
                                isBook = true;
                            break;
                        case "author":
                            if (info[1].trim().toLowerCase().equals(author.toLowerCase()))
                                isAuthor = true;
                            break;
                    }
                }
                if (isName && isEmail && isBook && isAuthor) {
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
    public static boolean checkIfUserInBorrowedData(String name, String email) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("E:\\Main_folder\\programming\\java\\Library\\src\\Data\\booksBorrowed.txt"));) {
            String line = br.readLine();
            while (line != null) {
                boolean isName = false, isEmail = false;
                String data[] = line.split(",");
                for (String subData : data) {
                    String info[] = subData.split(":");
                    switch (info[0].trim()) {
                        case "user-name":
                            if (info[1].trim().toLowerCase().equals(name.toLowerCase()))
                                isName = true;
                            break;
                        case "email":
                            if (info[1].trim().toLowerCase().equals(email.toLowerCase()))
                                isEmail = true;
                            break;
                    }
                }
                if (isName && isEmail) {
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