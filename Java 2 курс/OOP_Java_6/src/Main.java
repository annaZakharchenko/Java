import java.util.Iterator;

public class Main
{
    public static void main(String[] args)
    {
        Vector vector1 = new Vector(3);
        vector1.setCoordinate(0, 5);
        vector1.setCoordinate(1, 2);
        vector1.setCoordinate(2, 8);

        System.out.println("Vector 1: " + vector1);
        System.out.println("Length of Vector 1: " + vector1.calculateLength());

        Vector vector2 = new Vector(vector1);
        System.out.println("Vector 2: " + vector2);
        System.out.println("Length of Vector 2: " + vector2.calculateLength());

        double[] coordinates = {1.1, 2.5, 3};
        Vector vector3 = new Vector(coordinates);
        System.out.println("Vector 3: " + vector3);
        System.out.println("Length of Vector 3: " + vector3.calculateLength());

        System.out.println("vector1 equals vector2: " + vector1.equals(vector2));
        System.out.println("vector1 equals vector3: " + vector1.equals(vector3));


        /*
        for (Double coordinate : vector1) {
            System.out.print(coordinate + " ");
        }*/


        Vector.CoordinateIterator iterator =  vector1.new CoordinateIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

    }
}
