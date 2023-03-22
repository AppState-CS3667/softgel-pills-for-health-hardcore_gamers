package pills;

public class GelatinCasing implements CasingGenerator {
    
    @Override
    public String generateCasing()
    {
        String ret = "Mixing gelatin, water, opacifier, and" +
        "glycerin ... \n" +
        "Shaping ... \n" +
        "Returning gelatin casing ... \n";
        return ret;
    }
}
