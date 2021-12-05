public class UI {
    public void printWelcome()
    {
        System.out.println();
        System.out.println("¡Bienvenido al mundo de Zuul!");
        System.out.println("Este es un juego donde podrás explorar el increíble mundo de Zuul.");
        System.out.println("Escribe 'ayuda' si necesitas ayuda.");
        System.out.println();
    } 

    public void printLocation(Room currentRoom){
        System.out.println("\nTu ubicación actual es: " + currentRoom.getDescription());
        System.out.print("Salidas: ");
        if(currentRoom.northExit != null) {
            System.out.print("Norte ");
        }
        if(currentRoom.eastExit != null) {
            System.out.print("Este ");
        }
        if(currentRoom.southExit != null) {
            System.out.print("Sur ");
        }
        if(currentRoom.westExit != null) {
            System.out.print("Oeste ");
        }
        System.out.println("¿Hacia dónde quieres ir?");
    }

    public boolean quit(String word1, String word2) 
    {
        if(word2 != null) {
            System.out.println("Quizás quisiste decir: 'salir'\n");
            return false;
        }
        else {
            return true;
        }
    }

    public void printHelp() 
    {
        System.out.println("Estás perdido y solo....");
        System.out.println("Vagando por la universidad buscando una salida...");
        System.out.println("Recuerda que sólo puedes ir hacia los lugares indicados.\n");
        System.out.println("Tus comandos son los siguientes:");
        System.out.println("> ir -¿hacia qué lugar?-");
        System.out.println("> ayuda");
        System.out.println("> salir\n");
        System.out.println("Intenta con:\n>ir este\n");
    }
}
