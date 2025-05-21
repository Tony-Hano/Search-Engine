
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class UserInteractionLogger {

    private static final String LOG_FILE = "src/resources/data/user_interactions.log";

    public void logSearch(String searchTerm) {
        log("Search for: " + searchTerm);
    }

    public void logSort(String sortCriteria) {
        log("Sorted by: " + sortCriteria);
    }

    public void logViewAllBooks() {
        log("Viewed all books");
    }

    public void log(String message) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(LocalDateTime.now() + message);
            System.out.println("Data appended successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}