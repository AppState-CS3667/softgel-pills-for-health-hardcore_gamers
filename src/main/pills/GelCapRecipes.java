package pills;

import java.util.HashMap;

public class GelCapRecipes {
    public static final HashMap<String, CasingGenerator> CASINGS = getCasings();
    public static final HashMap<String, SolutionGenerator> SOLUTIONS = getSolutions();
    public static final HashMap<String, ActiveGenerator> ACTIVES = getActives();

    private static HashMap<String, CasingGenerator> getCasings()
    {
        HashMap<String, CasingGenerator> casingsTemp = new HashMap<String, CasingGenerator>();
        casingsTemp.put("Dreamly", new PlasticizerCasing());
        casingsTemp.put("AcheAway", new GelatinCasing());
        return casingsTemp;
    }

    private static HashMap<String, SolutionGenerator> getSolutions()
    {
        HashMap<String, SolutionGenerator> solutionsTemp = new HashMap<String, SolutionGenerator>();
        solutionsTemp.put("Dreamly", new OilSolution());
        solutionsTemp.put("AcheAway", new SalineSolution());
        return solutionsTemp;
    }

    private static HashMap<String, ActiveGenerator> getActives()
    {
        HashMap<String, ActiveGenerator> activesTemp = new HashMap<String, ActiveGenerator>();
        activesTemp.put("Dreamly", new ZolpidemActive());
        activesTemp.put("AcheAway", new AcetaminophenActive());
        return activesTemp;
    }
}
