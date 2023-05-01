package pills; 
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

/**
 * AcetaminophenActive class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public class AcetaminophenActive extends UnicastRemoteObject 
    implements ActiveGenerator {
    
    /*
     * Constructor that calls the super constructor.
     * 
     * @param port - the port number (used for Proxy).
     */
    public AcetaminophenActive(int port) throws RemoteException {
        super(port);
    }
    
    /*
     * Method that generates (prints out) the actives
     * 
     * @param amount mg of acetaminophen to print
     * @return the string "acetaminophen"
     */
    public String generateActive(double amount) throws RemoteException {
        System.out.println("Acetylating para-aminophenol" 
            + " with acetic anhydride");
        System.out.printf("Carefully extracting" 
            + " %.2fmg of acetaminophen\n", amount);
        System.out.printf("Returning"
            + " %.2fmg of acetaminophen\n", amount);
        return "acetaminophen";
    }
}
