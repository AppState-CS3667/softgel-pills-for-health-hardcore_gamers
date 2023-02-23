package pills;

public class AcheAway extends GelCap {
	/*
	 * Constructor for the AcheAway class that calls the GelCaps constructor.
	 * 
	 * @param strength pill strength
	 * 
	 * @param size pill size
	 * 
	 * @param color pill color
	 */
    public AcheAway(double strength, double size, String color) {
        super("AcheAway", strength, size, color); 
		// calls the GelCaps constructor
    }

	/*
	 * Makes the casing for the pill.
	 */
    protected void addCasing() {
        casing = "gelatin";
        System.out.print("adding " + getCasing() + " casing\n");
    }

	/*
	 * Inserts the pill solution into the casing.
	 */
    protected void addSolution() {
        solution = "saline";
        System.out.print("adding " + getSolution() + " solution\n");
    }

	/*
	 * Inserts the active ingredient into the casing.
	 */
    protected void addActive() {
        active = "acetaminophen";
        System.out.print("adding " + getActive() + " active\n");
    }
}
