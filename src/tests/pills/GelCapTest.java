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

        this.gc = new GelCapMock(NAME, STRENGTH, SIZE, COLOR, CASING, 
            SOLUTION, ACTIVE);

    }
    //Simple test to make sure that name is correct
    @Test
    public void testName() {
        assertEquals(NAME, gc.getName());
    }
    //Simple test to make sure that strength is correct
    @Test
    public void testStrength() {
        assertEquals(STRENGTH, gc.getStrength());
    }
    //Simple test to make sure that color is correct
    @Test
    public void testColor() {
        assertEquals(COLOR, gc.getColor());
    }
    //Simple test to make sure that size is correct
    @Test
    public void testSize() {
        assertEquals(SIZE, gc.getSize());
    }
    //Simple test to make sure that casing is correct
    @Test
    public void testCasing() {
        assertEquals(CASING, gc.getCasing());
    }
    //Simple test to make sure that solution is correct
    @Test
    public void testSolution() {
        assertEquals(SOLUTION, gc.getSolution());
    }
    //Simple test to make sure that active is correct
    @Test
    public void testActive() {
        assertEquals(ACTIVE, gc.getActive());
    }
    // Private Helper Class
    private class GelCapMock extends GelCap {
        public GelCapMock(String name, double strength,
            double size, String color, String casing, 
            String solution, String active) {

            super(name, strength, size, color, casing, solution, active);
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
        public void accept(Inspector insp) {
            
        }
    }
}
