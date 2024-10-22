public class Main
{
    public static void main(String[] args)
    {
        Point p1 = new Point(1.5, 2.5);
        DistancePoint p2 = new DistancePoint(0.5, 1.5);
        DistancePoint p3 = new DistancePoint(1.5, 2.5);

        System.out.println("p1 equals p3: " + p1.equals(p3));

        p1.move(1.0, 2.0);
        p2.move(1.0, 1.0);

        System.out.println("p1 " + p1);
        System.out.println("p2 " + p2);
        System.out.println("p3 " + p3);

        p1.color();
        p2.color();

        System.out.println("Distance between p1 and p2: " + p2.distanceTo(p1));

        System.out.println("p1 equals p3: " + p1.equals(p3));
        System.out.println("p2 equals p3: " + p2.equals(p3));
    }
}
