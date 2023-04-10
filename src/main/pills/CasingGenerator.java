package pills;
import java.rmi.*;

public interface CasingGenerator extends Remote{
    
    //call to generate string casing
    public String generateCasing();

}
