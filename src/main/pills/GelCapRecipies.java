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

    private static HashMap<String, CasingSolutions> getSolutions()
    {
        return SOLUTIONS;
    }

    private static HashMap<String, CasingActives> getActives()
    {
        return ACTIVES;
    }
}
