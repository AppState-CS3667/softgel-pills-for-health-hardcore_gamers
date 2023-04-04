package pills;
public abstract class GelCapFactory {

    public final double qp = 0.9;

    public final Dreamly produceDreamly() {
        System.out.print("Creating a Dreamly pill ... \n");
        Dreamly dp = 
	    constructDreamly(GelCapRecipes.CASINGS.get("Dreamly").generateCasing(),
			GelCapRecipes.SOLUTIONS.get("Dreamly").generateSolution(),
			GelCapRecipes.ACTIVES.get("Dreamly").generateActive(
			getDreamlyStrength()));
	if (qualityCheck()) {
	    System.out.print("Returning a good Dreamly GelCap Pill\n");
	    return dp;
	}
	else {
	    System.out.print("Error during Dreamly production. Returning null\n");
	    return null;
        }
    }

    public final AcheAway produceAcheAway() {
        System.out.print("Creating a AcheAway pill ... \n");
        AcheAway ap = constructAcheAway(GelCapRecipes.CASINGS.get(
                        "AcheAway").generateCasing(),
					GelCapRecipes.SOLUTIONS.get("AcheAway").generateSolution(),
					GelCapRecipes.ACTIVES.get("AcheAway").generateActive(
                        getAcheAwayStrength()));

        if (qualityCheck()) {
	    System.out.print("Returning a good AcheAway GelCap Pill\n");
	    return ap;
        }
        else {
            System.out.print(
				"Error during AcheAway production. Returning null\n");
            return null;
        }

    }

    private final boolean qualityCheck() {
	double check = Math.random();
	if (check <= qp) {
	    System.out.print("quality check passed\n");
	    return true;
	}
	else {
	    System.out.print("quality check failed\n");
	    return false;
	}
    }

    protected abstract Dreamly constructDreamly(String casing, 
										String solution, String active);

    protected abstract AcheAway constructAcheAway(String casing, 
										String solution, String active);

    protected abstract double getDreamlyStrength();

    protected abstract double getAcheAwayStrength();
}

