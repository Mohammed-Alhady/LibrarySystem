package src.Classes;

// class admin inhiret from user
public class Admin extends User {

    // password and id
    private String password;
    private final long AdminId;

    public Admin() {
        this.AdminId = generateUniqueId();
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getAdminId() {
        return this.AdminId;
    }

    @Override
    public String toString() {
        return "{" +
                " password='" + getPassword() + "'" +
                ", AdminId='" + getAdminId() + "'" +
                "}";
    }

    // generet a unike id
    public static int generateUniqueId() {
        // the range for admins is 10000 to 99999
        int id = (int) (Math.random() * (99999 - 10000 + 1) + 10000);
        // check if id in exist in admins.txt
        if (!Checkers.checkIdInAdminData(id)) {
            generateUniqueId();
        }
        return id;
    }
}
