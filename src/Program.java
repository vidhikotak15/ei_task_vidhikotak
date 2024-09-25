public class Program
{
    public static void main(String[] args)
    {
        // Singleton: Create office with 3 rooms
        OfficeManager manager = OfficeManager.GetInstance();
        manager.ConfigureOffice(3);

        // Sensors observing room occupancy
        Room room1 = manager.GetRoom(1);
        Sensor sensor1 = new Sensor(room1);

        // Command Pattern - Book Room 1 for 60 minutes
        ICommand bookRoom1 = new BookRoomCommand(room1, 60);
        bookRoom1.Execute();

        // Sensor detects occupancy
        sensor1.updateOccupancy(2); // Room 1 occupied

        // Command Pattern - Cancel Room 1 booking
        ICommand cancelRoom1 = new CancelRoomCommand(room1);
        cancelRoom1.Execute();

        // Sensor detects unoccupancy
        sensor1.updateOccupancy(0); // Room 1 unoccupied

    }
}
