import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Patron> patrons;


    public Library() {
        this.books = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }



    // Add a new book
    public void addBook(Book book) {
        if (searchBookByIsbn(book.getIsbn()) != null) {
            throw new IllegalArgumentException("Book with this ISBN already exists.");
        }
        books.add(book);
    }

    // Remove a book
    public void removeBook(String isbn) {
        Book bookToRemove = searchBookByIsbn(isbn);
        if (bookToRemove == null) {
            throw new IllegalArgumentException("No book found with this ISBN.");
        }
        books.remove(bookToRemove);
    }

    // Update a book
    public void updateBook(Book updatedBook) {
        Book existingBook = searchBookByIsbn(updatedBook.getIsbn());
        if (existingBook == null) {
            throw new IllegalArgumentException("No book found with this ISBN.");
        }
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setPublicationYear(updatedBook.getPublicationYear());
    }

    // Search for a book by title
    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Search for a book by author
    public Book searchBookByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                return book;
            }
        }
        return null;
    }

    // Search for a book by ISBN
    public Book searchBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // Patron Management

    // Add a new patron
    public void addPatron(Patron patron) {
        for (Patron p : patrons) {
            if (p.getPatronId().equals(patron.getPatronId())) {
                throw new IllegalArgumentException("Patron with this ID already exists.");
            }
        }
        patrons.add(patron);
    }

    // Update a patron's information
    public void updatePatron(Patron updatedPatron) {
        for (Patron p : patrons) {
            if (p.getPatronId().equals(updatedPatron.getPatronId())) {
                p = updatedPatron; // Assuming patronId is unique, replace the whole patron
                return;
            }
        }
        throw new IllegalArgumentException("No patron found with this ID.");
    }

    // Lending Process

    // Checkout a book to a patron
    public void checkoutBook(String isbn, String patronId) {
        Book book = searchBookByIsbn(isbn);
        Patron patron = searchPatronById(patronId);

        if (book == null) {
            throw new IllegalArgumentException("No book found with this ISBN.");
        }

        if (patron == null) {
            throw new IllegalArgumentException("No patron found with this ID.");
        }

        if (book.isBorrowed()) {
            throw new IllegalStateException("Book is already borrowed.");
        }

        book.setBorrowed(true);
        patron.borrowBook(book);
    }

    // Return a book from a patron
    public void returnBook(String isbn, String patronId) {
        Book book = searchBookByIsbn(isbn);
        Patron patron = searchPatronById(patronId);

        if (book == null) {
            throw new IllegalArgumentException("No book found with this ISBN.");
        }

        if (patron == null) {
            throw new IllegalArgumentException("No patron found with this ID.");
        }

        if (!book.isBorrowed()) {
            throw new IllegalStateException("Book is not currently borrowed.");
        }

        book.setBorrowed(false);
        patron.returnBook(book);
    }

    // Search for a patron by ID
    Patron searchPatronById(String patronId) {
        for (Patron patron : patrons) {
            if (patron.getPatronId().equals(patronId)) {
                return patron;
            }
        }
        return null;
    }
}
