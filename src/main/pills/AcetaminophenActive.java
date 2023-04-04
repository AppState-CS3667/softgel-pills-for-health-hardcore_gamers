package pills; 
/*
 * GelCap Class -
 * hardcore_gamers
 */
public class AcetaminophenActive implements ActiveGenerator {
    @Override
    /*
     * Simple method to generate a acetaminophen active
     * 
     * @param double amount - amount of active
     */
    public String generateActive(double amount) {
        System.out.println("Acetylating para-aminophenol" 
            + " with acetic anhydride");
        System.out.printf("Carefully extracting" 
            + " %.2fmg of acetaminophen\n", amount);
        System.out.printf("Returning"
            + " %.2fmg of acetaminophen\n", amount);
        return "acetaminophen";
    }
}
