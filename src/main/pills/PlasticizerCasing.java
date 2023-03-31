package pills;

public class PlasticizerCasing implements CasingGenerator {
    
    /*
     * overrides the generateCasing string from the CasingGenerator interface.
     * prints the returned plasticizer casing and returns plasticizer.
     */
    @Override
    public String generateCasing() {
        System.out.print("Mixing starch, water, opacifier, and " 
            + "glycerin ... \n" 
            + "Shaping ... \n" 
            + "Returning plasticizer casing ... \n");
        return "plasticizer";
    }

}
