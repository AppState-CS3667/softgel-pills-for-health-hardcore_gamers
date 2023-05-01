package pills;

/*
 * StrengthInspector class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public class StrengthInspector extends Inspector {
    
    double dreamlyStrength;
    double acheAwayStrength;

    /*
     * Reports the current status of the inspector
     */
    @Override
    public String report() {
        return "The total Dreamly strength is: " + dreamlyStrength + ".\n" 
            + "The total AcheAway strength is: " + acheAwayStrength + ".\n";
    }

    /*
     * Resets the inspector's accumulator variables to 0
     */
    @Override
    public void reset() {
        //need to call first to initialize variables
        dreamlyStrength = 0;
        acheAwayStrength = 0;
    }

    /*
     * Adds the adult acheaway strength to the total
     * 
     * @params e - an AdultAcheAway pill
     */
    public void inspect(AdultAcheAway e) {
        acheAwayStrength += e.getStrength();
    }

    /*
     * Adds the child acheaway strength to the total
     * 
     * @params e - a ChildAcheAway pill
     */
    public void inspect(ChildAcheAway e) {
        acheAwayStrength += e.getStrength();
    }

    /*
     * Adds the adult dreamly strength to the total
     * 
     * @params e - an AdultDreamly pill
     */
    public void inspect(AdultDreamly e) {
        dreamlyStrength += e.getStrength();
    }

    /*
     * Adds the child dreamly strength to the total
     * 
     * @params e - a ChildDreamly pill
     */
    public void inspect(ChildDreamly e) {
        dreamlyStrength += e.getStrength();
    }

    /*
     * Returns the current total of all dreamly pills in the order
     */
    public double getDreamlyStrength() {
        return dreamlyStrength;
    }

    /*
     * Returns the current total of all acheaway pills in the order
     */
    public double getAcheAwayStrength() {
        return acheAwayStrength;
    }
}
