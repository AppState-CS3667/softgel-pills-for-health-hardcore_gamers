package pills;

public class AdultDreamly extends Dreamly {
    double final STRENGTH = 5.2;
    double final SIZE = 12.24;
    String final COLOR = "tan";
    
    /*
     * Constructor for AdultDreamly class that calls the super constructor.
     */
    public AdultDreamly(String casing, String solution, String active) {
        super("AdultDreamly", strength, size, color, casing, solution, active);
    }
}
