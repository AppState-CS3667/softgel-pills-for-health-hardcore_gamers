package pills;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class DreamlyTest {
    private static final String TEST_NAME = "D";
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

    @BeforeEach
	public void beforeEach() {
        adultDreamly = new Dreamly(ADULT_STRENGTH, ADULT_SIZE, ADULT_COLOR);
        childDreamly = new Dreamly(CHILD_STRENGTH, CHILD_SIZE, CHILD_COLOR);
        mockDreamly = new DreamlyMock(TEST_NAME, MOCK_STRENGTH,
            MOCK_SIZE, MOCK_COLOR);
    }

    @Test
    public void testMockName() {
        assertEquals(TEST_NAME, mockDreamly.getName());
    }

    @Test
    public void testMockColor() {
        assertEquals(MOCK_COLOR, mockDreamly.getColor());
    }

    @Test
    public void testMockSize() {
        assertEquals(MOCK_SIZE, mockDreamly.getSize());
    }

    @Test
    public void testStrength() {
        assertEquals(MOCK_STRENGTH, mockDreamly.getStrength());
    }

    @Test
    public void testAdultColor() {
        assertEquals(ADULT_COLOR, adultDreamly.getColor());
    }

    @Test
    public void testAdultSize() {
        assertEquals(ADULT_SIZE, adultDreamly.getSize());
    }

    @Test
    public void testAdultStrength() {
        assertEquals(ADULT_STRENGTH, adultDreamly.getStrength());
    }

    @Test
    public void testChildColor() {
        assertEquals(CHILD_COLOR, childDreamly.getColor());
    }

    @Test
    public void testChildSize() {
        assertEquals(CHILD_SIZE, childDreamly.getSize());
    }

    @Test
    public void testChildStrength() {
        assertEquals(CHILD_STRENGTH, childDreamly.getStrength());
    }

    @Test
    public void testCasing() {
        assertEquals(TEST_CASING, mockDreamly.getCasing());
    }

    @Test
    public void testSolution() {
        assertEquals(TEST_SOLUTION, mockDreamly.getSolution());
    }

    @Test
    public void testActive() {
        assertEquals(TEST_ACTIVE, mockDreamly.getActive());
    }

    private class DreamlyMock extends Dreamly {
        public DreamlyMock(String name, double strength,
            double size, String color, 
                String solution, String casing, String active) {
            super(name, strength, size, color, casing, solution, active);
        }
    }
}
