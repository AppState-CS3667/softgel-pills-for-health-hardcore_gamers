package pills;

public class AdultDreamly extends Dreamly {
    public static final double STRENGTH = 5.2;
    public static final double SIZE = 12.24;
    public static final String COLOR = "tan";
    
    /*
     * Constructor for AdultDreamly class that calls the super constructor.
     */
    public AdultDreamly(String casing, String solution, String active) {
        super(STRENGTH, SIZE, COLOR, casing, solution, active);
    }
    public void accept(Inspector insp) {
        insp.inspect(this);
    }
}
