public class Main {
    public static void main(String[] args) {

        Library library = new Library();


        Book book1 = new Book("JAVA", "Sam Martin", "734837184", 2005);
        Book book2 = new Book("Spring", "Julie Martin", "8712481", 2010);


        library.addBook(book1);
        library.addBook(book2);


        Patron patron1 = new Patron("Samuel", "S001");
        Patron patron2 = new Patron("Linda", "S002");


        library.addPatron(patron1);
        library.addPatron(patron2);


        library.checkoutBook("734837184", "S001");


        System.out.println("Samuel's borrowed books: " + patron1.getBorrowedBooks());


        library.returnBook("734837184", "S001");


        System.out.println("Samuel's borrowed books after return: " + patron1.getBorrowedBooks());


        book1.setPublicationYear(2022);
        library.updateBook(book1);
        System.out.println("Updated Book: " + library.searchBookByIsbn("734837184"));


        patron1.setName("Joshua");
        library.updatePatron(patron1);
        System.out.println("Updated Patron: " + library.searchPatronById("S001"));
    }
}
