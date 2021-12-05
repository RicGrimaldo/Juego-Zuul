public class CommandsReader {


    public boolean proccessComand(String word1, String word2){
        boolean wantToQuit = false;

        switch(word1){
            case "ir":
                //  Código que dirije hacia dónde ir
                break;
            case "salir":
                
                break;

            case "ayuda":
                
                break;

            default: 
                System.out.println("\nIngresaste un comando inválido. ¡Intenta de nuevo!\n");
                return false;
        }

        return wantToQuit;
    }
}
