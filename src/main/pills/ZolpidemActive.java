package pills;
/*
 * GelCap Class -
 * hardcore_gamers
 */
public class ZolpidemActive implements ActiveGenerator {
    @Override
    /*
     * Simple method to generate a zolpidem active
     * 
     * @param double amount - amount of active
     */
    public String generateActive(double amount) {
        System.out.println("Opening secure storage area ... ");
        System.out.printf("Carefully extracting" 
            + " %.2fmg of zolpidem\n", amount);
        System.out.printf("Returning"
            + " %.2fmg of zolpidem\n", amount);
        return "zolpidem";
    }
}
