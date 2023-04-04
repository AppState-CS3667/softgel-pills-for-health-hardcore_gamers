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
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.io.PrintStream;
import java.util.Scanner;

public class SoftGelPillStoreTest {
    // Private Fields
    private static final Scanner INPUT = new Scanner(System.in);
    private static final PrintStream OUTPUT = System.out;
    private SoftGelPillStore store;
    private SoftGelPillStore storeV2;

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
        assertFalse(storeV2.logOut());
    }
    // Test to make sure you can't
    // checkout without logging in
    @Test
    public void noCheckOutWithoutLogin() {
        assertNull(storeV2.checkOut());
    }
    // Test to make sure logOut works
    @Test
    public void successfulLogOut() {
        String n = "Mr. X";
        final int A = 7;
        storeV2.logIn(n, A);
        assertTrue(storeV2.logOut());
    }
    
}
