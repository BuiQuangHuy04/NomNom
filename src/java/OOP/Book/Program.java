package OOP.Book;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        BookingRoom objBookingRoom = new BookingRoom();
        Time objTime = new Time();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter check in date (mm dd yyyy): ");
        byte day = input.nextByte();
        byte month = input.nextByte();
        short year = input.nextShort();

        System.out.println("Enter check in time (hh mm): ");
        objTime.hours = input.nextByte();
        objTime.minutes = input.nextByte();

        objBookingRoom.setBookingDate(day, month, year);
        objBookingRoom.setCheckInTime(objTime);

        System.out.println("Enter the type of room: \n1. Single\n2. Double\n3. Twin\n");
        objBookingRoom.typeOfRoom = input.nextByte();
        System.out.println("Enter the number of rooms: ");
        objBookingRoom.noOfRooms = input.nextByte();

        objBookingRoom.displayTicketInformation();

    }

}
