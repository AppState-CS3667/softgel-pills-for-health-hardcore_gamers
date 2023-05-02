package pills;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * GelCapRecipesTest class.
 * This class is used for testing 
 * the GelCapRecipes class.
 * 
 * @author hardcore_gamers
 * @version 05/01/2023
 */
public class GelCapRecipesTest {
    private ByteArrayOutputStream baos;
    private PrintStream oldOut;

    /*
     * Initializes a new ByteArrayOutputStream.
     * Sets the out field of System to a new PrintStream.
     */
    @BeforeEach
    public void beforeEach() {
        this.oldOut = System.out;
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    /*
     * Test that GelCapRecipes Casings are correct.
     */
    @Test
    public void testCasings() {
        assertTrue(GelCapRecipes.CASINGS.get("Dreamly")
            instanceof CasingGenerator);
        assertTrue(GelCapRecipes.CASINGS.get("AcheAway")
            instanceof CasingGenerator);
    }

    /*
     * Test that GelCapRecipes Solutions are correct.
     */
    @Test
    public void testSolutions() {
        assertTrue(GelCapRecipes.SOLUTIONS.get("Dreamly")
            instanceof SolutionGenerator);
        assertTrue(GelCapRecipes.SOLUTIONS.get("AcheAway")
            instanceof SolutionGenerator);
    }

    /*
     * Test that GelCapRecipes Actives are correct.
     */
    @Test
    public void testActives() {
        assertTrue(GelCapRecipes.ACTIVES.get("Dreamly")
            instanceof ActiveGenerator);
        assertTrue(GelCapRecipes.ACTIVES.get("AcheAway") 
            instanceof ActiveGenerator);
    }

    /*
     * Sets the out field of System back to System.out
     */
    @AfterEach
    public void afterEach() {
        System.setOut(oldOut);
    }
}

