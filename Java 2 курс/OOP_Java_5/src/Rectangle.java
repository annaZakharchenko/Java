public class Rectangle extends Figure
{
    private double length;
    private double width;

    public Rectangle(double length, double width) throws Exception
    {
        if (length <= 0 || width <= 0)
            throw new Exception("Invalid dimensions for Rectangle");

        this.length = length;
        this.width = width;
    }

    public double getDiagonalLength()
    {
        return Math.sqrt(length * length + width * width);
    }

    @Override
    double calculateArea()
    {
        return length * width;
    }

    @Override
    double calculatePerimeter()
    {
        return 2 * (length + width);
    }

    @Override
    public String toString()
    {
        return "Rectangle: length = " + length + "   width = " + width;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Rectangle rectangle = (Rectangle) obj;
        return Double.compare(rectangle.length, length) == 0 && Double.compare(rectangle.width, width) == 0;
    }
}
