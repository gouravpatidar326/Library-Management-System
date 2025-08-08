import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private Map<Integer, List<Book>> issuedBooks = new HashMap<>(); // UserID -> List of Books

    public void addBook(Book book) { books.add(book); }
    public void addUser(User user) { users.add(user); }

    public void showBooks() {
        for (Book book : books)
            System.out.println(book);
    }

    public void showUsers() {
        for (User user : users)
            System.out.println(user);
    }

    public boolean issueBook(String isbn, int userId) {
        Book bookToIssue = null;
        for (Book book : books) {
            if (book.getISBN().equals(isbn) && !book.isIssued()) {
                bookToIssue = book;
                break;
            }
        }
        if (bookToIssue == null) {
            System.out.println("Book not found or already issued.");
            return false;
        }
        for (User user : users) {
            if (user.getId() == userId) {
                bookToIssue.issue();
                issuedBooks.computeIfAbsent(userId, k -> new ArrayList<>()).add(bookToIssue);
                System.out.println("Book issued to: " + user.getName());
                return true;
            }
        }
        System.out.println("User not found.");
        return false;
    }

    public boolean returnBook(String isbn, int userId) {
        List<Book> userBooks = issuedBooks.get(userId);
        if (userBooks == null) {
            System.out.println("No books issued for this user.");
            return false;
        }
        for (Book book : userBooks) {
            if (book.getISBN().equals(isbn)) {
                book.returnBook();
                userBooks.remove(book);
                System.out.println("Book returned.");
                return true;
            }
        }
        System.out.println("Book not found in user's issued list.");
        return false;
    }
}
