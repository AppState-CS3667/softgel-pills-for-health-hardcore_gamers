package pills;
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * CasingGenerator class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public interface CasingGenerator extends Remote {
    
    //call to generate string casing
    public String generateCasing() throws RemoteException;

}
