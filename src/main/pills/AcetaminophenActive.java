package pills; 
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

/*
 * AcetaminophenActive class.
 */
public class AcetaminophenActive extends UnicastRemoteObject 
    implements ActiveGenerator {
    
    public AcetaminophenActive(int port) throws RemoteException {
        super(port);
    }
    /*
     * generateActive method
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
