package pills;

//Imports
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

/**
 * SoftGelPillStoreTest class.
 * This class is used for testing 
 * the SoftGelPillStore class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public class SoftGelPillStoreTest {
    // Private Fields
    private static final Scanner INPUT = new Scanner(System.in);
    private static final PrintStream OUTPUT = System.out;
    private ByteArrayOutputStream baos;
    private PrintStream oldOut;
    private ByteArrayInputStream bais;
    private InputStream oldIn;
    private SoftGelPillStore store;

    /*
     * Initializes a new SoftGelPillStore by calling constructors.
     * Initializes a new ByteArrayOutputStream.
     * Sets the out field of System to a new PrintStream.
     */
    @BeforeEach
    public void beforeEach() {
        this.store = new SoftGelPillStore();
        this.oldIn = System.in;
        this.oldOut = System.out;
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    /*
     * Tests to make sure the constructors works as intended.
     */
    @Test
    public void testConstructors() {
        this.store = new SoftGelPillStore(INPUT, OUTPUT);
        assertEquals(INPUT, store.getInput());
        assertEquals(OUTPUT, store.getOutput());
        this.store = new SoftGelPillStore(INPUT);
        assertEquals(INPUT, store.getInput());
        assertEquals(System.out, store.getOutput());
        this.store = new SoftGelPillStore(OUTPUT);
        assertEquals(OUTPUT, store.getOutput());
    }

    /*
     * Test to make sure input getter works as intended.
     */
    @Test
    public void testInputGetter() {
        this.store = new SoftGelPillStore(INPUT);
        assertEquals(INPUT, store.getInput());
    }

    /*
     * Test to make sure input setter works as intended.
     */
    @Test
    public void testInputSetter() {
        this.store = new SoftGelPillStore();
        store.setInput(INPUT);
        assertEquals(INPUT, store.getInput());
    }

    /*
     * Test to make sure output getter works as intended.
     */
    @Test
    public void testOutputGetter() {
        this.store = new SoftGelPillStore(OUTPUT);
        assertEquals(OUTPUT, store.getOutput());
    }

    /*
     * Test to make sure output getter works as intended.
     */
    @Test
    public void testOutputSetter() {
        this.store = new SoftGelPillStore();
        store.setOutput(OUTPUT);
        assertEquals(OUTPUT, store.getOutput());
    }

    /*
     * Test to make sure you can't
     * log out without logging in.
     */
    @Test
    public void noLogOutWithoutLogin() {
        assertFalse(store.logOut());
    }

    /*
     * Test to make sure you can't
     * checkout without logging in.
     */
    @Test
    public void noCheckOutWithoutLogin() {
        assertNull(store.checkOut());
    }

    /*
     * Tests the login with no args method.
     */
    @Test
    public void successfulLogin() {
        final String OURINPUT = "J\n27\n";
        bais = new ByteArrayInputStream(OURINPUT.getBytes());
        System.setIn(bais);
        store = new SoftGelPillStore();
        store.logIn();
        assertTrue(store.logOut());
    }

    /*
     * Test to make sure logOut works.
     */
    @Test
    public void successfulLogOut() {
        final String OURINPUT = "J\n27\n";
        bais = new ByteArrayInputStream(OURINPUT.getBytes());
        System.setIn(bais);
        store = new SoftGelPillStore();
        store.logIn();
        assertTrue(store.logOut());
    }

    /*
     * Test to make sure you can't logout
     * with an item in the cart without
     * confirming.
     */
    @Test
    public void failedLogOut() {
        final String OURINPUT = "J\n27\n1\nN\n";
        bais = new ByteArrayInputStream(OURINPUT.getBytes());
        System.setIn(bais);
        store = new SoftGelPillStore();
        store.logIn();
        store.order();
        boolean x = store.logOut();
        assertFalse(x);
    }

    /*
     * Test make sure the print order
     * method is working properly.
     */
    @Test
    public void testPrintOrder() {
        final String OURINPUT = "J\n27\n1\n";
        bais = new ByteArrayInputStream(OURINPUT.getBytes());
        System.setIn(bais);
        store = new SoftGelPillStore();
        store.logIn();
        store.order();
        baos.reset();
        store.printCurrentOrder();
        String y = getOutput();
        assertNotEquals("[]", y, "Shouldn't be empty");
    }

    /*
     * Test to assure that the checkout
     * method is working properly.
     */
    @Test
    public void successfulCheckOut() {
        final String OURINPUT = "J\n27\n1\n1\n2\n";
        bais = new ByteArrayInputStream(OURINPUT.getBytes());
        System.setIn(bais);
        store = new SoftGelPillStore();
        store.logIn();
        store.order();
        store.order();
        store.order();
        GelCap[] x = store.checkOut();
        assertNotNull(x);  
    }
    
    /*
     * Removes the \r characters from new output.
     * 
     * @return x the after flushing out \r character
     */
    private String getOutput() {
        System.out.flush();
        String x = baos.toString().replaceAll("\r", "");
        baos.reset();
        return x;
    }

    /*
     * Sets the out field of System back to System.out
     * Sets the in field of System back to System.in
     */
    @AfterEach
    public void afterEach() {
        System.setOut(oldOut);
        System.setIn(oldIn);
    }
}
