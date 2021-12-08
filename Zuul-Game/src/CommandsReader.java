public class CommandsReader {
    private UI consolePrints;
    private RoomDirectioner roomDirectioner;

    public CommandsReader(UI console, RoomDirectioner roomDirectioner){
        this.consolePrints = console;
        this.roomDirectioner = roomDirectioner;
    }

    public boolean proccessCommandWord(Command command) {
        boolean wantToQuit = false;
        if(command.isUnknown()){
            System.out.println("\nIngresaste un comando inv\u00e1lido. ¡Intenta de nuevo!\n");
            return false;
        }
        
        switch(command.getCommandWord()){
            case "ir":
                roomDirectioner.goRoom(command);
                break;
            case "salir":
                wantToQuit = consolePrints.quit(command);
                break;

            case "ayuda":
                consolePrints.printHelp();
                break;
        }
        return wantToQuit;
    }
}
