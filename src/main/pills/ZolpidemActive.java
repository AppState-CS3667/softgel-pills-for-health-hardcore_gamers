package pills;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class ZolpidemActive extends UnicastRemoteObject 
    implements ActiveGenerator {
    
    public ZolpidemActive(int port) throws RemoteException {
        super(port);
    }

    public String generateActive(double amount) throws RemoteException {
        System.out.println("Opening secure storage area ... ");
        System.out.printf("Carefully extracting" 
            + " %.2fmg of zolpidem\n", amount);
        System.out.printf("Returning"
            + " %.2fmg of zolpidem\n", amount);
        return "zolpidem";
    }
}
