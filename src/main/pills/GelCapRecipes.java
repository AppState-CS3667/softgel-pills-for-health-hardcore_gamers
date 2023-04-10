package pills;

import java.util.HashMap;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;

public class GelCapRecipes {
    public static final HashMap<String, CasingGenerator> CASINGS = getCasings();
    public static final HashMap<String, SolutionGenerator> 
        SOLUTIONS = getSolutions();
    public static final HashMap<String, ActiveGenerator> 
        ACTIVES = getActives();

    /*
     * puts Dreamly and plasticizer casing, AcheAway and gelatin 
     * casing in hashmap
     * returns casings hashmap.
     */
    private static HashMap<String, CasingGenerator> getCasings() {
        HashMap<String, CasingGenerator> 
            casingsTemp = new HashMap<String, CasingGenerator>();
        casingsTemp.put("Dreamly", new PlasticizerCasing());
        casingsTemp.put("AcheAway", new GelatinCasing());
        return casingsTemp;
    }

    /*
     * puts Dreamly and oil solution, AcheAway and saline solution in hashmap
     * returns solutions hashamp.
     */
    private static HashMap<String, SolutionGenerator> getSolutions() {
        HashMap<String, SolutionGenerator> 
            solutionsTemp = new HashMap<String, SolutionGenerator>();
        solutionsTemp.put("Dreamly", new OilSolution());
        solutionsTemp.put("AcheAway", new SalineSolution());
        return solutionsTemp;
    }

    /*
     * puts Dreamly and zolpidem active, 
     * AcheAway and acetaminophen active in hashmap
     * returns actives hashmap.
     */
    private static HashMap<String, ActiveGenerator> getActives() {
        HashMap<String, ActiveGenerator> 
            activesTemp = new HashMap<String, ActiveGenerator>();
        activesTemp.put("Dreamly", new ZolpidemActive());
        activesTemp.put("AcheAway", new AcetaminophenActive());
        return activesTemp;
    }
}
