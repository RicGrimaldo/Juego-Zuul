import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import rooms.*;

public class ConfigFileReader {
    private RoomCreator roomCreator = new RoomCreator();
    List<Room> rooms = new ArrayList<>();

    private  void readConfigFile() {
        
        try {
            File archivoXml = new File("room.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbFactory.newDocumentBuilder();
            Document documentoXml = builder.parse(archivoXml);
            NodeList roomsX = documentoXml.getElementsByTagName("room");
            for (int i = 0; i < roomsX.getLength(); i++) {
                Node nodo = roomsX.item(i);
                Element element = (Element) nodo;
                Room room = createRoom(element.getAttribute("id"));// Crea el cuarto principal
                room = setRoomExits(room, nodo);
                rooms.add(room);
            }
            //checkAllRooms();
        } catch(Exception ex) {

        }
    }


    public Room getFirstRoom() {
        readConfigFile();
        System.out.println(rooms);
        return rooms.get(0);
    }

    public Room setRoomExits(Room room, Node nodo){
        NodeList salidas = nodo.getChildNodes();
            for (int j = 0; j < salidas.getLength(); j++) {
                String exitName = salidas.item(j).getNodeName();
                String content = salidas.item(j).getTextContent();
                createExit(room, exitName, content);
            }
        return room;
    }

    private Room createRoom(String room) {
        return roomCreator.createRoom(room);
    }

    private void createExit(Room room, String exit, String content) {
        roomCreator.createExit(room, exit, content);
    }

    /*private void checkAllRooms() {
        for (Room room : rooms) {
            System.out.println("Cuarto: " + room.getDescription());
            System.out.println("Salida al norte: " + room.northExit);
            System.out.println("Salida al este: " + room.eastExit);
            System.out.println("Salida al sur: " + room.southExit);
            System.out.println("Salida al oeste: " + room.westExit);
        }
    }*/
}
