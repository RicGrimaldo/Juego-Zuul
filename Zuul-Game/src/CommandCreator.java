import java.util.Scanner;

public class CommandCreator {
    private Scanner scCommandWords;
    private static final String[] validCommands = {"ir", "salir", "ayuda"};

    public Command createCommand(String input){
        String commandWord = null;
        String secondWord = null;
        scCommandWords = new Scanner(input);

        if(scCommandWords.hasNext()) {
            commandWord = scCommandWords.next();
            if(scCommandWords.hasNext()) {
                secondWord = scCommandWords.next();
            }
        }
        
        if(isValidCommand(commandWord)) {
            return new Command(commandWord, secondWord);
        }
        else {
            return new Command(null, secondWord); 
        }
    }

    public boolean isValidCommand(String commandWord){
        
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(commandWord))
                return true;
        }
        return false;
    }
}
