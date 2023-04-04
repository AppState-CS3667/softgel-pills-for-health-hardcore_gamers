package pills;
public class OilSolution implements SolutionGenerator {
    public String generateSolution() {
        System.out.println("Extracting pill"
            + "-sized quantity of oil ... ");
        System.out.printf("Returning oil solution\n");
        return "oil";
    }
}
