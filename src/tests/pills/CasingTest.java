package pills;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.rmi.RemoteException;

public class CasingTest {
    private static final String GEL = "Mixing gelatin, water, "
        + "opacifier, and glycerin ... \nShaping ... " 
                                       + "\nReturning gelatin casing ... \n";
    private static final String PLAST = "Mixing starch, water, "
        + "opacifier, and glycerin ... \nShaping ... " 
        + "\nReturning plasticizer casing ... \n";
    private static final String GELATIN = "gelatin";
    private static final String PLASTICIZER = "plasticizer";

    // Port numbers
    public static final int GelatinPort = 1098;
    public static final int PlasticizerPort = 1097;

    private GelatinCasing gelCase; 
    private PlasticizerCasing plastCase; 
    private ByteArrayOutputStream baos;
    private PrintStream oldOut;

    @BeforeEach
    public void beforeEach() {
        try {
            this.gelCase = new GelatinCasing(GelatinPort);
            this.plastCase = new PlasticizerCasing(PlasticizerPort);
        }
        catch(RemoteException e)
        {
            gelCase = null;
            plastCase = null;
        }
        this.oldOut = System.out;
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    @Test
    public void testGelatinCasing() {
        try {
            String tempGel = gelCase.generateCasing();
	        assertEquals(GELATIN, tempGel);
        }
        catch(RemoteException e) {
            fail("ERROR: RemoteException error when calling generateCasing");
        }
        assertEquals(GEL, getOutput());
    }

    @Test
    public void testPlasticizerCasing() {
        try {
            String tempPlast = plastCase.generateCasing();
	        assertEquals(PLASTICIZER, tempPlast);
        }
        catch(RemoteException e) {
            fail("ERROR: RemoteException error when calling generateCasing");
        }
        assertEquals(PLAST, getOutput());
    }

    @AfterEach
    public void afterEach() {
        System.setOut(oldOut);
    }

    private String getOutput() {
        System.out.flush();
	return baos.toString().replaceAll("\r", "");
    }
}
