import java.util.Arrays;

public class Vector
{
    private double[] coordinates;
    public Vector(int dimension)
    {
        this.coordinates = new double[dimension];
    }
    public Vector(Vector vector)
    {
        this.coordinates = Arrays.copyOf(vector.coordinates, vector.coordinates.length);
    }

    public Vector(double[] coordinates)
    {
        this.coordinates = Arrays.copyOf(coordinates, coordinates.length);
    }
    public int getSize()
    {
        return coordinates.length;
    }
    public double getCoordinate(int index)
    {
        return coordinates[index];
    }
    public void setCoordinate(int index, double value)
    {
        coordinates[index] = value;
    }
    public double calculateLength()
    {
        double sum = 0;
        for (double coordinate : coordinates)
        {
            sum += coordinate * coordinate;
        }
        return Math.sqrt(sum);
    }

    @Override
    public String toString()
    {
        StringBuilder strbild = new StringBuilder("(");
        for (int i = 0; i < coordinates.length; i++)
        {
            strbild.append(coordinates[i]);
            if (i < coordinates.length - 1)
            {
                strbild.append(", ");
            }
        }
        strbild.append(")");
        return strbild.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vector vector = (Vector) obj;
        return Arrays.equals(coordinates, vector.coordinates);
    }
}
