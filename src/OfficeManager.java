// Singleton Pattern: OfficeManager manages all rooms and ensures only one instance exists.
import java.util.HashMap;
import java.util.Map;
public class OfficeManager
{
    private static OfficeManager _instance;
    private Map<Integer, Room> _rooms;
    private OfficeManager()
    {
        _rooms = new HashMap<>();
    }

    public static OfficeManager GetInstance()
    {
        if (_instance == null)
            _instance = new OfficeManager();
        return _instance;
    }

    public void ConfigureOffice(int roomCount)
    {
        for (int i = 1; i <= roomCount; i++)
        {
            _rooms.put(i, new Room(i));
        }
        System.out.println("Office configured with " + _rooms.size() + " meeting rooms.");
    }

    public Room GetRoom(int roomId)
    {
        if (_rooms.containsKey(roomId))
            return _rooms.get(roomId);

        throw new RuntimeException("Room does not exist.");
    }
}