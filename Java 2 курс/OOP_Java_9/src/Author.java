import java.io.*;

public class Author implements Externalizable
{
    private String name;
    private String surname;

    public Author()
    {

    }

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(surname);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        surname = (String) in.readObject();
    }

    @Override
    public String toString() {
        return "\n\nAuthor" +
                "\nName: " + name +
                "\nSurname: " + surname;
    }
}
