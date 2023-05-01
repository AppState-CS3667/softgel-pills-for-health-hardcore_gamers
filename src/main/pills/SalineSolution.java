package pills;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

/*
 * SalineSolution class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public class SalineSolution extends UnicastRemoteObject 
    implements SolutionGenerator {
    
    /*
     * Saline constructor that calls the super constructor.
     * 
     * @param port the port that is used in the proxy.
     */
    public SalineSolution(int port) throws RemoteException {
        super(port);
    }

    /*
     * overrides the generateSolution string from the 
     * SolutionGenerator interface.
     * prints the returned saline solution and returns saline.
     * 
     * @return saline the saline solution that was generated.
     */
    public String generateSolution() throws RemoteException {
        System.out.println("Mixing salt and water ... ");
        System.out.println("Verifying ratio ... ");
        System.out.printf("Returning saline solution\n");
        return "saline";
    }
}
