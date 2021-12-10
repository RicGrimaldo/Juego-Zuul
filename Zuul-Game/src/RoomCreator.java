import rooms.Lab;
import rooms.Office;
import rooms.Outside;
import rooms.Pub;
import rooms.Room;
import rooms.Theatre;

public class RoomCreator {
    public Room createRoom(String room) {
        switch(room) {
            case "Outside":
                return Outside.getInstance("fuera de la entrada principal de la universidad");
            case "Office":
                return Office.getInstance("en la oficina del administrador de computaci\u00f3n");
            case "Lab":
                return Lab.getInstance("en el laboratorio de computaci\u00f3n");
            case "Pub":
                return Pub.getInstance("en el pub del campus");
            case "Theatre":
                return Theatre.getInstance("en una sala de conferencias");
            default:
                break;
            }

            return null;
    }

    public void createExit(Room room, String exit, String content) {
        switch (exit) {
            case "northexit":
                room.setNorthExit(createRoom(content));
                //north = createRoom(content);
                break;
            case "eastexit":
                room.setEastExit(createRoom(content));
                //east= createRoom(content);
                break;
            case "southexit":
                room.setSouthExit(createRoom(content));
                //south = createRoom(content);
                break;
            case "westexit":
                room.setWestExit(createRoom(content));
                //west = createRoom(content);
                break;  
            default:
                break;
        }
    }
}
