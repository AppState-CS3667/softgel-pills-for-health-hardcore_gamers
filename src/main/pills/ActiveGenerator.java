package pills;
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * ActiveGenerator class
 */
public interface ActiveGenerator extends Remote {
    //method to be implemented by classes that extend ActiveGenerator
    public String generateActive(double amount) throws RemoteException;
}
