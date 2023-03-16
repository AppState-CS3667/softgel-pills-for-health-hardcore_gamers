package pills;

public class ChildAcheAway extends AcheAway{
    public double final STRENGTH = 415.00;
    public double final SIZE = 3.25;
    public String final COLOR = "cyan";
    
    /*
     * Constructor for ChildAcheAway class that calls the super constructor.
     */
    public ChildAcheAway(String casing, String solution, String active) {
        super("ChildAcheAway", strength, size, color, casing, solution, active);
    }
}
