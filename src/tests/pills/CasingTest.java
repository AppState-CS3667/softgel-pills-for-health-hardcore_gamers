package pills;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CasingTest {
    private GelatinCasing gelCase; 
    private PlasticizerCasing plastCase; 
    private ByteArrayOutputStream baos;
    private PrintStream oldOut;

    private static final String GEL = "Mixing gelatin, water, opacifier, and glycerin ...\nShaping ..." 
                                       + "\nReturning gelatin casing ...\n";
    private static final String PLAST = "Mixing gelatin, water, opacifier, and glycerin ...\nShaping ..." 
                                       + "\nReturning plasticizer casing ...\n";
    private static final String GELATIN = "gelatin";
    private static final String PLASTICIZER = "plasticizer";

    @BeforeEach
    public void beforeEach() {
        this.gelCase = new GelatinCasing();
        this.plastCase = new PlasticizerCasing();
        this.oldOut = System.out;
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    @Test
    public void testGelatinCasing() {
        String tempGel = gelCase.generateCasing();
        assertEquals(GEL, getOutput());
	assertEquals(GELATIN, tempGel);
    }

    @Test
    public void testPlasticizerCasing() {
        String tempPlast = plastCase.generateCasing();
        assertEquals(PLAST, getOutput());
	assertEquals(PLASTICIZER, tempPlast);
    }

    @AfterEach
    public void afterEach() {
        System.setOut(oldOut);
    }

    private String getOutput() {
        System.out.flush();
	return baos.toString.replaceAll("\r", "");
    }
}
