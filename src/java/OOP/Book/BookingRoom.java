package OOP.Book;

public class BookingRoom {

    private Date checkInDate;
    public Time checkInTime;
    private double totalPrice;
    public byte typeOfRoom;
    public byte noOfRooms;

    public BookingRoom() {
        checkInDate = new Date();
        checkInTime = new Time();
    }

    void getBookingDate() {
        System.out.println("Check in Date: " + checkInDate.day + "/" + checkInDate.month + "/" + checkInDate.year);
    }

    void setBookingDate(byte d, byte m, short y) {
        checkInDate.day = d;
        checkInDate.month = m;
        checkInDate.year = y;
    }

    void getBookingTime() {
        System.out.println("Check in Time: " + checkInTime.hours + ":" + checkInTime.minutes);
    }

    void setCheckInTime(Time obj) {
        checkInTime.hours = obj.hours;
        checkInTime.minutes = obj.minutes;
    }

    double getTotalPrice() {
        switch (typeOfRoom) {
            case 1:
                totalPrice = noOfRooms * 1000;
                break;

            case 2:
                totalPrice = noOfRooms * 1500;
                break;

            case 3:
                totalPrice = noOfRooms * 1600;
                break;
        }
        return totalPrice;
    }

    void displayTicketInformation() {

        System.out.println("\nFollowing is the information about the room(s) booked: ");
        System.out.println("--------------------------------------------------------");

        getBookingDate();
        getBookingTime();

        System.out.println("Number of tickets: " + noOfRooms);
        System.out.print("Type of Room: ");

        switch(typeOfRoom) {

            case 1:
                System.out.print("Single");
                break;

            case 2:
                System.out.print("Double");
                break;

            case 3:
                System.out.print("Twin");
                break;
        }
        System.out.printf("\nTotal cost of the ticket: $%.2f", getTotalPrice());
    }

}
