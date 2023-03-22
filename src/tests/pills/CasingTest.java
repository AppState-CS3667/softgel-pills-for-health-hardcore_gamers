package pills;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class CasingTest {
    private GelatinCasing gelCase; 
    private PlasticizerCasing plastCase; 
    private ByteArrayOutputStream baos;
    private PrintStream oldOut;

    private static final String GEL = "Mixing gelatin, water, opacifier, and glycerin...\nShaping..." 
                                       + "\nReturning gelatin casing...\n";
    private static final String PLAST = "Mixing gelatin, water, opacifier, and glycerin...\nShaping..." 
                                       + "\nReturning plasticizer casing...\n";

    public void beforeEach() {
        this.obj = new ClassToTest();	
        this.oldOut = System.out;
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    @Test
    public void testGelatinCasing() {
        assertEquals();
	assertEquals();
    }

    @Test
    public void testPlasticizerCasing() {
    }

    @AfterEach
    public void afterEach() {
        System.setOut(oldOut);
    }
}
