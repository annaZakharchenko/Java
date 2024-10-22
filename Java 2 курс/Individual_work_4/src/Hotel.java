import java.util.ArrayList;
import java.util.List;

class Hotel {
    private int capacity;
    private List<String> guests;

    public Hotel(int capacity) {
        this.capacity = capacity;
        this.guests = new ArrayList<>();
    }

    public synchronized boolean checkIn(String guestName) {
        if (guests.size() < capacity) {
            guests.add(guestName);
            System.out.println("Guest '" + guestName + "' checked in. \nAvailable rooms: " + (capacity - guests.size()));
            return true;
        } else {
            System.out.println("Sorry, no available rooms for guest '" + guestName + "'");
            return false;
        }
    }

    public synchronized void checkOut(String guestName) {
        guests.remove(guestName);
        System.out.println("Guest '" + guestName + "' checked out. Available rooms: " + (capacity - guests.size()));
        notifyAll();
    }

    public synchronized void findGuestByName(String guestName) {
        for (String guest : guests) {
            if (guest.equals(guestName)) {
                System.out.println("Guest '" + guestName + "' found in the hotel.");
                return;
            }
        }
        System.out.println("Guest '" + guestName + "' not found in the hotel.");
    }

    public synchronized void printGuestList() {
        System.out.println("Current guests in the hotel:");
        for (String guest : guests) {
            System.out.println(guest);
        }
    }

}