public class Circle extends Figure
{
    private double radius;
    public Circle(double radius) throws Exception
    {
        if (radius <= 0)
            throw new Exception("Invalid radius for Circle");

        this.radius = radius;
    }

    @Override
    double calculateArea()
    {
        return Math.PI * radius * radius;
    }

    @Override
    double calculatePerimeter()
    {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString()
    {
        return "Circle: radius = " + radius;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Circle circle = (Circle) obj;
        return Double.compare(circle.radius, radius) == 0;
    }
}
