package pills;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;	

public class DreamlyTest {
	private final String CORRECT_NAME = "Dreamly";
	private final String CORRECT_CASING = "plasticizer";
	private final String CORRECT_SOLUTION = "oil";
	private final String CORRECT_ACTIVE = "zolpiem";
	private final String MANUFACTURE_FSTRING = "Manufacturing...\nadding plasticizer casing\nadding oil solution\nadding zolpidem active\n...completed manufacturing";
    private Dreamly dreamly;
	private ByteArrayOutputStream baos;	
    private PrintStream oldOut;

    @BeforeEach
	public void beforeEach()
	{
		dreamly= new Dreamly(700, 0.5, "blue");
		this.oldOut = System.out;
        this.baos = new ByteArrayOutputStream();	
        System.setOut(new PrintStream(baos));	
	}

	@AfterEach
    public void afterEach() 
	{			
        System.setOut(oldOut);		
    }

	@Test
	public void testName()
	{
		assertEquals(CORRECT_NAME, dreamly.name);
	}

	@Test
	public void testColor()
	{
		assertEquals("blue", dreamly.color);
	}

	@Test
	public void testSize()
	{
		assertEquals(0.5, dreamly.size);
	}

	@Test
	public void testStrength()
	{
		assertEquals(700, dreamly.strength);
	}

	@Test
	public void testCasing()
	{
		assertEquals(CORRECT_CASING, dreamly.getCasing());
	}

	@Test
	public void testSolution()
	{
		assertEquals(CORRECT_SOLUTION, dreamly.getSolution());
	}

	@Test
	public void testActive()
	{
		assertEquals(CORRECT_ACTIVE, dreamly.getActive());
	}

	@Test
	public void testManufactureProcess()
	{
		dreamly.manufacture();			
        assertEquals(MANUFACTURE_FSTRING, getOutput());
	}

	private String getOutput() 
	{		
        System.out.flush();	
        return baos.toString().replaceAll("\r", "");     
    }
}
