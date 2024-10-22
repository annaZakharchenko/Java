import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        Point[] points = new Point[6];

        Point center = new Point(1, 2);
        double radius = 5;

        Random random = new Random();

        System.out.println("Points inside the circle with center at " + center + " and radius " + radius + ":");
        for (int i = 0; i < 6; i++)
        {
            double randomX = random.nextDouble() * 10;
            double randomY = random.nextDouble() * 10;
            Point randomPoint = new Point(randomX, randomY);
            points[i] = randomPoint;

            if (randomPoint.isInCircle(center, radius))
            {
                System.out.println(randomPoint);
            }
        }

        System.out.println("Enter the coordinates of a point (x y):");
        double inputX = scanner.nextDouble();
        double inputY = scanner.nextDouble();
        Point inputPoint = new Point(inputX, inputY);

        if (inputPoint.isInCircle(center, radius))
        {
            System.out.println("The input point is inside the circle.");
        } else
        {
            System.out.println("The input point is outside the circle.");
        }

        scanner.close();
    }
}
