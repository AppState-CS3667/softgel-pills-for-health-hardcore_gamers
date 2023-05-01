package pills;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

/*
 * GelatinCasing class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public class GelatinCasing extends UnicastRemoteObject 
    implements CasingGenerator {

    /*
     * GelatinCasing constructor that calls the super constructor.
     */
    public GelatinCasing(int port) throws RemoteException {
        super(port);
    }
    
    /*
     * overrides the generateCasing string from the CasingGenerator interface.
     * prints the returned gelatin casing and returns gelatin.
     * 
     * @return gelatin the gelatin casing that was generated.
     */
    @Override
    public String generateCasing() throws RemoteException {
        System.out.print("Mixing gelatin, water, opacifier, and " 
            + "glycerin ... \n" 
            + "Shaping ... \n" 
            + "Returning gelatin casing ... \n");
        return "gelatin";
    }
}
