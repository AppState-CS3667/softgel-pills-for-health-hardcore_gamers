package pills;

import java.util.HashMap;

public class GelCapRecipes {
    public static final HashMap<String, CasingGenerator> CASINGS = new HashMap<String, CasingGenerator>();
    public static final HashMap<String, SolutionGenerator> SOLUTIONS = new HashMap<String, SolutionGenerator>();
    public static final HashMap<String, ActiveGenerator> ACTIVES = new HashMap<String, ActiveGenerator>();

    private static HashMap<String, CasingGenerator> getCasings()
    {
        return CASINGS;
    }

    private static HashMap<String, SolutionGenerator> getSolutions()
    {
        return SOLUTIONS;
    }

    private static HashMap<String, ActiveGenerator> getActives()
    {
        return ACTIVES;
    }
}
