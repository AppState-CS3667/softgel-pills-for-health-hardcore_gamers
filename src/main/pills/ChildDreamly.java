package pills;

public class ChildDreamly extends Dreamly {
    double final STRENGTH = 1.25;
    double final SIZE = 4.5;
    String final COLOR = "fuchsia";
    
    /*
     * Constructor for ChildDreamly class that calls the super constructor.
     */
    public ChildDreamly(String casing, String solution, String active) {
        super("ChildDreamly", strength, size, color, casing, solution, active);
    }
}
