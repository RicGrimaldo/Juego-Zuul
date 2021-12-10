package rooms;
public class Outside extends Room {

    private static Outside outside;

    private Outside(String description) {
        super(description);
    }

    public static Outside getInstance(String description) {
        if (outside == null) {
            outside = new Outside(description);
        }

        return outside;
    }
}
