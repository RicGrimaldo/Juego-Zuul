import rooms.Room;
public class MainGame {
    private Room currentRoom;
    private CommandsReader checker;
    private UI console;

    public MainGame(){
        createRooms();
    }

    private void createRooms()
    {   
        console = new UI();
        currentRoom = new ConfigFileReader().getFirstRoom();
        checker = new CommandsReader(console);
    }

    public void play(){
        String word1 = null;
        String word2 = null;
        console.printWelcome();
        boolean finished = false;

        while (! finished) {
            console.printLocation(currentRoom);
            System.out.print("> ");
            // Implementación del parser
            finished = checker.proccessComand(word1, word2);
        }
        System.out.println("¡Hasta pronto!");
    }
}
