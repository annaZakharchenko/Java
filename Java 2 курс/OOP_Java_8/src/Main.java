import java.util.*;

public class Main
{
    public static void main(String[] args) {
        Random random = new Random();

        TreeMap<Point, String> treeMap = new TreeMap<>(Point.getComparator());

        for (int i = 0; i < 10; i++) {
            Point point2 = new Point(random.nextInt(10), random.nextInt(10));
            treeMap.put(point2, "Value" + i);
        }

        System.out.println("TreeMap:");
        for (Map.Entry<Point, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        ArrayList<Point> arrayList = new ArrayList<>();

        Point point1 = new Point(3,4);
        arrayList.add(point1);
        for(int i = 0; i < 5; i++)
        {
            Point point = new Point(random.nextInt(10), random.nextInt(10));
            arrayList.add(point);
            if(i % 2 == 0) {
                arrayList.add(point);
            }
        }
        System.out.println("ArrayList");
        for(Point point : arrayList){
            System.out.println(point);
        }

        TreeSet<Point> treeSet = new TreeSet<>();

        for (int i = 0; i < 5; i++) {
            Point point = new Point(random.nextInt(10), random.nextInt(10));
            treeSet.add(point);
        }

        System.out.println("TreeSet");
        for(Point point : treeSet){
            System.out.println(point);
        }

        Scanner scanner = new Scanner(System.in);

        Iterator<Point> arrayListIterator = arrayList.iterator();

        while (arrayListIterator.hasNext())
        {
            Point point = arrayListIterator.next();
            System.out.println("\nRemove element? (y/n): " + point);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("y"))
            {
                arrayListIterator.remove();
            }
        }

        System.out.println("\nTreeSet");
        for (Point point : treeSet) {
            System.out.println(point);
        }

        Iterator<Point> treeSetIterator = treeSet.iterator();

        while (treeSetIterator.hasNext()) {
            Point point = treeSetIterator.next();
            System.out.println("\nRemove element? (y/n): " + point);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("y")) {
                treeSetIterator.remove();
            }
        }

        System.out.println("ArrayList after deletion");
        for(Point point : arrayList){
            System.out.println(point);
        }

        System.out.println("\nTreeSet after deletion");
        for(Point point : treeSet){
            System.out.println(point);
        }



        System.out.println("\nEnter the coordinates of the point to check its presence in the collections:");
        System.out.print("X coordinate: ");
        int x = scanner.nextInt();
        System.out.print("Y coordinate: ");
        int y = scanner.nextInt();
        Point userInputPoint = new Point(x, y);

        System.out.println("\nArrayList contains the object (" + x + ", " + y + ")? " + arrayList.contains(userInputPoint));
        System.out.println("TreeSet contains the object (" + x + ", " + y + ")? " + treeSet.contains(userInputPoint));


        System.out.println("\nSorted ArrayList:");
        Collections.sort(arrayList);
        for (Point point : arrayList) {
            System.out.println(point);
        }

        System.out.println("\nSorted TreeSet");
        for(Point point : treeSet){
            System.out.println(point);
        }

        System.out.println("\nEnter the coordinates of the point to search in the ArrayList:");
        System.out.print("X coordinate: ");
        int searchX = scanner.nextInt();
        System.out.print("Y coordinate: ");
        int searchY = scanner.nextInt();
        Point searchPoint = new Point(searchX, searchY);

        int index = Collections.binarySearch(arrayList, searchPoint);
        if (index >= 0) {
            System.out.println("Found at index: " + index);
        } else {
            System.out.println("Not found in the ArrayList.");
        }

    }
}