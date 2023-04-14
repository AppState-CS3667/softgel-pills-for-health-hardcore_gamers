package pills;

public class ChildAcheAway extends AcheAway {
    public static final double STRENGTH = 415.00;
    public static final double SIZE = 3.25;
    public static final String COLOR = "cyan";
    
    /*
     * Constructor for ChildAcheAway class that calls the super constructor.
     */
    public ChildAcheAway(String casing, String solution, String active) {
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
