package pills;

public class PlasticizerCasing implements CasingGenerator {
    
    public String generateCasing() {
        System.out.print("Mixing starch, water, opacifier, and " 
            + "glycerin ... \n" 
            + "Shaping ... \n" 
            + "Returning plasticizer casing ... \n");
        return "plasticizer";
    }

}
