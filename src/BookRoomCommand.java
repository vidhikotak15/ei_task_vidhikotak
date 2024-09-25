public class BookRoomCommand implements ICommand
{
    private Room room;
    private int durationMinutes;

    public BookRoomCommand(Room room, int durationMinutes) {
        this.room = room;
        this.durationMinutes = durationMinutes;
    }

    @Override
    public void Execute() {
        room.bookRoom(durationMinutes);
    }
}