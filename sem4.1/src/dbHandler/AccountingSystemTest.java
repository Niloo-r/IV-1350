package dbHandler;



import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import model.Sale;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountingSystemTest {
    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;

    public AccountingSystemTest() {
    }


    @Before
    public void setUpStreams() {
        originalSysOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }
    @After
    public void cleanUpStreams() {
        outContent = null;
        System.setOut(originalSysOut);
    }


    @Test
    public void testSavesSaleInformation() {

        Sale sale = null;
        AccountingSystem instance = new AccountingSystem();
        instance.savesSaleInfo(sale);
        String expResult = "Accountingsystem updated!";
        String result = outContent.toString();
        assertTrue(result.contains(expResult));
    }

}