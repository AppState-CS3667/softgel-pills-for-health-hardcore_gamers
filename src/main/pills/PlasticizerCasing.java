package pills;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

/*
 * PlasticizerCasing class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public class PlasticizerCasing extends UnicastRemoteObject 
    implements CasingGenerator {

    /*
     * Plasticizer constructor that calls the super constructor.
     * 
     * @param port the port that is used in the proxy.
     */
    public PlasticizerCasing(int port) throws RemoteException {
        super(port);
    }
    
    /*
     * overrides the generateCasing string from the CasingGenerator interface.
     * prints the returned plasticizer casing and returns plasticizer.
     * 
     * @return plasticizer the plasticizer casing that was generated.
     */
    @Override
    public String generateCasing() throws RemoteException {
        System.out.print("Mixing starch, water, opacifier, and " 
            + "glycerin ... \n" 
            + "Shaping ... \n" 
            + "Returning plasticizer casing ... \n");
        return "plasticizer";
    }
}
