package pills;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CasingGenerator extends Remote{
    
    //call to generate string casing
    public String generateCasing() throws RemoteException;

}
