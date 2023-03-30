package pills;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class DreamlyTest {
    private static final String TEST_NAME = "Dreamly";
    private static final String TEST_CASING = "X";
    private static final String TEST_SOLUTION = "Y";
    private static final String TEST_ACTIVE = "Z";
    private static final double ADULT_STRENGTH = 5.20;
    private static final double ADULT_SIZE = 12.24;
    private static final String ADULT_COLOR = "tan";
    private static final double CHILD_STRENGTH = 1.25;
    private static final double CHILD_SIZE = 4.5;
    private static final String CHILD_COLOR = "fuchsia";
    private static final double MOCK_STRENGTH = 700;
    private static final double MOCK_SIZE = 0.5;
    private static final String MOCK_COLOR = "blue";

    private static Dreamly adultDreamly;
    private static Dreamly childDreamly;
    private static Dreamly mockDreamly;

    /*
     * initializes Adult, Child, and Dreamly mock by calling constructors.
     */
    @BeforeEach
	public void beforeEach() {
        adultDreamly = new AdultDreamly(TEST_CASING, TEST_SOLUTION, 
            TEST_ACTIVE);
        childDreamly = new ChildDreamly(TEST_CASING, TEST_SOLUTION, 
            TEST_ACTIVE);
        mockDreamly = new DreamlyMock(MOCK_STRENGTH, MOCK_SIZE, 
            MOCK_COLOR, TEST_SOLUTION, TEST_CASING, TEST_ACTIVE);
    }

    /*
     * Dreamly name is Dreamly.
     */
    @Test
    public void testMockName() {
        assertEquals(TEST_NAME, mockDreamly.getName());
    }

    /*
     * Dreamly color is blue.
     */
    @Test
    public void testMockColor() {
        assertEquals(MOCK_COLOR, mockDreamly.getColor());
    }

    /*
     * Dreamly size is 0.5
     */
    @Test
    public void testMockSize() {
        assertEquals(MOCK_SIZE, mockDreamly.getSize());
    }

    /*
     * Dreamly strength is 700.
     */
    @Test
    public void testStrength() {
        assertEquals(MOCK_STRENGTH, mockDreamly.getStrength());
    }

    /*
     * Adult Dreamly color is tan.
     */
    @Test
    public void testAdultColor() {
        assertEquals(ADULT_COLOR, adultDreamly.getColor());
    }

    /*
     * Adult Dreamly size is 12.24.
     */
    @Test
    public void testAdultSize() {
        assertEquals(ADULT_SIZE, adultDreamly.getSize());
    }

    /*
     * Adult Dreamly strength is 5.20.
     */
    @Test
    public void testAdultStrength() {
        assertEquals(ADULT_STRENGTH, adultDreamly.getStrength());
    }

    /*
     * Child Dreamly color is fuschia.
     */
    @Test
    public void testChildColor() {
        assertEquals(CHILD_COLOR, childDreamly.getColor());
    }

    /*
     * Child Dreamly size is 4.5.
     */
    @Test
    public void testChildSize() {
        assertEquals(CHILD_SIZE, childDreamly.getSize());
    }

    /*
     * Child Dreamly strength is 1.25.
     */
    @Test
    public void testChildStrength() {
        assertEquals(CHILD_STRENGTH, childDreamly.getStrength());
    }

    /*
     * Dreamly casing is X.
     */
    @Test
    public void testCasing() {
        assertEquals(TEST_CASING, mockDreamly.getCasing());
    }

    /*
     * Dreamly solution is Y.
     */
    @Test
    public void testSolution() {
        assertEquals(TEST_SOLUTION, mockDreamly.getSolution());
    }

    /*
     * Dreamly active is Z.
     */
    @Test
    public void testActive() {
        assertEquals(TEST_ACTIVE, mockDreamly.getActive());
    }

    private class DreamlyMock extends Dreamly {

        public DreamlyMock(double strength,
            double size, String color, String solution, 
            String casing, String active) {
            super(strength, size, color, casing, solution, active);

        }
    }
}
