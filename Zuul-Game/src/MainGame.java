import java.util.Scanner;

import rooms.Room;
public class MainGame {
    private Room currentRoom;
    private UI console;
    String commandInput;
    Scanner scannerInput;
    private CommandCreator commandCreator;
    private CommandsReader checker;
    private RoomDirectioner roomDirectioner;
    
    public MainGame(){
        createRooms();
        commandCreator = new CommandCreator();
        scannerInput = new Scanner(System.in);
        console = new UI();
        roomDirectioner = new RoomDirectioner(console,this);
        checker = new CommandsReader(console, roomDirectioner);
    }

    private void createRooms(){   
        currentRoom = new ConfigFileReader().getFirstRoom();
    }

    public void play(){
        console.printWelcome();
        boolean finished = false;
        while (! finished) {
            finished = getCommand();
        }
        System.out.println("¡Hasta pronto!");
    }

    private boolean getCommand(){
        console.printLocation(currentRoom);
        System.out.print("> ");
        commandInput = scannerInput.nextLine();
        Command command = commandCreator.createCommand(commandInput);
        return checker.proccessComand(command);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
