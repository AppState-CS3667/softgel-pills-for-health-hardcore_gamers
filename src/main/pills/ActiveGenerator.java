package pills;
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * ActiveGenerator class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public interface ActiveGenerator extends Remote {
    //method to be implemented by classes that extend ActiveGenerator
    public String generateActive(double amount) throws RemoteException;
}
