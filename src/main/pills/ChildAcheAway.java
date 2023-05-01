package pills;

/*
 * ChildAcheAway class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public class ChildAcheAway extends AcheAway {
    public static final double STRENGTH = 415.00;
    public static final double SIZE = 3.25;
    public static final String COLOR = "cyan";
    
    /*
     * Constructor for ChildAcheAway class that calls the super constructor.
     * 
     * @param casing pill casing
	 * 
	 * @param solution pill solution
	 * 
	 * @param active pill active
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
