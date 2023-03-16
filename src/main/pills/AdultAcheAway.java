package pills;

public class AdultAcheAway extends AcheAway {
    public double final STRENGTH = 825.00;
    public double final SIZE = 8.50;
    public String final COLOR = "white";
    
    /*
     * Constructor for AdultAcheAway class that calls the super constructor.
     */
    public AdultAcheAway(String casing, String solution, String active) {
        super("AdultAcheAway", strength, size, color, casing, solution, active);
    }
}