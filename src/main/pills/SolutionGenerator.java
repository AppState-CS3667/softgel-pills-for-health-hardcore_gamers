package pills;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SolutionGenerator extends Remote{
    public String generateSolution() throws RemoteException;
}
