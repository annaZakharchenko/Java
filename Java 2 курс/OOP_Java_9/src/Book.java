import java.io.*;
import java.util.List;

public class Book implements Externalizable{
    private String title;
    private List<Author> authors;
    private int publicationYear;
    private int editionNumber;

    public Book()
    {
    }

    public Book(String title, List<Author> authors, int publicationYear, int editionNumber) {
        this.title = title;
        this.authors = authors;
        this.publicationYear = publicationYear;
        this.editionNumber = editionNumber;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(title);
        out.writeObject(authors);
        out.writeInt(publicationYear);
        out.writeInt(editionNumber);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        title = (String) in.readObject();
        authors = (List<Author>) in.readObject();
        publicationYear = in.readInt();
        editionNumber = in.readInt();
    }



    @Override
    public String toString() {
        return "\n\nBook " +
                "\nTitle: '" + title +
                "\nAuthors: " + authors +
                "\nPublication Year: " + publicationYear +
                "\nEdition Number: " + editionNumber;
    }
}
