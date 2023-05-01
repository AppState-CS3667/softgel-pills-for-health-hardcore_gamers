package pills;

/*
 * Dreamly class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public abstract class Dreamly extends GelCap {
    
    public static final Dreamly NULL = null;
    
    /*
     * Constructor for class Dreamly that calls the 
     * super constructor of the GelCap class.
     *
     * @param strength pill strength
	 * @param size pill size
	 * @param color pill color
	 * @param casing pill casing
	 * @param solution pill solution
	 * @param active pill active
     */
    public Dreamly(double strength, double size, String color, String casing, 
        String solution, String active) {

        super("Dreamly", strength, size, color, casing, solution, active);
    }
}
