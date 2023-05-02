package pills;

/*
 * GelCap class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
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
     * @param strength pill strength
	 * @param size pill size
	 * @param color pill color
	 * @param casing pill casing
	 * @param solution pill solution
	 * @param active pill active
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
     * return the strength and name of the pill.
     * 
     * @return pills strength and name
     */
    @Override
    public String toString() {
        return String.format("%.2fmg %S pill", strength, name);
    }

    /*
     * returns a string of every attribute of the pill.
     * 
     * @return string of pill description
     */
    public String description() {
        return String.format("%S Pill\n\tStrength: %.2f\n\tSize: %.2f"
            + "\n\tColor: %S\n\tCasing: %S\n\tSolution: %S\n\tActive: %S",
            name, strength, size, color, casing, solution, active);
    }

    /*
     * returns the pill's name.
     * 
     * @return name pill name
     */
    public String getName() {
        return name;
    }

    /*
     * returns the pill's strength.
     * 
     * @return strength pill strength
     */
    public double getStrength() {
        return strength;
    }

    /*
     * returns the pill's size.
     * 
     * @return size pill size
     */
    public double getSize() {
        return size;
    }

    /*
     * returns the pill's color.
     * 
     * @return color pill color
     */
    public String getColor() {
        return color;
    }

    /*
     * returns the pill's casing material.
     * 
     * @return casing pill casing
     */
    public String getCasing() {
        return casing;
    }

    /*
     * returns the pill's solution.
     * 
     * @return solution pill solution
     */
    public String getSolution() {
        return solution;
    }

    /*
     * returns the pill's active ingredient.
     * 
     * @return active pill active
     */
    public String getActive() {
        return active;
    }

    /*
     * calls the inspect method on the inspector passed
     *
     * @param insp - an inspector object
     */
    abstract void accept(Inspector insp);
}
