package pills;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;		// import for new input location
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.io.PrintStream;
import java.util.Scanner;

public class SoftGelPillStoreTest {
    private static final Scanner INPUT = new Scanner(System.in);
    private static final PrintStream OUTPUT = System.out;
    private SoftGelPillStore store;
    private SoftGelPillStore storeV2;
    private InputStream oldIn;
    private ByteArrayInputStream bais;

    @BeforeEach
    public void beforeEach() {			// runs before every test
        this.storeV2 = new SoftGelPillStore();		// initialize object we are testing
        this.oldIn = System.in;			// save original System.in
    }

    @AfterEach
    public void afterEach() {			// runs after every test
        System.setIn(oldIn);			// resets System.in to the keyboard
    }

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

    @Test
    public void testInputGetter() {
        this.store = new SoftGelPillStore(INPUT);
        assertEquals(INPUT, store.getInput());
    }

    @Test
    public void testInputSetter() {
        this.store = new SoftGelPillStore();
        store.setInput(INPUT);
        assertEquals(INPUT, store.getInput());
    }

    @Test
    public void testOutputGetter() {
        this.store = new SoftGelPillStore(OUTPUT);
        assertEquals(OUTPUT, store.getOutput());
    }

    @Test
    public void testOutputSetter() {
        this.store = new SoftGelPillStore();
        store.setOutput(OUTPUT);
        assertEquals(OUTPUT, store.getOutput());
    }

    @Test
    public void noLogOutWithoutLogin()
    {
        assertFalse(storeV2.logOut());
    }

    @Test
    public void noCheckOutWithoutLogin()
    {
        assertNull(storeV2.checkOut());
    }

    @Test
    public void successfulLogOut()
    {
        storeV2.logIn("Mr. X", 27);
        assertTrue(storeV2.logOut());
    }
}
