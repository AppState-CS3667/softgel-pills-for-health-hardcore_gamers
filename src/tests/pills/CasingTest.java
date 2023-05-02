package pills;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.rmi.RemoteException;

/**
 * CasingTest class.
 * This class is used for testing the casing generators.
 * 
 * @author hardcore_gamers
 * @version 5/01/2023
 */
public class CasingTest {
    // Port numbers
    public static final int GELATINPORT = 1098;
    public static final int PLASTICIZERPORT = 1097;

    private static final String GEL = "Mixing gelatin, water, "
        + "opacifier, and glycerin ... \nShaping ... " 
                                       + "\nReturning gelatin casing ... \n";
    private static final String PLAST = "Mixing starch, water, "
        + "opacifier, and glycerin ... \nShaping ... " 
        + "\nReturning plasticizer casing ... \n";
    private static final String GELATIN = "gelatin";
    private static final String PLASTICIZER = "plasticizer";

    private GelatinCasing gelCase; 
    private PlasticizerCasing plastCase; 
    private ByteArrayOutputStream baos;
    private PrintStream oldOut;

    /*
     * Initializes a new GelatinCasing and PlasticizerCasing
     * Sets baos to a new ByteArrayOutputStream
     * Sets output to a new PrintStream using baos
     */
    @BeforeEach
    public void beforeEach() {
        try {
            this.gelCase = new GelatinCasing(GELATINPORT);
            this.plastCase = new PlasticizerCasing(PLASTICIZERPORT);
        }
        catch (RemoteException e) {
            fail("ERROR: RemoteException error when creating a new Casing.");
        }
        this.oldOut = System.out;
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    /*
     * GELATIN is "gelatin"
     */
    @Test
    public void testGelatinCasing() {
        try {
            String tempGel = gelCase.generateCasing();
            assertEquals(GELATIN, tempGel);
        }
        catch (RemoteException e) {
            fail("ERROR: RemoteException error when calling generateCasing.");
        }
        assertEquals(GEL, getOutput());
    }

    /*
     * PLASTICIZER is "plasticizer"
     */
    @Test
    public void testPlasticizerCasing() {
        try {
            String tempPlast = plastCase.generateCasing();
            assertEquals(PLASTICIZER, tempPlast);
        }
        catch (RemoteException e) {
            fail("ERROR: RemoteException error when calling generateCasing.");
        }
        assertEquals(PLAST, getOutput());
    }

    /*
     * Sets the output back to the original output
     */
    @AfterEach
    public void afterEach() {
        System.setOut(oldOut);
    }

    /*
     * Flushes the output into baos.
     * @return a string with baos output, minus carriage returns
     */
    private String getOutput() {
        System.out.flush();
	return baos.toString().replaceAll("\r", "");
    }
}
