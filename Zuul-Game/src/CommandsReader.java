public class CommandsReader {
    private UI console;
    private RoomDirectioner roomDirectioner;

    public CommandsReader(UI console, RoomDirectioner roomDirectioner){
        this.console = console;
        this.roomDirectioner = roomDirectioner;
    }

    public boolean proccessComand(Command command){
        boolean wantToQuit = false;
        if(command.isUnknown()){
            System.out.println("\nIngresaste un comando inválido. ¡Intenta de nuevo!\n");
            return false;
        }
        
        switch(command.getCommandWord()){
            case "ir":
                roomDirectioner.goRoom(command);
                break;
            case "salir":
                wantToQuit = console.quit(command);
                break;

            case "ayuda":
                console.printHelp();
                break;
        }
        return wantToQuit;
    }
}
