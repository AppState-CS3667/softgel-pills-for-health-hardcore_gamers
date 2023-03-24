package pills;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class ActiveTests {
    private AcetaminophenActive aceActive;
    private ZolpidemActive zolActive;
    private ByteArrayOutputStream baos;	
    private PrintStream oldOut;

    @BeforeEach
    public void beforeEach() 
    {			
        this.aceActive = new AcetaminophenActive();
        this.zolActive = new ZolpidemActive();		
        this.oldOut = System.out;
        this.baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }
    @AfterEach
    public void afterEach() 
    {
        System.setOut(oldOut);
    }

    private String getOutput()
    {
        System.out.flush();
        return baos.toString().replaceAll("\r", "");
    }
}
