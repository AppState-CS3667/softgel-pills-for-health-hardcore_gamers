package pills;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

public class SolutionTest{
    private static final String TEST_OIL = "oil";
    private static final String TEST_SALINE = "saline";
    private static final String TEST_SALINE_OUT = 
                            "Mixing salt and water ... \n"
                            + "Verifying ratio ... \n"
                            + "Returning saline solution\n"
    private static final String TEST_OIL_OUT =  
                            "Extracting pill-sized quantity of "
                            + "oil ... \n"
                            + "Returning oil solution\n"

    private ByteArrayOutputStream baos;
    private PrintStream oldOut;

    private static SalineSolution ss;
    private static OilSolution os;

    @BeforeEach
    public void beforeEach() {
        this.ss = new SalineSolution();
        this.os = new OilSolution();

        this.oldOut = System.out;
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    @AfterEach
    public void afterEach() {
        System.setOut(oldOut);
    }

    @Test
    public void testSaline() {
        assertEquals(TEST_SALINE, ss.generateSolution());
        assertEquals(TEST_SALINE_OUT, getOutput());
    }

    @Test
    public void testOil() {
        assertEquals(TEST_OIL, os.generateSolution());
        assertEquals(TEST_OIL_OUT, getOutput());
    }

    private String getOutput() {
        System.out.flush();
        return baos.toString().replaceAll("\r", "");
    }
}