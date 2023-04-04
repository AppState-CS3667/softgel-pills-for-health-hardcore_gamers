package pills;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActiveTests {
    private static final String ACETAMINOPHEN_RETURN = "acetaminophen";
    private static final double TEST_AMOUNT = 2.00;
    private static final String ZOLPIDEM_RETURN = "zolpidem";


    private static final String ACETAMINOPHEN_PRINT = "Acetylating " 
        + "para-aminophenol with acetic anhydride\n"
        + "Carefully extracting 2.00mg of acetaminophen\n"
        + "Returning 2.00mg of acetaminophen\n";
    private static final String ZOLPIDEM_PRINT = "Opening secure storage " 
        + "area ... \n" + "Carefully extracting 2.00mg of zolpidem\n"
        + "Returning 2.00mg of zolpidem\n";

    private AcetaminophenActive aceActive;
    private ZolpidemActive zolActive;
    private ByteArrayOutputStream baos;	
    private PrintStream oldOut;


    @BeforeEach
    public void beforeEach() {			
        this.aceActive = new AcetaminophenActive();
        this.zolActive = new ZolpidemActive();	
        this.oldOut = System.out;
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }
    @AfterEach
    public void afterEach() {
        System.setOut(oldOut);
    }

    @Test
    public void testAcetaminophenGenerator() {
        assertEquals(ACETAMINOPHEN_RETURN, 
            aceActive.generateActive(TEST_AMOUNT));
        assertEquals(ACETAMINOPHEN_PRINT, getOutput());
    }

    @Test
    public void testZolpidemGenerator() {
        assertEquals(ZOLPIDEM_RETURN, zolActive.generateActive(TEST_AMOUNT));
        assertEquals(ZOLPIDEM_PRINT, getOutput());
    }

    private String getOutput() {
        System.out.flush();
        return baos.toString().replaceAll("\r", "");
    }
}
