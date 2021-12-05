import rooms.Room;

public class RoomDirectioner {
    private MainGame main;
    public RoomDirectioner(MainGame main) {
        this.main = main;
    }

    public void goRoom(Command command){
        Room nextRoom = null;
        switch(command.getSecondWord()){
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

            default: 
                System.out.println("¿Ir a donde?");
                break;
        }
        if (nextRoom != null) {
            main.setCurrentRoom(nextRoom);
        }else{
            System.out.println("¡No hay salida por ahí!");
        }
    }
}
