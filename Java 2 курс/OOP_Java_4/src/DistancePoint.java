public class DistancePoint extends Point
{

    public DistancePoint(double x, double y)
    {
        super(x, y);
    }

    @Override
    public void move(double dx, double dy)
    {
        double previousX = this.x;
        double previousY = this.y;
        super.move(dx, dy);
        double movedX = this.x - previousX;
        double movedY = this.y - previousY;
        System.out.println("DistancePoint moved by (" + movedX + ", " + movedY + ")");
    }

    @Override
    public void color()
    {
        System.out.println("Green");
    }

    public double distanceTo(Point otherPoint)
    {
        double dx = this.x - otherPoint.x;
        double dy = this.y - otherPoint.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "DistancePoint: (" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
