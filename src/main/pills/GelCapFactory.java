package pills;

import java.rmi.RemoteException;

/*
 * GelCapFactory class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public abstract class GelCapFactory {

    // The probability a quality check passes
    public final double qp = 0.9;

    /*
     * constructs a Dreamly pill and performs a
	 * quality check on said pill
	 */
    public final Dreamly produceDreamly() {
        System.out.print("Creating a Dreamly pill ... \n");

        try {
            Dreamly dp = 
	        constructDreamly(
                GelCapRecipes.CASINGS.get("Dreamly").generateCasing(),
			    GelCapRecipes.SOLUTIONS.get("Dreamly").generateSolution(),
			    GelCapRecipes.ACTIVES.get("Dreamly").generateActive(
                    getDreamlyStrength()));

            if (qualityCheck()) {
                System.out.print("Returning a good Dreamly GelCap Pill\n");
                return dp;
            }
            else {
                System.out.print(
                    "Error during Dreamly production. Returning null\n");
                return new NullDreamly();
            }
        }
        catch (RemoteException e) {
            return null;
        }
    }

    /*
     * constructs an AcheAway pill and performs a
	 * qality check on said pill.
     * 
     * @return dp - a good dreamly pill
     * @return new NullDreamly() - a bad dreamly pill
     * @return null
	 */
    public final AcheAway produceAcheAway() {
        System.out.print("Creating a AcheAway pill ... \n");
        try {
            AcheAway ap = constructAcheAway(
                GelCapRecipes.CASINGS.get("AcheAway").generateCasing(),
				GelCapRecipes.SOLUTIONS.get("AcheAway").generateSolution(),
				GelCapRecipes.ACTIVES.get("AcheAway").generateActive(
                    getAcheAwayStrength()));

            if (qualityCheck()) {
	        System.out.print("Returning a good AcheAway GelCap Pill\n");
	        return ap;
            }
            else {
                System.out.print("Error during AcheAway" 
                    + " production. Returning null\n");
                return new NullAcheAway();
            }
        }
        catch (RemoteException e) {
            return null;
        }
    }

    /*
     * performs a quality check on a pill.
	 * quality check has a 90% chance of passing.\
     * 
     * @return ap - a good acheaway pill
     * @return new NullAcheAway() - a bad acheaway pill
     * @return null
	 */
    private final boolean qualityCheck() {
        double check = Math.random();
        if (check <= qp) {
            System.out.print("quality check passed ...\n");
            return true;
        }
        else {
            System.out.print("quality check failed ...\n");
            return false;
        }
    }

    //abstract method to create a Dreamly pill
    protected abstract Dreamly constructDreamly(String casing, 
										String solution, String active);

    //abstract method to create an AcheAway pill
    protected abstract AcheAway constructAcheAway(String casing, 
										String solution, String active);

    //Helper method that returns a Dreamly pills strength
    protected abstract double getDreamlyStrength();

    //Helper method that returns a Dreamly pills strength
    protected abstract double getAcheAwayStrength();
}
