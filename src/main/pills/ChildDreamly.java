package pills;

public class ChildDreamly extends Dreamly {
    double final STRENGTH;
    double final SIZE;
    String final COLOR;
    
    /*
     * Constructor for ChildDreamly class that calls the super constructor.
     */
    public ChildDreamly(String casing, String solution, String active) {
        super("Dreamly", strength, size, color, casing, solution, active);
    }
}
