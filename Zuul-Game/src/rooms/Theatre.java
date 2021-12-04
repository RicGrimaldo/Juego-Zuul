package rooms;
public class Theatre extends Room {
    private static Theatre theatre;

    private Theatre(String description) {
        super(description);
        //TODO Auto-generated constructor stub
    }

    public static Theatre getInstance(String description) {
        if (theatre == null) {
            theatre = new Theatre(description);
        }

        return theatre;
    }
    
}
