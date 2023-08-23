package src.Classes;

// class book
public class Book {
    // book info
    private String bookName;
    private int quantity;
    private String author;
    private String description;
    private float price;
    // create a unike id for the book
    private final String bookId;

    public Book() {
        bookId = generateUniqueId();
    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return this.bookId;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
                " bookName='" + getBookName() + "'" +
                ", quantity='" + getQuantity() + "'" +
                ", author='" + getAuthor() + "'" +
                ", description='" + getDescription() + "'" +
                ", code='" + getCode() + "'" +
                ", price='" + getPrice() + "'" +
                "}";
    }

    // create a unike id for every book
    public static String generateUniqueId() {
        // the range for books is from a1 to Z200
        char firstId = (char) (Math.random() * ((int) ('A') - (int) ('a') + 1) + (int) ('a'));
        int lastId = (int) (Math.random() * (200 - 1 + 1) + 1);
        String code = "" + firstId + lastId;
        // check if id is exist in books.txt
        if (!Checkers.checkCodeINBooksData(code)) {
            generateUniqueId();
        }
        return code;
    }
}