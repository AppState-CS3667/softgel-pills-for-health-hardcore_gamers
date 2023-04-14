package pills;


/*
 * GelCap Class -
 * hardcore_gamers
 */
public abstract class GelCap {
    protected String name;
    protected double strength;
    protected double size;
    protected String color;
    protected String casing;
    protected String solution;
    protected String active;

    /*
     * GelCap Constructor
     * 
     * Parameters:
     * @param = pill name
     * @param strength = pill strength
     * @param size = pill size
     * @param color = pill color
     */

    public GelCap(String name, double strength, double size, String color, 
        String casing, String solution, String active) {

        this.name = name;
        this.strength = strength;
        this.size = size;
        this.color = color;
        this.casing = casing;
        this.solution = solution;
        this.active = active;
    }

    /*
     * toString method
     * 
     * return the strength and name of the pill.
     */
    @Override
    public String toString() {
        return String.format("%.2fmg %S pill", strength, name);
    }
    /*
     * description method
     * 
     * returns a string of every attribute of the pill.
     */
    public String description() {
        return String.format("%S Pill\n\tStrength: %.2f\n\tSize: %.2f"
            + "\n\tColor: %S\n\tCasing: %S\n\tSolution: %S\n\tActive: %S",
            name, strength, size, color, casing, solution, active);
    }

    /*
     * getName method
     * 
     * returns the pill's name.
     */
    public String getName() {
        return name;
    }

    /*
     * getStrength method
     * 
     * returns the pill's strength.
     */
    public double getStrength() {
        return strength;
    }

    /*
     * getSize method
     * 
     * returns the pill's size.
     */
    public double getSize() {
        return size;
    }

    /*
     * getColor method
     * 
     * returns the pill's color.
     */
    public String getColor() {
        return color;
    }

    /*
     * getCasing method
     * 
     * returns the pill's casing material.
     */
    public String getCasing() {
        return casing;
    }

    /*
     * getSolution method
     * 
     * returns the pill's solution.
     */
    public String getSolution() {
        return solution;
    }

    /*
     * getActive method
     * 
     * returns the pill's active ingredient.
     */
    public String getActive() {
        return active;
    }

    /*
     * accept method
     * 
     * calls the inspect method on the inspector passed
     *
     * @param insp - an inspector object
     */
    abstract void accept(Inspector insp);
}
