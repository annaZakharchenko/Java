import java.text.DecimalFormat;

public class Main
{
    public static void main(String[] args)
    {
        try {
            Figure[] figures = new Figure[3];
            figures[0] = new Rectangle(5, 4);
            figures[1] = new Circle(3);
            figures[2] = new Triangle(3, 4, 5);

            for (Figure figure : figures)
            {
                System.out.println(figure.toString());
                System.out.println("Area: " + figure.calculateArea());
                System.out.println("Perimeter: " + figure.calculatePerimeter());
                if (figure instanceof Rectangle)
                {
                    Rectangle rectangle = (Rectangle) figure;
                    System.out.println("Diagonal Length: " + rectangle.getDiagonalLength());
                }
                System.out.println();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
