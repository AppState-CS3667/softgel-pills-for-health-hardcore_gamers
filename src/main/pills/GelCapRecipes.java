package pills;

import java.util.HashMap;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;

/*
 * GelCapRecipes class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
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
        try {
            //tries to create casings with remote method invocation 
            //connection to host machine
            casingsTemp.put("Dreamly", (CasingGenerator) 
                Naming.lookup("rmi://152.10.10.40/PlasticizerCasing"));
            casingsTemp.put("AcheAway", (CasingGenerator) 
                Naming.lookup("rmi://152.10.10.40/GelatinCasing"));
        }
        //catches any execeptions related to RMI and prints the stack trace
        catch (MalformedURLException | RemoteException | NotBoundException e) { 
            e.printStackTrace(); 
        }
        return casingsTemp;
    }

    /*
     * puts Dreamly and oil solution, AcheAway and saline solution in hashmap
     * returns solutions hashamp.
     */
    private static HashMap<String, SolutionGenerator> getSolutions() {
        HashMap<String, SolutionGenerator> 
            solutionsTemp = new HashMap<String, SolutionGenerator>();
        try {
            //tries to create solutions with remote method invocation 
            //connection to host machine
            solutionsTemp.put("Dreamly", (SolutionGenerator) 
                Naming.lookup("rmi://152.10.10.40/OilSolution"));
            solutionsTemp.put("AcheAway", (SolutionGenerator) 
                Naming.lookup("rmi://152.10.10.40/SalineSolution"));
        }
        //catches any execeptions related to RMI and prints the stack trace
        catch (MalformedURLException | RemoteException | NotBoundException e) { 
            e.printStackTrace(); 
        }
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
        try {
            //tries to create actives with remote method invocation 
            //connection to host machine
            activesTemp.put("Dreamly", (ActiveGenerator) 
                Naming.lookup("rmi://152.10.10.40/ZolpidemActive"));
            activesTemp.put("AcheAway", (ActiveGenerator) 
                Naming.lookup("rmi://152.10.10.40/AcetaminophenActive"));
        }
        //catches any execeptions related to RMI and prints the stack trace
        catch (MalformedURLException | RemoteException | NotBoundException e) { 
            e.printStackTrace(); 
        }
        return activesTemp;
    }
}
