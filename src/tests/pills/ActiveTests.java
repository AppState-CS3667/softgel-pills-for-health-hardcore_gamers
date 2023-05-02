package pills;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.rmi.RemoteException;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * ActiveTests class.
 * This class is used for testing 
 * the AcheAway class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
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
    private static final int ACETAMINOHENPORT = 1094;
    private static final int ZOLPIDEMPORT = 1093;

    private AcetaminophenActive aceActive;
    private ZolpidemActive zolActive;
    private ByteArrayOutputStream baos;	
    private PrintStream oldOut;

    /*
     * Initializes ZolpidemActive and 
     * AcetaminophenActives by calling constructors.
     * Initializes a new ByteArrayOutputStream.
     * Sets the out field of System to a new PrintStream.
     */
    @BeforeEach
    public void beforeEach() {			
        try {
            this.aceActive = new AcetaminophenActive(ACETAMINOHENPORT);
            this.zolActive = new ZolpidemActive(ZOLPIDEMPORT);
        }
        catch (RemoteException e) {
            aceActive = null; 
            zolActive = null;
        }
        this.oldOut = System.out;
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    /*
     * Tests that the Acetaminophen generator works properly.
     */
    @Test
    public void testAcetaminophenGenerator() {
        try {
            assertEquals(ACETAMINOPHEN_RETURN, 
                aceActive.generateActive(TEST_AMOUNT));
        }
        catch (RemoteException e) {
            fail("ERROR: RemoteException Error when calling generateActive.");
        }
        assertEquals(ACETAMINOPHEN_PRINT, getOutput());
    }

    /*
     * Tests that the Zolpidem generator works properly.
     */
    @Test
    public void testZolpidemGenerator() {
        try {
            assertEquals(ZOLPIDEM_RETURN, 
                zolActive.generateActive(TEST_AMOUNT));
        }
        catch (RemoteException e) {
            fail("ERROR: RemoteException Error when calling generateActive.");
        }
        assertEquals(ZOLPIDEM_PRINT, getOutput());
    }

    /*
     * Removes the \r characters from new output.
     * 
     * @return the string after flushing out \r characters
     */
    private String getOutput() {
        System.out.flush();
        return baos.toString().replaceAll("\r", "");
    }

    /*
     * Sets the out field of System back to System.out
     */
    @AfterEach
    public void afterEach() {
        System.setOut(oldOut);
    }
}
