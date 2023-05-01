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
    
    public SalineSolution(int port) throws RemoteException {
        super(port);
    }

    public String generateSolution() throws RemoteException {
        System.out.println("Mixing salt and water ... ");
        System.out.println("Verifying ratio ... ");
        System.out.printf("Returning saline solution\n");
        return "saline";
    }
}
