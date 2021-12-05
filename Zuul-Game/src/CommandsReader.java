public class CommandsReader {
    private UI console;

    public CommandsReader(UI console){
        this.console = console;
    }

    public boolean proccessComand(Command command){
        boolean wantToQuit = false;

        switch(command.getCommandWord()){
            case "ir":
                //  Código que dirije hacia dónde ir
                break;
            case "salir":
                wantToQuit = console.quit(command);
                break;

            case "ayuda":
                console.printHelp();
                break;

            default: 
                System.out.println("\nIngresaste un comando inválido. ¡Intenta de nuevo!\n");
                return false;
        }
        return wantToQuit;
    }
}
