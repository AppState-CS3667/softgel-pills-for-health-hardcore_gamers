package pills;

public abstract class AcheAway extends GelCap {

	public static final AcheAway NULL = null;

	/*
	 * Constructor for the AcheAway class that calls the GelCaps constructor.
	 * 
	 * @param strength pill strength
	 * 
	 * @param size pill size
	 * 
	 * @param color pill color
	 * 
	 * @param casing pill casing
	 * 
	 * @param solution pill solution
	 * 
	 * @param active pill active
	 */
    public AcheAway(double strength, double size, String color,
	                String casing, String solution, String active) {
        super("AcheAway", strength, size, color, casing, solution, active); 
    }
}
