package pills;

public abstract class Dreamly extends GelCap {
    /*
     * Constructor for class Dreamly that calls the 
     * super constructor of the GelCap class.
     *
     * @param strength. Pill strength.
     * @param size. Pill size. 
     * @param strength. Pill color. 
     *
     */
    public Dreamly(double strength, double size, 
        String color, String casing, String solution, String active) {
        super("Dreamly", strength, size, color, casing, solution, active);
    }
}
