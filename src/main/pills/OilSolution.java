package pills;
import java.rmi.server.RemoteObject;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class OilSolution extends UnicastRemoteObject implements SolutionGenerator {
    
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
