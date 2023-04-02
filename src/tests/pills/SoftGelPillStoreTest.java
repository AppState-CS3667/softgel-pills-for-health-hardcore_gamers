package pills;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.AfterEach;
import java.io.PrintStream;
import java.util.Scanner;

public class SoftGelPillStoreTest {
    private static final Scanner INPUT = new Scanner(System.in);
    private static final PrintStream OUTPUT = System.out;
    private SoftGelPillStore store;

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
}
