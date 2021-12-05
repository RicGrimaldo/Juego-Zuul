public class CommandsReader {
    private UI console;

    public CommandsReader(UI console){
        this.console = console;
    }

    public boolean proccessComand(String word1, String word2){
        boolean wantToQuit = false;

        switch(word1){
            case "ir":
                //  Código que dirije hacia dónde ir
                break;
            case "salir":
                wantToQuit = console.quit(word1, word2);
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
