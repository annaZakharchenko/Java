import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Library implements Externalizable {
    private String name;
    private List<Book> books;
    private List<Reader> readers;

    public Library()
    {

    }

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        this.readers = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addReader(Reader reader) {
        readers.add(reader);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(books);
        out.writeObject(readers);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        books = (List<Book>) in.readObject();
        readers = (List<Reader>) in.readObject();
    }

    @Override
    public String toString() {
        return "\nLibrary" +
                "\nName: " + name +
                "\nBooks: " + books +
                "\nReaders: " + readers;
    }
}
