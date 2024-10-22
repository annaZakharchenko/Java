class StayRequest extends Thread {
    private String guestName;
    private int duration;
    private Hotel hotel;

    public StayRequest(String guestName, int duration, Hotel hotel) {
        this.guestName = guestName;
        this.duration = duration;
        this.hotel = hotel;
    }

    @Override
    public void run() {
        boolean checkedIn = false;
        while (!checkedIn) {
            synchronized (hotel) {
                checkedIn = hotel.checkIn(guestName);
                if (!checkedIn) {
                    try {
                        System.out.println("Guest '" + guestName + "' is waiting for a room...");
                        hotel.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        hotel.checkOut(guestName);
    }
}
