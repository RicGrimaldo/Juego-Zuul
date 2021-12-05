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
        commandCreator = new CommandCreator();
        scannerInput = new Scanner(System.in);
    }

    private void createRooms(){   
        console = new UI();
        currentRoom = new ConfigFileReader().getFirstRoom();
        checker = new CommandsReader(console);
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
}
