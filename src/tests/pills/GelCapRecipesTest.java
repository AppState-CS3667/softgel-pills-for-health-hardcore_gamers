package pills;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GelCapRecipesTest {
    private ByteArrayOutputStream baos;
    private PrintStream oldOut;

    @BeforeEach
    public void beforeEach() {
        this.oldOut = System.out;
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    @Test
    public void testCasings() {
        assertTrue(GelCapRecipes.CASINGS.get("Dreamly")
            instanceof PlasticizerCasing);
        assertTrue(GelCapRecipes.CASINGS.get("AcheAway")
            instanceof GelatinCasing);
    }

    @Test
    public void testSolutions() {
        assertTrue(GelCapRecipes.SOLUTIONS.get("Dreamly")
            instanceof OilSolution);
        assertTrue(GelCapRecipes.SOLUTIONS.get("AcheAway")
            instanceof SalineSolution);
    }

    @Test
    public void testActives() {
        assertTrue(GelCapRecipes.ACTIVES.get("Dreamly")
            instanceof ZolpidemActive);
        assertTrue(GelCapRecipes.ACTIVES.get("AcheAway") 
            instanceof AcetaminophenActive);
    }

    @AfterEach
    public void afterEach() {
        System.setOut(oldOut);
    }
}

