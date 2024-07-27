import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String name;
    private String patronId;
    private List<Book> borrowedBooks;


    public Patron(String name, String patronId) {
        this.name = name;
        this.patronId = patronId;
        this.borrowedBooks = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public String getPatronId() {
        return patronId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }


    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }


    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }


    public String toString() {
        return "Patron [name=" + name + ", patronId=" + patronId + "]";
    }

    public void setName(String aliceJohnson) {
    }
}
