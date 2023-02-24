package pills;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcheAwayTest {

    public static final String CORRECT_NAME = "AcheAway";
    public static final String CORRECT_CASING = "gelatin";
    public static final String CORRECT_SOLUTION = "saline";
    public static final String CORRECT_ACTIVE = "acetaminophen";
    public static final String TEST_STRENGTH = "2.00";
    public static final String TEST_COLOR = "Red";
    public static final double TEST_SIZE = 5.00;
    public static final String MANUFACTURE_FSTRING = "Manufacturing..."
						     + "\nadding Gelatin casing\nadding Saline solution"
						     + "\nadding Acetaminophen active\n... completed"
						     + "manufacturing\n";
    private AcheAway ac;
    private ByteArrayOutputStream baos;
    private PrintStream oldOut;
 
    @BeforeEach
    public void beforeEach() {
        this.ac = new AcheAway(TEST_STRENGTH, TEST_SIZE, TEST_COLOR);
        this.oldOut = System.out;
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    @AfterEach
    public void afterEach() {
        System.setOut(oldOut);
    }

    @Test
    public void testName() {
        assertEquals(CORRECT_NAME, ac.getName());
    }

    @Test
    public void testStength() {
        assertEquals(TEST_STRENGTH, ac.getStrength());
    }

    @Test
    public void testSize() {
        assertEquals(TEST_SIZE, ac.getSize());
    }

    @Test
    public void testColor() {
        assertEquals(TEST_COLOR, ac.getColor());
    }

    @Test
    public void testCasing() {
        assertEquals(CORRECT_CASING, ac.getCasing());
    }

    @Test
    public void testSolution() {
        assertEquals(CORRECT_SOLUTION, ac.getSolution());
    }

    @Test
    public void testActive() {
        assertEquals(CORRECT_ACTIVE, ac.getActive());
    }

    @Test
    public void testManufactureProcess() {
        ac.manufacture();
        assertEquals(MANUFACTURE_FSTRING, getOutput());
    }

    private String getOutput() {
        System.out.flush();
        return baos.toString().replaceAll("\r", "");
    }
}
