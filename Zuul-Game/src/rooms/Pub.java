package rooms;
public class Pub extends Room{
    private static Pub pub;

    private Pub(String description) {
        super(description);
        //TODO Auto-generated constructor stub
    }

    public static Pub getInstance(String description) {
        if (pub == null) {
            pub = new Pub(description);
        }

        return pub;
    }
    
}
