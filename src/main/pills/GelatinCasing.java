package pills;

public class GelatinCasing implements CasingGenerator {
    
    @Override
    public String generateCasing() {
        System.out.print("Mixing gelatin, water, opacifier, and " 
            + "glycerin ... \n" 
            + "Shaping ... \n" 
            + "Returning gelatin casing ... \n");
        return "gelatin";
    }
}
