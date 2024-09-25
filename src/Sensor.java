import java.io.Console;

public class Sensor
{
    private Room room;

    public Sensor(Room room) {
        this.room = room;
    }

    public void updateOccupancy(int occupants) {
        if (occupants >= 2) {
            room.setOccupied(true);
            System.out.println("Room " + room.getRoomId() + " is now occupied by " + occupants + " persons. AC and lights turned on.");
        } else {
            room.setOccupied(false);
            System.out.println("Room " + room.getRoomId() + " is now unoccupied. AC and lights turned off.");
            room.releaseBookingIfUnoccupied();
        }
    }
}