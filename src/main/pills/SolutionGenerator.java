package pills;
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * SolutionGenerator class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public interface SolutionGenerator extends Remote {
    public String generateSolution() throws RemoteException;
}
