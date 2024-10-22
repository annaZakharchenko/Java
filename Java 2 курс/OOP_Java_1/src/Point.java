public class Point
{
    private double x;
    private double y;
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    public double getX()
    {
        return x;
    }
    public double getY()
    {
        return y;
    }
    public boolean isInCircle(Point center, double radius)
    {
        double distanceSquared = (x - center.getX()) * (x - center.getX()) + (y - center.getY()) * (y - center.getY());
        return distanceSquared <= radius * radius;
    }

    @Override
    public String toString()
    {
        return "(" + String.format("%.1f",x) + " , " + String.format("%.1f",y) + ")";
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Point point = (Point) obj;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

}
