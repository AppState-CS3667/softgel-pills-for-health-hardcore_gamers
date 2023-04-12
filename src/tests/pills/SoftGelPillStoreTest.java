package pills;

/*
 * GelCap Class -
 * hardcore_gamers
 */

//Imports 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

public class SoftGelPillStoreTest {
    // Private Fields
    private static final Scanner INPUT = new Scanner(System.in);
    private static final PrintStream OUTPUT = System.out;
    private ByteArrayInputStream bais;
    private ByteArrayOutputStream baos;
    private PrintStream oldOut;
    private InputStream oldIn;
    private SoftGelPillStore store;

    @BeforeEach
    public void beforeEach() {
        this.store = new SoftGelPillStore();
        this.oldIn = System.in;
        this.oldOut = System.out;
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    @AfterEach
    public void afterEach() {
        System.setOut(oldOut);
        System.setIn(oldIn);
    }
    // Tests to make sure the constructors works as intended
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
    // Test to make sure input getter works as intended
    @Test
    public void testInputGetter() {
        this.store = new SoftGelPillStore(INPUT);
        assertEquals(INPUT, store.getInput());
    }
    // Test to make sure input setter works as intended
    @Test
    public void testInputSetter() {
        this.store = new SoftGelPillStore();
        store.setInput(INPUT);
        assertEquals(INPUT, store.getInput());
    }
    // Test to make sure output getter works as intended
    @Test
    public void testOutputGetter() {
        this.store = new SoftGelPillStore(OUTPUT);
        assertEquals(OUTPUT, store.getOutput());
    }
    // Test to make sure output setter works as intended
    @Test
    public void testOutputSetter() {
        this.store = new SoftGelPillStore();
        store.setOutput(OUTPUT);
        assertEquals(OUTPUT, store.getOutput());
    }
    // Test to make sure you can't
    // log out without logging in
    @Test
    public void noLogOutWithoutLogin() {
        assertFalse(store.logOut());
    }
    // Test to make sure you can't
    // checkout without logging in
    @Test
    public void noCheckOutWithoutLogin() {
        assertNull(store.checkOut());
    }
    // Tests the login with no args method
    @Test
    public void successfulLogin() {
        final String INPUT = "Mr.X\n27\n";
        bais = new ByteArrayInputStream(INPUT.getBytes());
        store.logIn();
        assertTrue(store.logOut());
    }
    // Test to make sure logOut works
    @Test
    public void successfulLogOut() {
        String n = "Mr. X";
        final int A = 27;
        store.logIn(n, A);
        assertTrue(store.logOut());
    }
    // Test make sure the order method is working properly
    @Test
    public void test() {
        String n = "Mr. X";
        final int A = 27;
        store.logIn(n, A);
        final String INPUT = "1";
        bais = new ByteArrayInputStream(INPUT.getBytes());
        System.setIn(bais);
        store.order();
        store.printCurrentOrder();
        assertNotEquals("[]", getOutput(),
            "Should not be empty");
    }
    @Test
    public void test2() {
        String n = "Mr. X";
        final int A = 27;
        store.logIn(n, A);
        final String INPUT = "1\n1\n1\n";
        bais = new ByteArrayInputStream(INPUT.getBytes());
        System.setIn(bais);
        store.order();
        store.order();
        store.order();
        GelCap[] x = store.checkOut();
        assertNotNull(x);
        assertNotEquals("[]", x.toString(),
            "Should not be empty");
    }
    private String getOutput() {
        System.out.flush();
        return baos.toString().replaceAll("\r", "");
    }
}
