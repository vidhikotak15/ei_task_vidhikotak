public class CancelRoomCommand implements ICommand
{
    private Room room;

    public CancelRoomCommand(Room room) {
        this.room = room;
    }

    @Override
    public void Execute() {
        room.cancelBooking();
    }
}