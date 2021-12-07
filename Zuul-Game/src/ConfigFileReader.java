import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import rooms.*;

public class ConfigFileReader {
    private RoomCreator roomCreator = new RoomCreator();
    List<Room> rooms = new ArrayList<>();
    
    
    private void readConfigFile() throws Exception {
        try {
            File archivoXml = new File("src/config.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbFactory.newDocumentBuilder();
            Document documentoXml = builder.parse(archivoXml);
            if (verifyTags(documentoXml)) {
                NodeList roomsX = documentoXml.getElementsByTagName("room");
                for(int i = 0; i < roomsX.getLength(); i++) {
                    Node nodo = roomsX.item(i);
                    Element element = (Element) nodo;
                    Room room = createRoom(element.getAttribute("id"));// Crea el cuarto principal
                    room = setRoomExits(room, nodo);
                    rooms.add(room);
                } 
            } else {
                throw new Exception("Hay alguna etiqueta incorrecta");
            }
        }catch(ParserConfigurationException e1){
            e1.printStackTrace();
        }catch(SAXException e2){
            e2.printStackTrace();
        }catch(IOException e3){
            e3.printStackTrace();
        }
    }


    private boolean verifyTags(Document document) {
        NodeList tags = document.getElementsByTagName("*");
        for(int i=0;i<tags.getLength();i++){
            if (!isTagCorrect(tags.item(i).getNodeName())) {
                return false;
            }
        }

        return true;
    }


    private boolean isTagCorrect(String tag) {
        if (tag.equals("root") || tag.equals("room") || tag.equals("northexit") || tag.equals("eastexit") || tag.equals("southexit") || tag.equals("westexit")) {
            return true;
        }

        return false;
    }

    public Room getFirstRoom() throws Exception {
        readConfigFile();
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

    @Test
    /**
     * Método para verificar si la función que verifica las etiquetas funciona correctamente cuando estas son incorrectas
     */
    public void TestTagsAreIncorrect() {
        assertTrue("La etiqueta es incorrecta", isTagCorrect("roots"));
    }

    @Test
    /**
     * Método para verificar si la función que verifica las etiquetas funciona correctamente cuando estas son correctas
     */
    public void TestTagsAreCorrect() {
        assertTrue("La etiqueta es correcta", isTagCorrect("root"));
    }


 
}
