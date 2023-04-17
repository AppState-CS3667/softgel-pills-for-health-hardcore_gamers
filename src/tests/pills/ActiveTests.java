package pills;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.rmi.RemoteException;
import static org.junit.jupiter.api.Assertions.fail;

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

    // Port numbers
    private static final int AcetaminophenPort = 1094;
    private static final int ZolpidemPort = 1093;

    private AcetaminophenActive aceActive;
    private ZolpidemActive zolActive;
    private ByteArrayOutputStream baos;	
    private PrintStream oldOut;


    @BeforeEach
    public void beforeEach() {			
        try {
            this.aceActive = new AcetaminophenActive(AcetaminophenPort);
            this.zolActive = new ZolpidemActive(ZolpidemPort);
        }
        catch (RemoteException e) {
            aceActive = null; 
            zolActive = null;
        }
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
        try {
            assertEquals(ACETAMINOPHEN_RETURN, aceActive.generateActive(TEST_AMOUNT));
        }
        catch (RemoteException e) {
            fail("ERROR: RemoteException Error when calling generateActive.");
        }
        assertEquals(ACETAMINOPHEN_PRINT, getOutput());
    }

    @Test
    public void testZolpidemGenerator() {
        try {
            assertEquals(ZOLPIDEM_RETURN, zolActive.generateActive(TEST_AMOUNT));
        }
        catch (RemoteException e) {
            fail("ERROR: RemoteException Error when calling generateActive.");
        }
        assertEquals(ZOLPIDEM_PRINT, getOutput());
    }

    private String getOutput() {
        System.out.flush();
        return baos.toString().replaceAll("\r", "");
    }
}
