package pills;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

/*
 * ZolpidemActive class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public class ZolpidemActive extends UnicastRemoteObject 
                            implements ActiveGenerator {
    
    /*
     * Zolpidem constructor that calls the super constructor.
     * 
     * @param port the port that is used in the proxy.
     */
    public ZolpidemActive(int port) throws RemoteException {
        super(port);
    }

    /*
     * overrides the generateActive string from the 
     * ActiveGenerator interface.
     * prints the returned zolpidem active and returns zolpidem.
     * 
     * @return zolpidem the zolpidem active that was generated.
     */
    public String generateActive(double amount) throws RemoteException {
        System.out.println("Opening secure storage area ... ");
        System.out.printf("Carefully extracting" 
            + " %.2fmg of zolpidem\n", amount);
        System.out.printf("Returning"
            + " %.2fmg of zolpidem\n", amount);
        return "zolpidem";
    }
}
