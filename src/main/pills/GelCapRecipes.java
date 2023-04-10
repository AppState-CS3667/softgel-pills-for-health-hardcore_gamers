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
        try
        {
            casingsTemp.put("Dreamly", (PlasticizerCasing) Naming.lookup("rmi://152.10.10.40/PlasticizerCasing"));
            casingsTemp.put("AcheAway", (GelatinCasing) Naming.lookup("rmi://152.10.10.40/GelatinCasing"));
        }
        catch (MalformedURLException | RemoteException | NotBoundException e) { e.printStackTrace();}
        return casingsTemp;
    }

    /*
     * puts Dreamly and oil solution, AcheAway and saline solution in hashmap
     * returns solutions hashamp.
     */
    private static HashMap<String, SolutionGenerator> getSolutions() {
        HashMap<String, SolutionGenerator> 
            solutionsTemp = new HashMap<String, SolutionGenerator>();
        try
        {
            solutionsTemp.put("Dreamly", (OilSolution) Naming.lookup("rmi://152.10.10.40/OilSolution"));
            solutionsTemp.put("AcheAway", (SalineSolution) Naming.lookup("rmi://152.10.10.40/SalineSolution"));
        }
        catch (MalformedURLException | RemoteException | NotBoundException e) { e.printStackTrace();}
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
        try
        {
            activesTemp.put("Dreamly", (ZolpidemActive) Naming.lookup("rmi://152.10.10.40/ZolpidemActive"));
            activesTemp.put("AcheAway", (AcetaminophenActive) Naming.lookup("rmi://152.10.10.40/AcetaminophenActive"));
        }
        catch (MalformedURLException | RemoteException | NotBoundException e) { e.printStackTrace();}
        return activesTemp;
    }
}
