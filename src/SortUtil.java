
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortUtil {

    public static void bubbleSort(List<Book> books, Comparator<Book> comparator) {
        if (books.size() == 0) {
        } else {
            int n = books.size();
            for (int i = 0; i < n; i++) {
                int m = 0;

                for (int j = 1; j < n - i; j++) {
                    if (!(comparator.compare(books.get(j), books.get(m)) > 0)) {
                        Book varBook = books.get(j);
                        books.set(j, books.get(m));
                        books.set(m, varBook);
                    }
                    m++;
                }
            }
        }
    }

    public static void insertionSort(List<Book> books, Comparator<Book> comparator) {
        for (int i = 1; i < books.size(); i++) {
            Book key = books.get(i);
            int j = i - 1;
            while (j >= 0 && comparator.compare(books.get(j), key) > 0) {
                books.set(j + 1, books.get(j));
                j = j - 1;
            }
            books.set(j + 1, key);
        }
    }

    public static void quickSort(List<Book> books, Comparator<Book> comparator, int low, int high) {
        if (low < high) {
            int pi = partition(books, comparator, low, high);
            quickSort(books, comparator, low, pi - 1);
            quickSort(books, comparator, pi + 1, high);
        }
    }

    private static int partition(List<Book> books, Comparator<Book> comparator, int low, int high) {
        Book pivot = books.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (comparator.compare(books.get(j), pivot) <= 0) {
                i++;
                Collections.swap(books, i, j);
            }
        }
        Collections.swap(books, i + 1, high);
        return i + 1;
    }
}
