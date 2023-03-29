package pills;

import java.util.HashMap;

public class GelCapRecipes {
    public static final HashMap<String, CasingGenerator> CASINGS = getCasings();
    public static final HashMap<String, SolutionGenerator> SOLUTIONS = getSolutions();
    public static final HashMap<String, ActiveGenerator> ACTIVES = getActives();

    private static HashMap<String, CasingGenerator> getCasings()
    {
        HashMap<String, CasingGenerator> casingsTemp = new HashMap<String, CasingGenerator>();
        casingsTemp.put("dreamly", new PlasticizerCasing());
        casingsTemp.put("acheAway", new GelatinCasing());
        return casingsTemp;
    }

    private static HashMap<String, SolutionGenerator> getSolutions()
    {
        HashMap<String, SolutionGenerator> solutionsTemp = new HashMap<String, SolutionGenerator>();
        solutionsTemp.put("dreamly", new OilSolution());
        solutionsTemp.put("acheAway", new SalineSolution());
        return solutionsTemp;
    }

    private static HashMap<String, ActiveGenerator> getActives()
    {
        HashMap<String, ActiveGenerator> activesTemp = new HashMap<String, ActiveGenerator>();
        activesTemp.put("dreamly", new ZolpidemActive());
        activesTemp.put("acheAway", new AcetaminophenActive());
        return activesTemp;
    }
}
