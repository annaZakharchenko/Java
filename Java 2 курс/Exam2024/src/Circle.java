public class Circle implements Moveable {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public void move(Point p){
        center.x += p.x;
        center.y += p.y;
    }
    @Override
    public String toString() {
        return "Circle:\nCenter = " + center.toString() + "\nRadius = " + radius;
    }
}
