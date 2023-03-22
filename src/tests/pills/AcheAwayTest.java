package pills;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcheAwayTest {

    public static final String TEST_CASING = "gelatin";
    public static final String TEST_SOLUTION = "saline";
    public static final String TEST_ACTIVE = "acetaminophen";
    public static final double TEST_STRENGTH = 500.00;
    public static final double ADULT_STRENGTH = 825.00;
    public static final double CHILD_STRENGTH = 415.00;
    public static final String TEST_COLOR = "red";
    public static final String ADULT_COLOR = "white";
    public static final String CHILD_COLOR = "cyan";
    public static final double TEST_SIZE = 5.00;
    public static final double ADULT_SIZE = 8.50;
    public static final double CHILD_SIZE = 3.25;
    private AcheAway ac;
    private ChildAcheAway caa;
    private AdultAcheAway aaa;
 
    @BeforeEach
    public void beforeEach() {
        this.ac = new AcheAway(TEST_STRENGTH, TEST_SIZE, TEST_COLOR,
                               TEST_CASING, TEST_SOLUTION, TEST_ACTIVE);
        this.caa = new ChildAcheAway(CHILD_STRENGTH, CHILD_SIZE,
                                     CHILD_COLOR);
        this.aaa = new AdultAcheAway(ADULT_STRENGTH, ADULT_SIZE,
                                     ADULT_COLOR);
    }

    @Test
    public void testStength() {
        assertEquals(TEST_STRENGTH, ac.getStrength());
        assertEquals(CHILD_STRENGTH, caa.getStrength());
        assertEquals(ADULT_STRENGTH, aaa.getStrength());
    }

    @Test
    public void testSize() {
        assertEquals(TEST_SIZE, ac.getSize());
        assertEquals(CHILD_SIZE, caa.getSize());
        assertEquals(ADULT_SIZE, aaa.getSize());
    }

    @Test
    public void testColor() {
        assertEquals(TEST_COLOR, ac.getColor());
        assertEquals(CHILD_COLOR, caa.getColor());
        assertEquals(ADULT_COLOR, aaa.getColor());
    }

    @Test
    public void testCasing() {
        assertEquals(TEST_CASING, ac.getCasing());
    }

    @Test
    public void testSolution() {
        assertEquals(TEST_SOLUTION, ac.getSolution());
    }

    @Test
    public void testActive() {
        assertEquals(TEST_ACTIVE, ac.getActive());
    }

    private class AcheAwayMock extends AcheAway {
        public AcheAwayMock(double strength, double size,
                        String color, String casing,
                        String solution, String active) {
            super(strength, size, color, casing, solution, active);
        }
    }
}
