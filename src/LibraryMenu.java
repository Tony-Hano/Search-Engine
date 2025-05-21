import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    private Library library;
    private UserInteractionLogger logger = new UserInteractionLogger();
    private LibrarySerializer serializer = new LibrarySerializer();

    public LibraryMenu(Library library) {
        this.library = library;
        List<Book> books = serializer.loadLibrary("books.txt");
        if (books != null) {
            library.setBooks(books);
            System.out.println("Library loaded successfully.");
        } else {
            System.out.println("No saved library found. Loading default books.");
        }
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("1- Viewing all books.");
            System.out.println("2- Sorting books by title.");
            System.out.println("3- Sorting books by author.");
            System.out.println("4- Sorting books by publication year.");
            System.out.println("5- Searching for a book by keyword. ");
            System.out.println("6- Add a book.");
            System.out.println("7- Exiting the program.");
            System.out.println("Choose a number from 1 to 7:");
            String boom = scanner.nextLine();
            switch (boom) {
                case "1": {
                    library.viewAllBooks();
                    break;
                }

                case "2": {
                    // SortUtil koko = new SortUtil ();
                    SortUtil.bubbleSort(library.getBooks(), Comparator.comparing(Book::getTitle));
                    System.out.println("sorted by title");
                    break;
                }

                case "3": {
                    SortUtil.insertionSort(library.getBooks(), Comparator.comparing(Book::getAuthor));
                    System.out.println("sorted by author");
                    break;
                }

                case "4": {
                    SortUtil.quickSort(library.getBooks(), Comparator.comparing(Book::getPublicationYear), 0,
                            library.getBooks().size() - 1);
                    System.out.println("sorted by publication year");
                    break;
                }

                case "5": {
                    System.out.print("Enter a keyword to search (title, author, or year): ");
                    String keyword = scanner.nextLine();
                    Book foundBook = library.searchBookByKeyword(keyword);
                    if (foundBook != null) {
                        System.out.println("Book found: " + foundBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                }

                case "6": {
                    System.out.print("Enter the title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter the  author: ");
                    String author = scanner.nextLine();
                    System.out.println("Enter the  year: ");
                    int year = scanner.nextInt();
                    library.addBook(title, author, year);
                    serializer.saveLibrary(serializer.loadLibrary("data/books.txt"), "data/books.txt");
                    serializer.saveLibrary(serializer.loadLibrary("data/library.ser"), "data/library.ser");

                    break;
                }

                case "7": {
                    System.exit(0);
                }
                default: {
                    break;
                }
            }
        }
    }
}