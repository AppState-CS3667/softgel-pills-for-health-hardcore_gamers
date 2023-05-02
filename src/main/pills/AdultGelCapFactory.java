package pills;

/*
 * AdultGelCapFactory class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public class AdultGelCapFactory extends GelCapFactory {

    private static AdultGelCapFactory instance;

    /*
     * Constructor for this singleton class
     */
    private AdultGelCapFactory() { }

    /*
     * Retrives the instance of AdultGelCapFactory(Singleton) or 
     * creates a new one of it does not exist.
     * 
     * @return instance - returns a singleton instance of 
     *                      AdultGelCapFacotry
     */
    public static AdultGelCapFactory getInstance() {
        if (instance == null) {
            synchronized (AdultGelCapFactory.class) {
                instance = new AdultGelCapFactory();
            }	
        }
        return instance;
    }

    /*
     * Returns a new Dreamly pill with specified casing, solution, active
     * 
     * @param casing - casing for the Dreamly pill
     * @param solution - solution for the Dreamly pill
     * @param active - active for the Dreamly pill
     * @return new AdultDreamly pill
     */
    protected Dreamly constructDreamly(String casing,
        String solution, String active) {
        System.out.print("Constructing adult version of Dreamly\n");
        return new AdultDreamly(casing, solution, active);
    }

    /*
     * Returns a new AcheAway pill with specified casing, solution, active
     * 
     * @param casing - casing for the AcheAway pill
     * @param solution - solution for the AcheAway pill
     * @param active - active for the AcheAway pill
     * @return new AdultAcheAway pill
     */
    protected AcheAway constructAcheAway(String casing, 
        String solution, String active) {
        System.out.print("Constructing adult version of AcheAway\n");
        return new AdultAcheAway(casing, solution, active);
    }

    /*
     * getter for Dreamly strength
     * 
     * @return strength of AdultDreamly pill
     */
    protected double getDreamlyStrength() {
        return AdultDreamly.STRENGTH;
    }

    /*
     * getter for AcheAway strength
     * 
     * @return strength of AdultAcheAway pill
     */
    protected double getAcheAwayStrength() {
        return AdultAcheAway.STRENGTH;
    }
}
