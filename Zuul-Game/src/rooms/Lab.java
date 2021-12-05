package rooms;
public class Lab extends Room {
    private static Lab lab;

    private Lab(String description) {
        super(description);
    }

    public static Lab getInstance(String description) {
        if (lab == null) {
            lab = new Lab(description);
        }

        return lab;
    }
    
}
