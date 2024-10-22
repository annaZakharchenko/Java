
public class Main {
    public static void main(String[] args) {
       Point[] polygonPoint = {
               new Point(0, 0),
               new Point(1, 3),
               new Point(2, 1),
       };
       Polygon polygon = new Polygon(polygonPoint);
       Circle circle = new Circle(new Point(5,5), 3);

       Moveable[] shapes = {polygon, circle};

       System.out.println("Original shapes: ");
       for (Moveable shape : shapes) {
           System.out.println(shape);
       }

       Point movePoint = new Point(1, 1);
       for (Moveable shape : shapes) {
           shape.move(movePoint);
       }

       System.out.println("\nShapes after moving: ");
       for (Moveable shape : shapes) {
           System.out.println(shape);
       }
    }
}