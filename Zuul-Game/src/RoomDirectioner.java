import rooms.Room;

public class RoomDirectioner {
    private MainGame main;
    private UI console;
    public RoomDirectioner(UI console, MainGame main) {
        this.main = main;
        this.console = console;
    }

    public void goRoom(Command command){
        Room nextRoom = null;
        switch(command.getSecondWord()){
            case "norte":
                nextRoom = main.getCurrentRoom().northExit;
                break;
            case "sur":
                nextRoom = main.getCurrentRoom().southExit;
                break;

            case "este":
                nextRoom = main.getCurrentRoom().eastExit;
                break;

            case "oeste":
                nextRoom = main.getCurrentRoom().westExit;
                break;

            default: 
                System.out.println("¿Ir a donde?");
                break;
        }
        if (nextRoom != null) {
            main.setCurrentRoom(nextRoom);
            console.printLocation(main.getCurrentRoom());
        }else{
            System.out.println("There is no door!");
        }
    }
}
