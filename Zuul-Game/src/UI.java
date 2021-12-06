import rooms.Room;
public class UI {
    //  Clase donde hace todas las impresiones necesarias
    
    public void printWelcome()
    {
        System.out.println();
        System.out.println("¡Bienvenido al mundo de Zuul!");
        System.out.println("Este es un juego donde podr\u00e1s explorar el incre\u00edble mundo de Zuul.");
        System.out.println("Escribe 'ayuda' si necesitas ayuda.");
        System.out.println();
    } 

    public void printLocation(Room currentRoom){
        System.out.println("\nTu ubicaci\u00f3n actual es: " + currentRoom.getDescription());
        System.out.print("Salidas: ");
        if(currentRoom.getNorthExit() != null) {
            System.out.print("norte ");
        }
        if(currentRoom.getEastExit() != null) {
            System.out.print("este ");
        }
        if(currentRoom.getSouthExit() != null) {
            System.out.print("sur ");
        }
        if(currentRoom.getWestExit() != null) {
            System.out.print("oeste ");
        }
        System.out.println("¿Hacia d\u00f3nde quieres ir?");
    }

    public boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quiz\u00e1s quisiste decir: 'salir'\n");
            return false;
        }
        else {
            return true;
        }
    }

    public void printHelp() 
    {
        System.out.println("Est\u00e1s perdido y solo....");
        System.out.println("Vagando por la universidad buscando una salida...");
        System.out.println("Recuerda que s\u00f3lo puedes ir hacia los lugares indicados.\n");
        System.out.println("Tus comandos son los siguientes:");
        System.out.println("> ir -¿hacia qu\u00e9 lugar?-");
        System.out.println("> ayuda");
        System.out.println("> salir\n");
        System.out.println("Intenta con:\n>ir este\n");
    }
}
