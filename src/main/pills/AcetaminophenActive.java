package pills; 
public class AcetaminophenActive implements ActiveGenerator {
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
