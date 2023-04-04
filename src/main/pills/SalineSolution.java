package pills;
/*
 * GelCap Class -
 * hardcore_gamers
 */
public class SalineSolution implements SolutionGenerator {

    @Override
    //Simple method to generate a saline solution
    public String generateSolution() {
        System.out.println("Mixing salt and water ... ");
        System.out.println("Verifying ratio ... ");
        System.out.printf("Returning saline solution\n");
        return "saline";
    }
}
