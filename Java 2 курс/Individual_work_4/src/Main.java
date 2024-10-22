public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel(2);

        StayRequest request1 = new StayRequest("John", 3000, hotel);
        StayRequest request2 = new StayRequest("Alice", 4500, hotel);
        StayRequest request3 = new StayRequest("Bob", 2000, hotel);

        hotel.printGuestList();
        hotel.findGuestByName("Bob");

        request1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        request2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        request3.start();

        hotel.printGuestList();
        hotel.findGuestByName("Alice");




        hotel.printGuestList();
    }
}
