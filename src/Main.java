
import java.util.List;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        LibrarySerializer serializer = new LibrarySerializer();

        List<Book> books = serializer.loadLibrary("library.ser");
        if (books != null) {
            library.setBooks(books);
            System.out.println("Library loaded successfully from src/resources/data/library.ser");
        } else {
            System.out.println("Loading data from books.txt...");
            library.loadBooks("books.txt");
        }

        LibraryMenu menu = new LibraryMenu(library);
        menu.displayMenu();

        serializer.saveLibrary(library.getBooks(), "library.ser");
        System.out.println("library.ser");

        // for (Book book : books) {
        // System.out.println(book);
        /*
         * SortUtil.bubbleSort(library.getBooks(),
         * Comparator.comparing(Book::getTitle));
         * 
         * Scanner scanner = new Scanner(System.in);
         * 
         * LibraryMenu menu = new LibraryMenu(library);
         * 
         * menu.displayMenu();
         * UserInteractionLogger logger = new UserInteractionLogger();
         * logger.log("Program started and menu displayed.");
         * 
         * library.viewAllBooks();
         * logger.log("Viewed all books.");
         * 
         * SortUtil.bubbleSort(library.getBooks(),
         * Comparator.comparing(Book::getTitle));
         * logger.log("Sorted books by title.");
         */
    }
}

/*
 * 
 * Test Name: testSearchBookByAuthorKeyword
 * Test Status: Test Failed.
 * Failed Test Feedback: Cannot invoke "Book.getTitle()" because "<local2>" is
 * null
 * 
 * 
 * Test Name: testLoadLibrary
 * Test Status: Test Failed.
 * Failed Test Feedback: Task: 6 (TODO: 21-22) - Library deserialization:
 * expected loaded books to not be null
 * 
 * 
 * Test Name: testSearchBookByTitleKeyword
 * Test Status: Test Failed.
 * Failed Test Feedback: Cannot invoke "Book.getTitle()" because "<local2>" is
 * null
 * 
 * 
 * 
 */