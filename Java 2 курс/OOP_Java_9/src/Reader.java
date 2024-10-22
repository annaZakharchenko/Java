import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader implements Externalizable{
    private String name;
    private String surname;
    private int registrationNumber;
    private List<Book> borrowedBooks;

    public Reader(){

    }

    public Reader(String name, String surname, int registrationNumber) {
        this.name = name;
        this.surname = surname;
        this.registrationNumber = registrationNumber;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(surname);
        out.writeInt(registrationNumber);
        out.writeObject(borrowedBooks);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        surname = (String) in.readObject();
        registrationNumber = in.readInt();
        borrowedBooks = (List<Book>) in.readObject();
    }

    @Override
    public String toString() {
        return "\n\nReader" +
                "\nName: " + name +
                "\nSurname: " + surname +
                "\nRegistrationNumber: " + registrationNumber +
                "\nBorrowedBooks: " + borrowedBooks;
    }
}
