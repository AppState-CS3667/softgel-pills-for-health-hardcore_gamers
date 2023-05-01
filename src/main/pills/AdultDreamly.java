package pills;

/*
 * AdultDreamly class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public class AdultDreamly extends Dreamly {
    public static final double STRENGTH = 5.2;
    public static final double SIZE = 12.24;
    public static final String COLOR = "tan";
    
    /*
     * Constructor for AdultDreamly class that calls the super constructor.
     * 
     * @param casing pill casing
	 * @param solution pill solution
	 * @param active pill active
     */
    public AdultDreamly(String casing, String solution, String active) {
        super(STRENGTH, SIZE, COLOR, casing, solution, active);
    }

    /*
     * Calls the inspect method on the inspector passed
     *
     * @param insp - an inspector object
     */
    public void accept(Inspector insp) {
        insp.inspect(this);
    }
}
