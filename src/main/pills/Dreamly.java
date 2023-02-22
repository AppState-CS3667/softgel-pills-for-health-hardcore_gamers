package pills;

public class Dreamly extends GelCap 
{
	/*
	 * Constructor for class Dreamly that calls the super
	 * constructor of the GelCap class.
	 *
	 * @param strength. Pill strength.
	 * @param size. Pill size. 
	 * @param strength. Pill color. 
	 *
	 */
	public Dreamly (double strength, double size, String color) 
	{
		super("Dreamly", strength, size, color);
	}

	/*
	 * This mehtod adds casing to the Dreamly pill.
	 */
	@Override
	protected void addCasing() 
	{
		casing = "plasticizer";
		System.out.println("adding " + casing + " casing");
	}

	/*
	 * This method adds a solution to the Dreamly pill.
	 */
	@Override
	protected void addSolution() 
	{
		solution = "oil";
		System.out.println("adding " + solution + " solution");
	}

	/*
	 * This method adds an active to the Dreamly pill.
	 */
	@Override
	protected void addActive() 
	{
		active = "zolpiem";
		System.out.println("adding " + active + " active");
	}
}
