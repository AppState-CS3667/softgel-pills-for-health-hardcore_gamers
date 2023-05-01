package pills;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.rmi.RemoteException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.fail;

public class SolutionTest {

    private static final String TEST_OIL = "oil";
    private static final String TEST_SALINE = "saline";
    private static final String TEST_SALINE_OUT = 
                            "Mixing salt and water ... \n"
                            + "Verifying ratio ... \n"
                            + "Returning saline solution\n";
    private static final String TEST_OIL_OUT =  
                            "Extracting pill-sized quantity of "
                            + "oil ... \n"
                            + "Returning oil solution\n";
    private static SalineSolution ss;
    private static OilSolution os;

    // Port numbers
    private static final int OIL_PORT = 1096;
    private static final int SALINE_PORT = 1095;

    private ByteArrayOutputStream baos;
    private PrintStream oldOut;


    /*
     * lifecycle hook that sets up the solution
     * objects and redirects System.out
     */
    @BeforeEach
    public void beforeEach() {
        try {
            this.ss = new SalineSolution(SALINE_PORT);
            this.os = new OilSolution(OIL_PORT);
        }
        catch (RemoteException e) {
            this.ss = null;
            this.os = null;
        }

        this.oldOut = System.out;
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    /*
     * sets System to out
     */
    @AfterEach
    public void afterEach() {
        System.setOut(oldOut);
    }

    /*
     * tests the return value from
     * generateSolution and the print
     * statement
     */
    @Test
    public void testSaline() {
        try {
            assertEquals(TEST_SALINE, ss.generateSolution());
        }
        catch (RemoteException e) {
            fail("Error: RemoteException when creating a new saline solution.");
        }
        assertEquals(TEST_SALINE_OUT, getOutput());
    }

    /*
     * tests the return value from
     * generateSolution and the print
     * statement
     */
    @Test
    public void testOil() {
        try {
            assertEquals(TEST_OIL, os.generateSolution());
        }
        catch (RemoteException e) {
            fail("Error: RemoteException when creating a new oil solution.");
        }
        assertEquals(TEST_OIL_OUT, getOutput());
    }

    /*
     * displays the print statement
     * so it can be compared in testOil
     * and testSaline
     */
    private String getOutput() {
        System.out.flush();
        return baos.toString().replaceAll("\r", "");
    }
}
