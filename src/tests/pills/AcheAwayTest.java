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
 
    /*
     * initializes Adult, Child, and AcheAway mock by calling constructors.
     */
    @BeforeEach
    public void beforeEach() {
        this.ac = new AcheAwayMock(TEST_STRENGTH, TEST_SIZE, TEST_COLOR,
                               TEST_CASING, TEST_SOLUTION, TEST_ACTIVE);
        this.caa = new ChildAcheAway(TEST_CASING, TEST_SOLUTION, TEST_ACTIVE);
        this.aaa = new AdultAcheAway(TEST_CASING, TEST_SOLUTION, TEST_ACTIVE);
    }

    /*
     * Mock strength is 500.00
     * Adult strength is 825.00
     * Child strength is 415.00
     */
    @Test
    public void testStength() {
        assertEquals(TEST_STRENGTH, ac.getStrength());
        assertEquals(CHILD_STRENGTH, caa.getStrength());
        assertEquals(ADULT_STRENGTH, aaa.getStrength());
    }

    /*
     * Mock size is 5.00
     * Adult size is 8.25
     * Child size is 3.25
     */
    @Test
    public void testSize() {
        assertEquals(TEST_SIZE, ac.getSize());
        assertEquals(CHILD_SIZE, caa.getSize());
        assertEquals(ADULT_SIZE, aaa.getSize());
    }

    /*
     * Mock color is red
     * Adult color is white
     * Child color is cyan
     */
    @Test
    public void testColor() {
        assertEquals(TEST_COLOR, ac.getColor());
        assertEquals(CHILD_COLOR, caa.getColor());
        assertEquals(ADULT_COLOR, aaa.getColor());
    }

    /*
     * casing is gelatin
     */
    @Test
    public void testCasing() {
        assertEquals(TEST_CASING, ac.getCasing());
    }

    /*
     * solution is saline
     */
    @Test
    public void testSolution() {
        assertEquals(TEST_SOLUTION, ac.getSolution());
    }

    /*
     * acive is acetaminophen
     */
    @Test
    public void testActive() {
        assertEquals(TEST_ACTIVE, ac.getActive());
    }
}
