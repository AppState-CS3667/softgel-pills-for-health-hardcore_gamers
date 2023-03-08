package pills;

//Necessary Imports
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class GelCapTest {
    //Fields for testing
    public static final String NAME = "Mr. A";
    public static final double STRENGTH = 0.10;
    public static final double SIZE = 0.20;
    public static final String COLOR = "Salmon";
    public static final String CASING = "X";
    public static final String SOLUTION = "Y";
    public static final String ACTIVE = "Z";
    // field to store the new output location
    private GelCap gc;

    @BeforeEach
    public void beforeEach() {
        this.gc = new GelCapMock(NAME, STRENGTH, SIZE, COLOR);
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

    private class GelCapMock extends GelCap {
        public GelCapMock(String name, double strength,
            double size, String color) {
            super(name, strength, size, color);
        }
        protected void addCasing() {
            casing = "X";
            System.out.print("X\n");
        }
        protected void addSolution() {
            solution = "Y";
            System.out.print("Y\n");
        }
        protected void addActive() {
            active = "Z";
            System.out.print("Z\n");
        }
    }
}
