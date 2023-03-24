package pills;
public class ZolpidemActive implements ActiveGenerator {
    public String generateActive(double amount) {
        System.out.println("Opening secure storage area...");
        System.out.printf("Carefully extracting" 
            + " %.2fmg of zolpidem\n", amount);
        System.out.printf("Returning"
            + " %.2fmg of zolpidem\n", amount);
        return "zolpidem";
    }
}
