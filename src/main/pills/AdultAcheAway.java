package pills;

public class AdultAcheAway extends AcheAway {
    public static final double STRENGTH = 825.00;
    public static final double SIZE = 8.50;
    public static final String COLOR = "white";
    
    /*
     * Constructor for AdultAcheAway class that calls the super constructor.
     */
    public AdultAcheAway(String casing, String solution, String active) {
        super("AdultAcheAway", strength, size, color, casing, solution, active);
    }
}
