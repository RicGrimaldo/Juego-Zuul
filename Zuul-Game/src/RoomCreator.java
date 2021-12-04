import rooms.Lab;
import rooms.Office;
import rooms.Outside;
import rooms.Pub;
import rooms.Room;
import rooms.Theatre;

public class RoomCreator {

    private Room north;
    private Room east;
    private Room south;
    private Room west;

    public Room createRoom(String room) {
        switch(room) {
            case "Outside":
                return Outside.getInstance("outside the main entrance of the university");
            case "Office":
                return Office.getInstance("in the computing admin office");
            case "Lab":
                return Lab.getInstance("in a computing lab");
            case "Pub":
                return Pub.getInstance("in the campus pub");
            case "Theatre":
                return Theatre.getInstance("in a lecture theatre");
            default:
                break;
            }

            return null;
    }

    public void createExit(Room room, String exit, String content) {
        switch (exit) {
            case "northexit":
                north = createRoom(content);
                break;
            case "eastexit":
                east= createRoom(content);
                break;
            case "southexit":
                south = createRoom(content);
                break;
            case "westexit":
                west = createRoom(content);
                break;  
            default:
                break;
        }
    }
}
