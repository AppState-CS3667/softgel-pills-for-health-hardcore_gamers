package pills;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

/*
 * OilSolution class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public class OilSolution extends UnicastRemoteObject 
    implements SolutionGenerator {

    /*
     * OilSolution constructor that calls the super constructor.
     * 
     * @param port the port that is used in the proxy.
     */
    public OilSolution(int port) throws RemoteException {
        super(port);
    }

    /*
     * overrides the generateSolution string from the SolutionGenerator interface.
     * prints the returned solution and returns oil.
     * 
     * @return oil the oil casing that was generated.
     */
    public String generateSolution() throws RemoteException {
        System.out.println("Extracting pill"
            + "-sized quantity of oil ... ");
        System.out.printf("Returning oil solution\n");
        return "oil";
    }
}
