package pills;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class GelCapFactoryTest {
    //Fields for testing
    public static final String NAME = "Mr. A";
    public static final double STRENGTH = 0.10;
    public static final double SIZE = 0.20;
    public static final String COLOR = "Salmon";
    public static final String CASING = "X";
    public static final String SOLUTION = "Y";
    public static final String ACTIVE = "Z";
    public static final String DreamlyCorrectOutput = "Creating a Dreamly pill ... \nReturning a good Dreamly"
        + " GelCap pill\n";
    public static final String DreamlyIncorrectOutput = "Creating a Dreamly pill ... \nError during Dreamly"
        + " production. Returning null\n";
    public static final String AcheAwayCorrectOutput = "Creating a AcheAway pill ... \nReturning a good AcheAway"
        + " GelCap pill\n";
    public static final String AcheAwayIncorrectOutput = "Creating a AcheAway pill ... \nError during AcheAway"
        + " production. Returning null\n";
    // field to store the new output location
    private GelCapFactory gcf;

    @BeforeEach
    public void beforeEach() {
        this.gcf = new GelCapFactoryMock();
    }

    @Test
    public void testProduceDreamly() {
        // count of successes
        int s = 0;
	// count of failures
	int f = 0;

        for (int i = 0; i < 100; i++) {
            Dreamly temp = gcf.produceDreamly();
	    if (temp instanceof Dreamly) {
                s++;
	    }
	    else {
                f++;
	    }
	}
        assertTrue(temp instanceof Dreamly || temp == null);
	assertTrue(s >= 85 && s <= 95);
    }

    @Test
    public void testProduceAcheAway() {
        // count of successes
        int s = 0;
	// count of failures
	int f = 0;

        for (int i = 0; i < 100; i++) {
            AcheAway temp = gcf.produceAcheAway();
	    if (constant.equals(getOutput())) {
                s++;
	    }
	    else if (badconstant.getOutput()){
                f++;
	    }
	    else {
                fail("string here to describe bad output");
	    }
	}
        assertTrue(temp instanceof AcheAway || temp == null);
	assertTrue(s >= 85 && s <= 95);
    }

    private class GelCapFactoryMock extends GelCapFactory {
        protected Dreamly constructDreamly(String casing, String solution, String active) {
	    System.out.print("constructDreamly called.");
	    return new DreamlyMock(STRENGTH, SIZE, COLOR, SOLUTION, CASING, ACTIVE);
        }

        protected AcheAway constructAcheAway(String casing, String solution, String active) {
	    System.out.print("constructAcheAway called.");
	    return new AcheAwayMock(STRENGTH, SIZE, COLOR, SOLUTION, CASING, ACTIVE);
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
