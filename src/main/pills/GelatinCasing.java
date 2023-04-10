package pills;
import java.rmi.server.RemoteObject;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class GelatinCasing extends UnicastRemoteObject implements CasingGenerator {

    public GelatinCasing(int port) throws RemoteException {
        super(port);
    }
    
    /*
     * overrides the generateCasing string from the CasingGenerator interface.
     * prints the returned gelatin casing and returns gelatin.
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
