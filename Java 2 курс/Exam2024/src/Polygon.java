public class Polygon  implements Moveable{
    private Point[] vertices;

    public Polygon(Point[] vertices) {
        this.vertices = vertices;
    }
    @Override
    public void move(Point p) {
        for (Point v : vertices) {
            v.x += p.x;
            v.y += p.y;
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Polygon: ");
        for(Point v : vertices)
        {
            sb.append(v.toString()).append(" ");
        }
        return sb.toString();
    }
}
