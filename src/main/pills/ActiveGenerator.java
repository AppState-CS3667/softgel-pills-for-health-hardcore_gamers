package pills;
import java.rmi.*;

/*
 * ActiveGenerator class
 */
public interface ActiveGenerator extends Remote {
    //method to be implemented by classes that extend ActiveGenerator
    public String generateActive(double amount) throws Exception;
}