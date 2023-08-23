package src.Classes;

// main class user
public abstract class MainUser {

    protected String name;
    protected String email;
    protected String phoneNumber;

    public MainUser() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getphoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}