//я перевизначила методи move(),color(),toDtring(),equals() класа Point класі DistancePoint
// також поліморфізм в main через методи move(),color()
public class Point
{
    protected double x;
    protected double y;

    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public void move(double dx, double dy)
    {
        x += dx;
        y += dy;
    }
    public void color()
    {
        System.out.println("Blue");
    }


    @Override
    public String toString()
    {
        return "Point: (" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof Point))
        {
            return false;
        }
        Point other = (Point) obj;
        return Double.compare(other.x, x) == 0 && Double.compare(other.y, y) == 0;
    }
}
