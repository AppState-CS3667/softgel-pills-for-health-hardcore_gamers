package pills;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * AdultChildFactoryTests class.
 * This class is used for testing 
 * the AdultGelCapFactoryTests 
 * and ChildGelCapFactoryTests classes.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public class AdultChildFactoryTests {
    private static final double ADULT_DREAMLY_STRENGTH = 5.2;
    private static final String DREAMLY_CASING = "Plasticizer";
    private static final String DREAMLY_SOLUTION = "Oil";
    private static final String DREAMLY_ACTIVE = "Zolpidem";
    private static final double CHILD_DREAMLY_STRENGTH = 1.25;
    private static final double ADULT_ACHEAWAY_STRENGTH = 825.00;
    private static final String ACHEAWAY_CASING = "Gelatin";
    private static final String ACHEAWAY_SOLUTION = "Saline";
    private static final String ACHEAWAY_ACTIVE = "Acetaminophen";
    private static final double CHILD_ACHEAWAY_STRENGTH = 415.00;

    private static final String ADULT_DREAMLY_PRINT = "Constructing adult "
        + "version of Dreamly\n";
    private static final String CHILD_DREAMLY_PRINT = "Constructing child "
        + "version of Dreamly\n";
    private static final String ADULT_ACHEAWAY_PRINT = "Constructing adult "
        + "version of AcheAway\n";
    private static final String CHILD_ACHEAWAY_PRINT = "Constructing child "
        + "version of AcheAway\n";

    private AdultGelCapFactory agcf;
    private ChildGelCapFactory cgcf;
    private ByteArrayOutputStream baos;
    private PrintStream oldOut;

    /*
     * initializes Adult and Child GelCapFactories, getting an instance of
     * each.
     * Sets System.out to a new PrintStream.
     * Initializes a ByteArrayOutputStream.
     */
    @BeforeEach
    public void beforeEach() {
        agcf = agcf.getInstance();
        cgcf = cgcf.getInstance();
        this.oldOut = System.out;
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    /*
     * Sets the out field of system back to System.out.
     */
    @AfterEach
    public void afterEach() {
        System.setOut(oldOut);
    }

    /*
     * Adult Dreamly strength should be 5.2.
     * Adult AcheAway strength should be 825.00.
     */
    @Test
    public void testAdultFactoryGetters() {
        assertEquals(ADULT_DREAMLY_STRENGTH, agcf.getDreamlyStrength());
        assertEquals(ADULT_ACHEAWAY_STRENGTH, agcf.getAcheAwayStrength());
    }

    /*
     * Child Dreamly strength should be 1.25.
     * Child AcheAway strength should be 415.00.
     */
    @Test
    public void testChildFactoryGetters() {
        assertEquals(CHILD_DREAMLY_STRENGTH, cgcf.getDreamlyStrength());
        assertEquals(CHILD_ACHEAWAY_STRENGTH, cgcf.getAcheAwayStrength());
    }

    /*
     * asserts that the Adult Dreamly constructor returns an Adult Dreamly 
     * instance.
     */
    @Test
    public void testAdultFactoryDreamlyConstructor() {
        assertTrue(agcf.constructDreamly(DREAMLY_CASING, DREAMLY_SOLUTION,
            DREAMLY_ACTIVE) instanceof Dreamly);
        assertEquals(ADULT_DREAMLY_PRINT, getOutput());
    }

    /*
     * asserts that the Adult AcheAway constructor returns an Adult 
     * AcheAway instance.
     */
    @Test
    public void testAdultFactoryAcheAwayConstructor() {
        assertTrue(agcf.constructAcheAway(ACHEAWAY_CASING, ACHEAWAY_SOLUTION,
            ACHEAWAY_ACTIVE) instanceof AcheAway);
        assertEquals(ADULT_ACHEAWAY_PRINT, getOutput());
    }

    /*
     * asserts that the Child Dreamly constructor returns a Child 
     * Dreamly instance.
     */
    @Test
    public void testChildFactoryDreamlyConstructor() {
        assertTrue(cgcf.constructDreamly(DREAMLY_CASING, DREAMLY_SOLUTION,
            DREAMLY_ACTIVE) instanceof Dreamly);
        assertEquals(CHILD_DREAMLY_PRINT, getOutput());
    }

    /*
     * asserts that the Child AcheAway constructor returns a Child
     * AcheAway instance.
     */
    @Test
    public void testChildFactoryAcheAwayConstructor() {
        assertTrue(cgcf.constructAcheAway(ACHEAWAY_CASING, ACHEAWAY_SOLUTION,
            ACHEAWAY_ACTIVE) instanceof AcheAway);
        assertEquals(CHILD_ACHEAWAY_PRINT, getOutput());
    }

    /*
     * asserts that the AdultGelCapFactory is a singleton.
     */
    @Test
    public void testAdultSingleton() {
        assertEquals(agcf.getInstance(), agcf.getInstance());
    }

    /*
     * asserts that the ChildGelCapFactory is a singleton.
     */
    @Test
    public void testChildSingleton() {
        assertEquals(cgcf.getInstance(), cgcf.getInstance());
    }
    /**
     * Test to confirm you can logout even if you have items
     * in the cart, as long as you are sure you want to check out.
     * 
     * @return x the string after flush
     */
    private String getOutput() {
        System.out.flush();
        return baos.toString().replaceAll("\r", "");
    }
}
