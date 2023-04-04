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
        + "... \nReturning a good Dreamly GelCap pill\n";
    public static final String DREAMLY_BAD = "Creating a Dreamly pill " 
        + "... \nError during Dreamly production. Returning null\n";
    public static final String ACHEAWAY_GOOD = "Creating a AcheAway pill " 
        + "... \nReturning a good AcheAway GelCap pill\n";
    public static final String ACHEAWAY_BAD = "Creating a AcheAway pill " 
        + "... \nError during AcheAway production. Returning null\n";

    // field to store the new output location
    private GelCapFactory gcf;
    private ByteArrayOutputStream baos;
    private PrintStream oldOut;

    @BeforeEach
    public void beforeEach() {
        this.gcf = new GelCapFactoryMock();
	this.oldOut = System.out;
	this.baos = new ByteArrayOutputStream();
	System.setOut(new PrintStream(baos));
    }

    @Test
    public void testProduceDreamly() {
        // count of successes
        int s = 0;
	// count of failures
	int f = 0;

        Dreamly temp = null; 
        for (int i = 0; i < 100; i++) {
            temp = gcf.produceDreamly();
	        String o = getOutput();
            String og = "";
            if (o.length() == 395) {
                og = o.substring(0, 29) + o.substring(358, 394) + "\n";
            }
            String ob = "";
            if (o.length() > 395) {
                ob = o.substring(0,29) + o.substring(358, 406);
            }
	        if (DREAMLY_GOOD.equals(og)) {
                s++;
	        }
	        else if (DREAMLY_BAD.equals(ob)){
                f++;
	        }
	        else {
                fail("ERROR: Output was not as expected.\nExpected: " + DREAMLY_GOOD + "\nACTUAL: " + og + 
                    "\nACTUAL: " + ob + "\nACTUAL: " + o + "\nLength: " + o.length());
	        }
	    }
        assertTrue(temp instanceof Dreamly || temp == null);
        final int N_ONE = 85;
        final int N_TWO = 95;
	assertTrue(s >= N_ONE && s <= N_TWO);
    }

    @Test
    public void testProduceAcheAway() {
        // count of successes
        int s = 0;
	// count of failures
	int f = 0;

        AcheAway temp = null;
        for (int i = 0; i < 100; i++) {
            temp = gcf.produceAcheAway();
	        String o = getOutput();
            String og = "";
	        // Clear middle of output for testing
            if (o.length() == 432) {
	            og = o.substring(0, 30) + o.substring(394, 431) + "\n";
            }

            String ob = "";
            if (o.length() > 432) {
                ob = o.substring(0,30) + o.substring(394, 442) + "\n";
            }
	    if (ACHEAWAY_GOOD.equals(og)) {
                s++;
	    }
	    else if (ACHEAWAY_BAD.equals(ob)){
                f++;
	        }
	        else {
                fail("ERROR: Output was not as expected.\nExpected: " + ACHEAWAY_GOOD + "\nACTUAL: " + og +
                     "\nACTUAL: " + ob + "\nACTUAL: " + o + "\nLength: " + o.length());
	        }
	    }
        assertTrue(temp instanceof AcheAway || temp == null);
        final int N_ONE = 85;
        final int N_TWO = 95;
	assertTrue(s >= N_ONE && s <= N_TWO);
    }

    @AfterEach
    public void afterEach() {
        System.setOut(oldOut);
    }

    private String getOutput() {
        System.out.flush();
	String output = baos.toString().replaceAll("\r", "");
	baos.reset();
	return output;
    }

    private class GelCapFactoryMock extends GelCapFactory {
        protected Dreamly constructDreamly(String casing,
            String solution, String active) {
	    System.out.print("constructDreamly called.");
	    return new DreamlyMock(STRENGTH, SIZE, COLOR,
            SOLUTION, CASING, ACTIVE);
        }

        protected AcheAway constructAcheAway(String casing,
            String solution, String active) {
	    System.out.print("constructAcheAway called.");
	    return new AcheAwayMock(STRENGTH, SIZE, COLOR,
            SOLUTION, CASING, ACTIVE);
        }

        protected double getDreamlyStrength() {
	    System.out.print("getDreamly called.");
	    return 0;        
	}

        protected double getAcheAwayStrength() {
	    System.out.print("getAcheAway called.");
	    return 0;        
        }
    }
}
