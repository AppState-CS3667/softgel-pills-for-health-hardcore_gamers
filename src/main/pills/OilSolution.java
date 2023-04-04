package pills;
/*
 * GelCap Class -
 * hardcore_gamers
 */
public class OilSolution implements SolutionGenerator {
    @Override
    //Simple method to generate a oil solution
    public String generateSolution() {
        System.out.println("Extracting pill"
            + "-sized quantity of oil ... ");
        System.out.printf("Returning oil solution\n");
        return "oil";
    }
}
