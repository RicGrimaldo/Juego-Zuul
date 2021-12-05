import java.util.Scanner;

import rooms.Room;
public class MainGame {
    private Room currentRoom;
    private UI console;
    String commandInput;
    Scanner scannerInput;
    private CommandCreator commandCreator;
    private CommandsReader checker;
    
    public MainGame(){
        createRooms();
        console = new UI();
        commandCreator = new CommandCreator();
        checker = new CommandsReader(console);
        scannerInput = new Scanner(System.in);
    }

    private void createRooms(){   
        currentRoom = new ConfigFileReader().getFirstRoom();
    }

    public void play(){
        console.printWelcome();
        boolean finished = false;
        while (! finished) {
            console.printLocation(currentRoom);
            System.out.print("> ");
            commandInput = scannerInput.nextLine();
            Command command = commandCreator.createCommand(commandInput);
            finished = checker.proccessComand(command);
        }
        System.out.println("¡Hasta pronto!");
    }
}
