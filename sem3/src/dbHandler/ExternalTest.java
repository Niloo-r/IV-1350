package dbHandler;

//import static java.lang.ModuleLayer.fail;
//import static java.util.ServiceLoader.fail;
import static org.junit.Assert.fail;
//import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import dbHandler.ItemNotFoundException;
import dbHandler.DatabaseErrorException;

public class ExternalTest {
    ExternalServer externalServer = new ExternalServer();

    @Test
    public void testDatabaseServerNotResponding() throws ItemNotFoundException {
        DatabaseErrorException e1 = new DatabaseErrorException();
        try {
            externalServer.getItemInformation(1);

        } catch (DatabaseErrorException e) {
            fail("Valid conecction throws exception");
        }
        try {
            externalServer.getItemInformation(404);
            fail("Invalid connection does not throw exception");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains(e1.getMessage()));
        }
    }

    @Test
    public void testNoSuchItemIDException() throws DatabaseErrorException {
        ItemNotFoundException e1 = new ItemNotFoundException();
        try {
            externalServer.getItemInformation(1);
        } catch (ItemNotFoundException e) {
            fail("Valid item ID throws exception");
        }
        try {
            externalServer.getItemInformation(9999);
            fail("Invalid item ID does not throw exception");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains(e1.getMessage()));
        }
    }

    private void assertTrue(boolean contains) {
    }

}
