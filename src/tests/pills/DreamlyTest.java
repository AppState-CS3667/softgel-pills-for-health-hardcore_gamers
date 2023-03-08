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

    private static Dreamly AdultDreamly;
    private static Dreamly ChildDreamly;
    private static Dreamly MockDreamly;

    @BeforeEach
	public void beforeEach() {
        AdultDreamly = new Dreamly(ADULT_STRENGTH, ADULT_SIZE, ADULT_COLOR);
        ChildDreamly = new Dreamly(CHILD_STRENGTH, CHILD_SIZE, CHILD_COLOR);
        MockDreamly = new DreamlyMock(TEST_NAME, MOCK_STRENGTH, MOCK_SIZE, MOCK_COLOR);
    }

    @Test
    public void testMockName() {
        assertEquals(TEST_NAME, MockDreamly.getName());
    }

    @Test
    public void testMockColor() {
        assertEquals(MOCK_COLOR, MockDreamly.getColor());
    }

    @Test
    public void testMockSize() {
        assertEquals(MOCK_SIZE, MockDreamly.getSize());
    }

    @Test
    public void testStrength() {
        assertEquals(MOCK_STRENGTH, MockDreamly.getStrength());
    }

    @Test
    public void testAdultColor() {
        assertEquals(ADULT_COLOR, AdultDreamly.getColor());
    }

    @Test
    public void testAdultSize() {
        assertEquals(ADULT_SIZE, AdultDreamly.getSize());
    }

    @Test
    public void testAdultStrength() {
        assertEquals(ADULT_STRENGTH, AdultDreamly.getStrength());
    }

    @Test
    public void testChildColor() {
        assertEquals(CHILD_COLOR, ChildDreamly.getColor());
    }

    @Test
    public void testChildSize() {
        assertEquals(CHILD_SIZE, ChildDreamly.getSize());
    }

    @Test
    public void testChildStrength() {
        assertEquals(CHILD_STRENGTH, ChildDreamly.getStrength());
    }

    @Test
    public void testCasing() {
        assertEquals(TEST_CASING, MockDreamly.getCasing());
    }

    @Test
    public void testSolution() {
        assertEquals(TEST_SOLUTION, MockDreamly.getSolution());
    }

    @Test
    public void testActive() {
        assertEquals(TEST_ACTIVE, MockDreamly.getActive());
    }

    private class DreamlyMock extends Dreamly {
        public DreamlyMock(String name, double strength,
            double size, String color, String solution, String casing, String active) {
            super(name, strength, size, color, casing, solution, active);
        }
    }
}
