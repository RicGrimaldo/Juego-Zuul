package rooms;
public class Office extends Room {
    private static Office office;

    private Office(String description) {
        super(description);
    }

    public static Office getInstance(String description) {
        if (office == null) {
            office = new Office(description);
        }

        return office;
    }
    
}
