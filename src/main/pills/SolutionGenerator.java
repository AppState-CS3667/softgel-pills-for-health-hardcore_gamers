package pills;
import java.rmi.*;

public interface SolutionGenerator extends Remote{
    public String generateSolution();
}
