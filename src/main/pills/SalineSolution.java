package pills;
import java.rmi.server.RemoteObject;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class SalineSolution extends UnicastRemoteObject implements SolutionGenerator {
    
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
