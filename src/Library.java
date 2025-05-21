
import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books = new ArrayList<>();

    public void loadBooks(String fileName) {
        // Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
        // Book book3 = new Book("1984", "George Orwell", 1949);
        // Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        // books.add(book1);
        // books.add(book2);
        // books.add(book3);
        File fileo = new File(fileName);
        try {
            fileo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (

                FileOutputStream file = new FileOutputStream(fileo);
                ObjectOutputStream out = new ObjectOutputStream(file);) {

            for (Book book : books) {
                out.writeObject(book);
            }
            out.close();
            file.close();
            System.out.println("books.txt has been completed");
        } catch (IOException ex) {
            System.out.println("books.txt are not completed");
        }

        /*
         * try (FileInputStream fis = new FileInputStream(fileName);
         * ObjectInputStream ois = new ObjectInputStream(fis)) {
         * Book book1 = (Book) ois.readObject();
         * System.out.println("we can read objects");
         * books.add(book1);
         * System.out.println("books added in the array");
         */

        /*
         * 
         * try( //Saving of object in a file
         * FileOutputStream file = new
         * FileOutputStream("src/resources/data/library.ser");
         * ObjectOutputStream out = new ObjectOutputStream(file);) {
         * 
         * // Method for serialization of object
         * out.writeObject(book1);
         * System.out.println("books writen in lib");
         * out.close();
         * file.close();
         * 
         * System.out.println("tmam");
         * 
         * }catch (Exception e) {
         * System.out.println("exception in 111");
         * }
         * System.out.println("we put objects in books array and lib file");
         * } catch (Exception e) {
         * System.out.println("exception in 222");
         * }
         */
        File file = new File("library.ser");

        System.out.println("we can read");
        try (FileWriter filewriter = new FileWriter(file)) {
            System.out.println("we can write");
            BufferedWriter bw = new BufferedWriter(filewriter);
            for (Book book : books) {
                bw.write(book.toString() + "\n");
            }
            System.out.println("we have written in library");
            bw.flush();
            bw.close();
        }

        catch (Exception e) {
            System.out.println("exception 111");
        }
    }

    public void viewAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println("Printed");
    }

    public Book searchBookByKeyword(String Keyword) {

        String keyword = Keyword.toLowerCase();

        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(keyword)) {
                return book;
            }
            if (book.getTitle().toLowerCase().contains(keyword)) {
                return book;
            }
            String bom = Integer.toString(book.getPublicationYear());
            if (bom.contains(keyword)) {
                return book;
            }

        }
        return null;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(String ti, String au, int year) {
        Book addaBook = new Book(ti, au, year);
        books.add(addaBook);
        loadBooks("books.txt");
    }
}