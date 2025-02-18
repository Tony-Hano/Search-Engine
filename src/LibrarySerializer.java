
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibrarySerializer {

    public void saveLibrary(List<Book> books, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (Book book : books){
            oos.writeObject(book); 
            }
                            // TODO - missing code
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Book> loadLibrary(String fileName) {
        File file = new File("src/resources/data/books.txt");
        if (!file.exists() || file.length() == 0) {

            return null;
        }
        else {
        List <Book> books = new ArrayList <>();
        
        try (FileInputStream fis = new FileInputStream(file);
           ObjectInputStream ois = new ObjectInputStream(fis);) {
             return (List<Book>) ois.readObject();
//          Book book1 = (Book) ois.readObject();
//            System.out.println("we can read objects");
//        books.add(book1);
//        Book book2 = (Book)ois.readObject();
//                books.add(book2);
//                Book book3 = (Book)ois.readObject();
//                books.add(book3);
//System.out.println("books added in the array");
//        return books;

        }
        catch (Exception e) {
           System.out.println("loadLibrary failed....656");        }
        return null;
    }
    }
/*  else {   try(FileWriter filewriter = new FileWriter(file)){
                System.out.println("we can write");
    BufferedWriter bw = new BufferedWriter(filewriter);
    for (Book book : books){
        bw.write(book.toString() + "\n");
        }System.out.println("we have written in library");
 bw.flush ();
bw.close();
}
        catch (Exception e) {
           System.out.println("loadLibrary failed.");        }
        return null;
    }*/
}
