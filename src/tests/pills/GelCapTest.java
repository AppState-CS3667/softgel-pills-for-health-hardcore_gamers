package pills;

//Necessary Imports
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
//import pills.GelCap;
import org.junit.jupiter.api.AfterEach;
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
    public static final String TOSTRING_FSTRING = 
        String.format("%.2fmg %S pill", STRENGTH, NAME);
    public static final String DESCRIPTION_FSTRING = 
        String.format("%S Pill\n\tStrength: %.2f\n\tSize: %.2f\n\tColor: " 
        + "%S\n\tCasing: %S\n\tSolution: %S\n\tActive: %S",
        NAME, STRENGTH, SIZE, COLOR, CASING, SOLUTION, ACTIVE);
    public static final String MANUFACTURE_FSTRING = 
        String.format("Manufacturing... \n%S\n%S\n%S\n..." 
        + "completed manufacturing\n", CASING, SOLUTION, ACTIVE);

    // field to store the new output location
    private ByteArrayOutputStream baos;
    private PrintStream oldOut;	
    private GelCap gc;

    @BeforeEach
    public void beforeEach() {
        this.gc = new GelCapMock(NAME, STRENGTH, SIZE, COLOR);
        this.oldOut = System.out;
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    @AfterEach
    public void afterEach() {
        System.setOut(oldOut);
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
    @Test
    public void testToString() {
        System.out.print(gc.toString());
        assertEquals(TOSTRING_FSTRING, getOutput());
    }
    @Test
    public void testDescription() {
        System.out.print(gc.description());
        assertEquals(DESCRIPTION_FSTRING, getOutput());
    }
    @Test
    public void testManufactureProcess() {
        gc.manufacture();
        assertEquals(MANUFACTURE_FSTRING, getOutput());
    }

    private String getOutput() {
        System.out.flush();
        return baos.toString().replace("\r", "");
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
