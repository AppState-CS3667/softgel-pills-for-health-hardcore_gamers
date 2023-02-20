import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcheAwayTest{
    public static final String CORRECT_NAME     = "AcheAway";
    public static final String CORRECT_CASING   = "Gelatin";
    public static final String CORRECT_SOLUTION = "Saline";
    public static final String CORRECT_ACTIVE   = "Acetaminophen";
    public static final String TEST_STRENGTH    = "2.00"
    public static final String TEST_COLOR       = "Red"
    public static final String TEST_SIZE        = "5.00"

    private AcheAway ac;
    
    @BeforeEach
    public void beforeEach(){
        ac = new AcheAway(TEST_STRENGTH, TEST_SIZE, TEST_COLOR);
    }

    @Test
    public void testName(){
        assertEquals(CORRECT_NAME, ac.getName());
    }

    @Test
    public void testStength(){
        
    }
}