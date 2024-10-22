import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        File file = new File("library.data");
        Library library = new Library("My Library");

        List<Author> authors1 = new ArrayList<>();
        authors1.add(new Author("Author1", "Surname1"));
        Book book1 = new Book("Book1", authors1, 2000, 1);

        List<Author> authors2 = new ArrayList<>();
        authors2.add(new Author("Author2", "Surname2"));
        Book book2 = new Book("Book2", authors2, 2005, 2);

        library.addBook(book1);
        library.addBook(book2);

        Reader reader = new Reader("John", "Doe", 3445);
        reader.borrowBook(book1);
        reader.borrowBook(book2);
        library.addReader(reader);

        System.out.println("Before serialization/deserialization:");
        System.out.println(library);


        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file)))
        {
            library.writeExternal(objectOutputStream);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file)))
        {
            Library deserializedLibrary = new Library();
            deserializedLibrary.readExternal(objectInputStream);
            System.out.println("\nDeserialized Library: " + deserializedLibrary);
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }

}
