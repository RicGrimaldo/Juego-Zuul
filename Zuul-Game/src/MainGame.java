import java.util.Scanner;

import rooms.Room;
public class MainGame {
    private Room currentRoom;
    private UI consolePrints;
    private String commandInput;
    private Scanner scannerInput;
    private CommandCreator commandCreator;
    private CommandsReader checkerCommandWord;
    private RoomDirectioner roomDirectioner;
    
    public MainGame() throws Exception{
        createRooms();
        commandCreator = new CommandCreator();
        scannerInput = new Scanner(System.in);
        consolePrints = new UI();
        roomDirectioner = new RoomDirectioner();
        roomDirectioner.setMainGame(this);
        checkerCommandWord = new CommandsReader(consolePrints, roomDirectioner);
    }

    private void createRooms() throws Exception{   
        currentRoom = new ConfigFileReader().getFirstRoom();
    }

    public void play(){
        consolePrints.printWelcome();
        boolean finished = false;
        while (! finished) {
            finished = getCommand();
        }
        System.out.println("¡Hasta pronto!");
    }

    private boolean getCommand(){
        consolePrints.printLocation(currentRoom);
        System.out.print("> ");
        commandInput = scannerInput.nextLine();
        Command command = commandCreator.createCommand(commandInput);
        return checkerCommandWord.proccessCommandWord(command);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
