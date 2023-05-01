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
    
    public OilSolution(int port) throws RemoteException {
        super(port);
    }

    public String generateSolution() throws RemoteException {
        System.out.println("Extracting pill"
            + "-sized quantity of oil ... ");
        System.out.printf("Returning oil solution\n");
        return "oil";
    }
}
