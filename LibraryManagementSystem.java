public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library lib = new Library();

        // Add Users
        lib.addUser(new User("Alice", 1));
        lib.addUser(new User("Bob", 2));

        // Add Books
        lib.addBook(new Book("Java Basics", "John Doe", "ISBN0001"));
        lib.addBook(new Book("OOP Design", "Jane Doe", "ISBN0002"));

        // List Users and Books
        System.out.println("-- Users --");
        lib.showUsers();
        System.out.println("-- Books --");
        lib.showBooks();

        // Issue a Book
        lib.issueBook("ISBN0001", 1);
        lib.showBooks();

        // Return a Book
        lib.returnBook("ISBN0001", 1);
        lib.showBooks();
    }
}
