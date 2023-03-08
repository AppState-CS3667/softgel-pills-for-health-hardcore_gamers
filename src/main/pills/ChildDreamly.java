package pills;

public class ChildDreamly extends Dreamly {
    final double STRENGTH = 1.25;
    final double SIZE = 4.5;
    final String COLOR = "fuchsia";
    
    /*
     * Constructor for ChildDreamly class that calls the super constructor.
     */
    public ChildDreamly(String casing, String solution, String active) {
        super("ChildDreamly", strength, size, color, casing, solution, active);
    }
}
