package pills;

/*
 * ChildDreamly class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
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
    
    /*
     * accept method
     * 
     * calls the inspect method on the inspector passed
     *
     * @param insp - an inspector object
     */
    public void accept(Inspector insp) {
        insp.inspect(this);
    }
}
