public class CommandsReader {
    private UI console;
    private RoomDirectioner roomDirectioner;

    public CommandsReader(UI console, RoomDirectioner roomDirectioner){
        this.console = console;
        this.roomDirectioner = roomDirectioner;
    }

    public boolean proccessComand(Command command){
        boolean wantToQuit = false;

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

            default: 
                System.out.println("\nIngresaste un comando inválido. ¡Intenta de nuevo!\n");
                break;
        }
        return wantToQuit;
    }
}
