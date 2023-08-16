package src.Classes;

// user class inherit from User class
public class Tenate extends User {

    // user id
    private final long userId;

    public Tenate() {
        this.userId = generateUniqueId();
    }

    public long getUserId() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "{" +
                " user name='" + getName() + "'" +
                " user email='" + getEmail() + "'" +
                " user number='" + getphoneNumber() + "'" +
                " userId='" + getUserId() + "'" +
                "}";
    }

    // create a unike id for every user
    public static int generateUniqueId() {
        // user range from 1 to 9999
        int id = (int) (Math.random() * (9999 - 1 + 1) + 1);
        // check if id is exist
        if (!Checkers.checkIdInData(id)) {
            generateUniqueId();
        }
        return id;
    }
}
