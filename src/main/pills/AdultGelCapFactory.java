package pills;

/*
 * AdultGelCapFactory class.
 */
public class AdultGelCapFactory extends GelCapFactory {

    /*
     * constructDreamly method
     * 
     * returns a new Dreamly pill with specified casing, solution, active
     * 
     * @param casing casing for the Dreamly pill
     * @param solution solution for the Dreamly pill
     * @param active active for the Dreamly pill
     */
    protected Dreamly constructDreamly(String casing,
        String solution, String active) {
        System.out.print("Constructing adult version of Dreamly\n");
        return new AdultDreamly(casing, solution, active);
    }
    /*
     * constructAcheAway method
     * 
     * returns a new AcheAway pill with specified casing, solution, active
     * 
     * @param casing casing for the AcheAway pill
     * @param solution solution for the AcheAway pill
     * @param active active for the AcheAway pill
     */
    protected AcheAway constructAcheAway(String casing, 
        String solution, String active) {
        System.out.print("Constructing adult version of AcheAway\n");
        return new AdultAcheAway(casing, solution, active);
    }

    /*
     * getter for Dreamly strength
     */
    protected double getDreamlyStrength() {
        return AdultDreamly.STRENGTH;
    }

    /*
     * getter for AcheAway strength
     */
    protected double getAcheAwayStrength() {
        return AdultAcheAway.STRENGTH;
    }
}
