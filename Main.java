//1. Class: Book
public class Book {
    private String title;
    private String author;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters (optional)
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Display method
    public void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

// 2. Class: Library (Aggregation with Book)
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    // Constructor
    public Library() {
        books = new ArrayList<>();
    }

    // Add a book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added: " + book.getTitle());
    }

    // Remove a book by title
    public void removeBook(String title) {
        boolean removed = books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
        if (removed) {
            System.out.println("Removed: " + title);
        } else {
            System.out.println("Book not found: " + title);
        }
    }

    // Display all books
    public void displayBooks() {
        System.out.println("\nLibrary contains:");
        for (Book book : books) {
            book.displayBook();
        }
    }
}

//3. Test in Main Class
public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book b1 = new Book("Atomic Habits", "James Clear");
        Book b2 = new Book("Clean Code", "Robert C. Martin");
        Book b3 = new Book("The Alchemist", "Paulo Coelho");

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        library.displayBooks();

        library.removeBook("Clean Code");
        library.displayBooks();
    }
}
