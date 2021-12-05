import java.util.Scanner;

public class CommandCreator {
    private Scanner scCommandWords;

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
        return new Command(commandWord, secondWord);
    }
}
