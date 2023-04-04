package pills;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GelCapFactoryTest {
    //Fields for testing
    public static final String NAME = "Mr. A";
    public static final double STRENGTH = 0.10;
    public static final double SIZE = 0.20;
    public static final String COLOR = "Salmon";
    public static final String CASING = "X";
    public static final String SOLUTION = "Y";
    public static final String ACTIVE = "Z";

    public static final String DREAMLY_GOOD = "Creating a Dreamly pill " 
        + "... \nReturning a good Dreamly GelCap Pill\n";
    public static final String DREAMLY_BAD = "Creating a Dreamly pill " 
        + "... \nError during Dreamly production. Returning null\n";
    public static final String ACHEAWAY_GOOD = "Creating a AcheAway pill " 
        + "... \nReturning a good AcheAway GelCap Pill\n";

    public static final String ACHEAWAY_BAD = "Creating a AcheAway pill " 
        + "... \nError during AcheAway production. Returning null\n";

    private GelCapFactory gcf;
    private ByteArrayOutputStream baos;
    private PrintStream oldOut;

    /* 
     * Initializes a GelCapFactoryMock, PrintStream, 
     * and ByteArrayOutputStream object.
     */
    @BeforeEach
    public void beforeEach() {
        this.gcf = new GelCapFactoryMock();
	this.oldOut = System.out;
	this.baos = new ByteArrayOutputStream();
	// Sets system.out to a new Prinstream object using baos.
	System.setOut(new PrintStream(baos));
    }

    /* 
     * Tests the produceDreamly method in GelCapFactory. 
     */
    @Test
    public void testProduceDreamly() {
        // count of successes
        int s = 0;
	// count of failures
	int f = 0;

        Dreamly temp = null; 
        for (int i = 0; i < 100; i++) {
	    // Call the produceDreamly method on the mock object
            temp = gcf.produceDreamly();

	    // o = String for output
	    String o = getOutput();

	    // og = String for good output (output if it returns a good Dreamly pill)  
            String og = "";

	    // Constants for the stringsubset methods to trim the output
            final int STR1START = 0;
            final int STR1END = 29;
            final int STR2START = 358;
            final int GOODOUTPUTLENGTH = 395;

            // if output is good pill
            if (o.length() == GOODOUTPUTLENGTH) {
                og = o.substring(STR1START, STR1END) + o.substring(STR2START);
            }

	    //if output is bad pill
            String ob = "";
            if (o.length() > GOODOUTPUTLENGTH) {
                ob = o.substring(STR1START, STR1END) + o.substring(STR2START);
            }

	    // if output is good and equals expected output
	    if (DREAMLY_GOOD.equals(og)) {
                s++;
	    }


	    // if output is bad and equals expected output
	    else if (DREAMLY_BAD.equals(ob)) {
                f++;
	    }

	    // Ouput failed. Prints error message
	    else {
                fail("ERROR: Output was not as expected.\nExpected: " 
                    + DREAMLY_GOOD + "\nACTUAL: " + og + "\nACTUAL: " + ob  
                    + "\nACTUAL: " + o + "\nLength: " + o.length());
	    }
        }
	// Test to make sure temp is either a Dreamly object or null
        assertTrue(temp instanceof Dreamly || temp == null);

	// Constants for testing successes
        final int N_ONE = 84;
        final int N_TWO = 96;

	assertTrue(s >= N_ONE && s <= N_TWO);
    }

    /* 
     * Tests the produceAcheAway method in GelCapFactory. 
     */
    @Test
    public void testProduceAcheAway() {
        // count of successes
        int s = 0;
	// count of failures
	int f = 0;

        AcheAway temp = null;
        for (int i = 0; i < 100; i++) {
	    // Call the produceDreamly method on the mock object
            temp = gcf.produceAcheAway();

	    // o = String for output
	    String o = getOutput();

	    // og = String for good output (output if it returns a good Dreamly pill)  
            String og = "";

	    // Constants for the stringsubset methods to trim the output
            final int STR1START = 0;
            final int STR1END = 30;
            final int STR2START = 394;
            final int GOODOUTPUTLENGTH = 432;

            // if output is good pill
            if (o.length() == GOODOUTPUTLENGTH) {
	        og = o.substring(STR1START, STR1END) + o.substring(STR2START);
            }

	    //if output is bad pill
            String ob = "";
            if (o.length() > GOODOUTPUTLENGTH) {
                ob = o.substring(STR1START, STR1END) + o.substring(STR2START);
            }

	    // if output is good and equals expected output
	    if (ACHEAWAY_GOOD.equals(og)) {
                s++;
	    }

	    // if output is bad and equals expected output
	    else if (ACHEAWAY_BAD.equals(ob)) {
                f++;
	    }

	    // Ouput failed. Prints error message
	    else {
                fail("ERROR: Output was not as expected.\nExpected: " 
                    + ACHEAWAY_GOOD + "\nACTUAL: " + og 
                    + "\nACTUAL: " + ob + "\nACTUAL: " + o + "\nLength: "
                     + o.length());
	    }
	}
	// Test to make sure temp is either a Dreamly object or null
        assertTrue(temp instanceof AcheAway || temp == null);

	// Constants for testing successes
        final int N_ONE = 84;
        final int N_TWO = 96;

	assertTrue(s >= N_ONE && s <= N_TWO);
    }

    /*
     * Sets system.out to the oldOut after each test
     */
    @AfterEach
    public void afterEach() {
        System.setOut(oldOut);
    }

    /*
     * Clears \r characters from output and resets baos after each call
     */
    private String getOutput() {
        System.out.flush();
	String output = baos.toString().replaceAll("\r", "");
	baos.reset();
	return output;
    }

    /*
     * A mock class for GelCapFactory.
     *
     * Implements abstract methods for testing purposes.
     */
    private class GelCapFactoryMock extends GelCapFactory {

  /**
	 * Constructs a new Dreamly mock object
	 */

        protected Dreamly constructDreamly(String casing,
            String solution, String active) {
	    System.out.print("constructDreamly called.");
	    return new DreamlyMock(STRENGTH, SIZE, COLOR,
            SOLUTION, CASING, ACTIVE);
        }


  /**
	 * Constructs a new AcheAway mock object
	 */
        protected AcheAway constructAcheAway(String casing,
            String solution, String active) {
	    System.out.print("constructAcheAway called.");
	    return new AcheAwayMock(STRENGTH, SIZE, COLOR,
            SOLUTION, CASING, ACTIVE);
        }

        /*
	 * gets the strength of a Dreamly pill
	 *
	 * for testing purposes this method returns 0
	 */
        protected double getDreamlyStrength() {
	    System.out.print("getDreamly called.");
	    return 0;        
	}

        /*
	 * gets the strength of a AcheAway pill
	 *
	 * for testing purposes this method returns 0
	 */
        protected double getAcheAwayStrength() {
	    System.out.print("getAcheAway called.");
	    return 0;        
        }
    }
}
