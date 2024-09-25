public class Room
{
    private int roomId;
    private boolean isOccupied;
    private boolean isBooked;
    private long bookingStartTime;

    public Room(int roomId) {
        this.roomId = roomId;
        this.isOccupied = false;
        this.isBooked = false;
    }

    public int getRoomId() {
        return roomId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void bookRoom(int durationMinutes) {
        if (isBooked) {
            System.out.println("Room " + roomId + " is already booked.");
        } else {
            isBooked = true;
            bookingStartTime = System.currentTimeMillis();
            System.out.println("Room " + roomId + " booked for " + durationMinutes + " minutes.");
        }
    }

    public void cancelBooking() {
        if (!isBooked) {
            System.out.println("Room " + roomId + " is not booked. Cannot cancel.");
        } else {
            isBooked = false;
            System.out.println("Booking for Room " + roomId + " cancelled successfully.");
        }
    }

    public void releaseBookingIfUnoccupied() {
        if (!isOccupied && isBooked) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - bookingStartTime >= 5 * 60 * 1000) { // 5 minutes threshold
                isBooked = false;
                System.out.println("Room " + roomId + " is unoccupied. Booking released.");
            }
        }
    }
}
