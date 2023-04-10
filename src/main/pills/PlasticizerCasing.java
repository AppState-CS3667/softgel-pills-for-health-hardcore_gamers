package pills;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class PlasticizerCasing extends UnicastRemoteObject 
    implements CasingGenerator {

    public PlasticizerCasing(int port) throws RemoteException {
        super(port);
    }
    
    /*
     * overrides the generateCasing string from the CasingGenerator interface.
     * prints the returned plasticizer casing and returns plasticizer.
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
