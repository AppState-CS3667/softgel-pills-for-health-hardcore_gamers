package pills;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    // field to store the new output location
    private GelCapFactory gcf;

    @BeforeEach
    public void beforeEach() {
        this.gcf = new GelCapFactoryMock();
    }

    @Test
    public void testName() {
        assertEquals(NAME, gc.getName());
    }

    @Test
    public void testStrength() {
        assertEquals(STRENGTH, gc.getStrength());
    }

    @Test
    public void testColor() {
        assertEquals(COLOR, gc.getColor());
    }

    @Test
    public void testSize() {
        assertEquals(SIZE, gc.getSize());
    }

    @Test
    public void testCasing() {
        assertEquals(CASING, gc.getCasing());
    }

    @Test
    public void testSolution() {
        assertEquals(SOLUTION, gc.getSolution());
    }
    @Test
    public void testActive() {
        assertEquals(ACTIVE, gc.getActive());
    }

    private class GelCapFactoryMock extends GelCapFactory {
        public Dreamly produceDreamly() {

	}

        public AcheAway produceAcheAway() {

	}

        protected Dreamly constructDreamly(String casing, String solution, String active) {
            solution = "Y";
            System.out.print("Y\n");
        }

        protected AcheAway constructAcheAway(String casing, String solution, String active) {
            solution = "Y";
            System.out.print("Y\n");
        }

        protected double getDreamlyStrength() {
        }

        protected double getAcheAwayStrength() {
        }
    }
}
