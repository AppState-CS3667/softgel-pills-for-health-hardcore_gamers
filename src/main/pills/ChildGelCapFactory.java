package pills;

/*
 * ChildGelCapFactory class.
 */
public class ChildGelCapFactory extends GelCapFactory {

    private static ChildGelCapFactory instance;

    /*
     * ChildGelCapFactory
     * 
     * Constructor for this singleton class
     */
    private ChildGelCapFactory() {

    }

    /*
     * getInstance
     * 
     * Retrives the instance of ChildGelCapFactory(Singleton) or 
     *  creates a new one of it does not exist.
     * 
     */
    public static ChildGelCapFactory getInstance() {
        if (instance == null) {
            synchronized (ChildGelCapFactory.class) {
                instance = new ChildGelCapFactory();
            }	
        }
        return instance;
    }

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
        System.out.print("Constructing child version of Dreamly\n");
        return new ChildDreamly(casing, solution, active);
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
        System.out.print("Constructing child version of AcheAway\n");
        return new ChildAcheAway(casing, solution, active);
    }

    /*
     * getter for Dreamly strength
     */
    protected double getDreamlyStrength() {
        return ChildDreamly.STRENGTH;
    }

    /*
     * getter for AcheAway strength
     */
    protected double getAcheAwayStrength() {
        return ChildAcheAway.STRENGTH;
    }
}
