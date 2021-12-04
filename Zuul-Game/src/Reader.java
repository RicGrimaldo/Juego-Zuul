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

public class Reader {
    private RoomCreator roomCreator = new RoomCreator();
    private Room north;
    private Room east;
    private Room south;
    private Room west;
    List<Room> rooms = new ArrayList<>();

    private  void readFile() {
        
        try {
            File archivoXml = new File("room.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbFactory.newDocumentBuilder();
            Document documentoXml = builder.parse(archivoXml);
            NodeList roomsX = documentoXml.getElementsByTagName("room");
            for (int i = 0; i < roomsX.getLength(); i++) {
                Node nodo = roomsX.item(i);
                Element element = (Element) nodo;
                // Crea el cuarto principal
                Room room = createRoom(element.getAttribute("id"));
                
                // Salidas de cada cuarto
                NodeList salidas = nodo.getChildNodes();
                for (int j = 0; j < salidas.getLength(); j++) {
                    String exitName = salidas.item(j).getNodeName();
                    String content = salidas.item(j).getTextContent();
                    createExit(exitName, content);
                }

                room.setExits(north, east, south, west);
                rooms.add(room);
            }


            //checkAllRooms();


        } catch(Exception ex) {

        }
    }


    public Room getFirstRoom() {
        readFile();
        return rooms.get(0);
    }


    private void checkAllRooms() {
        for (Room room : rooms) {
            System.out.println("Cuarto: " + room.getDescription());
            System.out.println("Salida al norte: " + room.northExit);
            System.out.println("Salida al este: " + room.eastExit);
            System.out.println("Salida al sur: " + room.southExit);
            System.out.println("Salida al oeste: " + room.westExit);
        }
    }


    private Room createRoom(String room) {

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

    private void createExit(String exit, String content) {
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
