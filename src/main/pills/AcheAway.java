package pills;

public abstract class AcheAway extends GelCap {
	/*
	 * Constructor for the AcheAway class that calls the GelCaps constructor.
	 * 
	 * @param strength pill strength
	 * 
	 * @param size pill size
	 * 
	 * @param color pill color
	 */
    public AcheAway(double strength, double size, String color,
	                String casing, String solution, String active) {
        super("AcheAway", strength, size, color, casing, solution, active); 
		// calls the GelCaps constructor
    }
}
