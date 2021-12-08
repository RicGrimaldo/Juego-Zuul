import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import rooms.Outside;
import rooms.Room;

public class RoomDirectioner {
    private MainGame main;

    public void setMainGame(MainGame main) {
        this.main = main;
    }

    public void goRoom(Command command) {
        Room nextRoom = null;

        if (!command.hasSecondWord()){
            System.out.println("¿Ir a d\u00f3nde?");
            return;
        }
        
        nextRoom = setNextRoom(command.getSecondWord());

        if (nextRoom != null) {
            main.setCurrentRoom(nextRoom);
        }else{
            System.out.println("¡No hay salida por ah\u00ed!");
        }
    }

    private Room setNextRoom(String secondWord) {
        Room nextRoom = null;
        switch(secondWord){
            case "norte":
                nextRoom = main.getCurrentRoom().getNorthExit();
                break;

            case "sur":
                nextRoom = main.getCurrentRoom().getSouthExit();
                break;

            case "este":
                nextRoom = main.getCurrentRoom().getEastExit();
                break;

            case "oeste":
                nextRoom = main.getCurrentRoom().getWestExit();
                break;
        }

        return nextRoom;
    }

    @Test
    /**
     * Test para verificar que el cambio de cuarto al norte es correcto
     * @throws Exception
     */
    public void TestSetNextRoom_North() throws Exception {
        MainGame main = new MainGame();
        main.setCurrentRoom(Outside.getInstance("fuera de la entrada principal de la universidad"));
        this.setMainGame(main);
        Room nextRoom = main.getCurrentRoom().getNorthExit();
        assertEquals(nextRoom, setNextRoom("norte"));
    }

    @Test
    /**
     * Test para verificar que el cambio de cuarto al este es correcto
     * @throws Exception
     */
    public void TestSetNextRoom_East() throws Exception {
        MainGame main = new MainGame();
        main.setCurrentRoom(Outside.getInstance("fuera de la entrada principal de la universidad"));
        this.setMainGame(main);
        Room nextRoom = main.getCurrentRoom().getEastExit();
        assertEquals(nextRoom, setNextRoom("este"));
    }

    @Test
    /**
     * Test para verificar que el cambio de cuarto al sur es correcto
     * @throws Exception
     */
    public void TestSetNextRoom_South() throws Exception {
        MainGame main = new MainGame();
        main.setCurrentRoom(Outside.getInstance("fuera de la entrada principal de la universidad"));
        this.setMainGame(main);
        Room nextRoom = main.getCurrentRoom().getSouthExit();
        assertEquals(nextRoom, setNextRoom("sur"));
    }

    @Test
    /**
     * Test para verificar que el cambio de cuarto al oeste es correcto
     * @throws Exception
     */
    public void TestSetNextRoom_West() throws Exception {
        MainGame main = new MainGame();
        main.setCurrentRoom(Outside.getInstance("fuera de la entrada principal de la universidad"));
        this.setMainGame(main);
        Room nextRoom = main.getCurrentRoom().getWestExit();
        assertEquals(nextRoom, setNextRoom("oeste"));
    }
}
