
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class UserInteractionLogger {

    private static final String LOG_FILE = "src/resources/data/user_interactions.log";

    // Method to log search interactions
    public void logSearch(String searchTerm) {
        log("Search for: " + searchTerm);
    }

    // Method to log sorting interactions
    public void logSort(String sortCriteria) {
        log("Sorted by: " + sortCriteria);
    }

    // Method to log viewing all books
    public void logViewAllBooks() {
        log("Viewed all books");
    }

    // Generic method to log messages with a timestamp
    public void log(String message) {
    // TODO - missing code.
try (FileWriter writer = new FileWriter(LOG_FILE, true)) { // `true` enables append mode
            writer.write(LocalDateTime.now() + message);
            System.out.println("Data appended successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }    
    }
}