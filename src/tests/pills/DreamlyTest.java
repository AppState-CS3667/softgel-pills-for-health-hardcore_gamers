package pills;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DreamlyTest {
    private static final String CORRECT_NAME = "Dreamly";
    private static final String CORRECT_CASING = "plasticizer";
    private static final String CORRECT_SOLUTION = "oil";
    private static final String CORRECT_ACTIVE = "zolpidem";
    private static final double TEST_STRENGTH = 700;
    private static final double TEST_SIZE = 0.5;
    private static final String TEST_COLOR = "blue";
    private static final String MANUFACTURE_FSTRING = "Manufacturing..."
	                                        + "\nadding plasticizer casing"
											+ "\nadding oil solution"
											+ "\nadding zolpidem active"
											+ "\n...completed manufacturing\n";
    private static Dreamly dreamly;
    private static ByteArrayOutputStream baos;
    private static PrintStream oldOut;

    @BeforeEach
	public void beforeEach() {
        dreamly = new Dreamly(TEST_STRENGTH, TEST_SIZE, TEST_COLOR);
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
        assertEquals(CORRECT_NAME, dreamly.name);
    }

    @Test
    public void testColor() {
        assertEquals(TEST_COLOR, dreamly.color);
    }

    @Test
    public void testSize() {
        assertEquals(TEST_SIZE, dreamly.size);
    }

    @Test
    public void testStrength() {
        assertEquals(TEST_STRENGTH, dreamly.strength);
    }

    @Test
    public void testCasing() {
        assertEquals(CORRECT_CASING, dreamly.getCasing());
    }

    @Test
    public void testSolution() {
        assertEquals(CORRECT_SOLUTION, dreamly.getSolution());
    }

    @Test
    public void testActive() {
        assertEquals(CORRECT_ACTIVE, dreamly.getActive());
    }

    @Test
    public void testManufactureProcess() {
        dreamly.manufacture();
        assertEquals(MANUFACTURE_FSTRING, getOutput());
    }

    private String getOutput() {
        System.out.flush();
        return baos.toString().replaceAll("\r", "");
    }
}
