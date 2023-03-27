package pills;

import java.util.HashMap;

public class GelCapRecipies {
    public static final HashMap<String, CasingGenerator> CASINGS;
    public static final HashMap<String, SolutionGenerator> SOLUTIONS;
    public static final HashMap<String, ActiveGenerator> ACTIVES;

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
