package pills;

/*
 * AdultAcheAway class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public class AdultAcheAway extends AcheAway {
    public static final double STRENGTH = 825.00;
    public static final double SIZE = 8.50;
    public static final String COLOR = "white";
    
    /*
     * Constructor for AdultAcheAway class that calls the super constructor.
     */
    public AdultAcheAway(String casing, String solution, String active) {
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
