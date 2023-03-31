package pills;

public class GelatinCasing implements CasingGenerator {
    
    /*
     * overrides the generateCasing string from the CasingGenerator interface.
     * prints the returned gelatin casing and returns gelatin.
     */
    @Override
    public String generateCasing() {
        System.out.print("Mixing gelatin, water, opacifier, and " 
            + "glycerin ... \n" 
            + "Shaping ... \n" 
            + "Returning gelatin casing ... \n");
        return "gelatin";
    }
}
