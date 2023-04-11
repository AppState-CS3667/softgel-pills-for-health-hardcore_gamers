package pills;

public class ChildGelCapFactory extends GelCapFactory {

    private static ChildGelCapFactory instance;

    /*
     * ChildGelCapFactory
     * 
     * Constructor for this singleton class
     */
    private ChildGelCapFactory() {}

    /*
     * getInstance
     * 
     * Retrives the instance of ChildGelCapFactory(Singleton) or 
     *  creates a new one of it does not exist.
     * 
     */
    public static ChildGelCapFactory getInstance() {
        if (instance == null) {
            synchronized(ChildGelCapFactory.class) {
                instance = new ChildGelCapFactory();
            }	
        }
        return instance;
    }

    protected Dreamly constructDreamly(String casing,
        String solution, String active) {
        System.out.print("Constructing child version of Dreamly\n");
        return new ChildDreamly(casing, solution, active);
    }

    protected AcheAway constructAcheAway(String casing, 
        String solution, String active) {
        System.out.print("Constructing child version of AcheAway\n");
        return new ChildAcheAway(casing, solution, active);
    }

    protected double getDreamlyStrength() {
        return ChildDreamly.STRENGTH;
    }

    protected double getAcheAwayStrength() {
        return ChildAcheAway.STRENGTH;
    }
}
