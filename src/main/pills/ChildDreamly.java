package pills;

/*
 * GelCap Class -
 * hardcore_gamers
 */
public class ChildDreamly extends Dreamly {
    public static final double STRENGTH = 1.25;
    public static final double SIZE = 4.5;
    public static final String COLOR = "fuchsia";
    
    /*
     * Constructor for ChildDreamly class that calls the super constructor.
     */
    public ChildDreamly(String casing, String solution, String active) {
        super(STRENGTH, SIZE, COLOR, casing, solution, active);
    }
    public void accept(Inspector insp) {
        insp.inspect(this);
    }
}
