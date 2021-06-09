
package dbHandler;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import model.ItemDTO;
import model.Sale;
import org.junit.*;

import static org.junit.Assert.*;

public class InventorySystemTest {
    private ByteArrayOutputStream outContent;
    private PrintStream originalSysOut;


    public InventorySystemTest() {
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

    /**
     * @throws DatabaseErrorException
     * In this testclass, the method findItem in inventorySystem is tested. It will check if the item description
     * matches with the found item. If the item matches, the method will return the item.
     */
    @Test
    public void testFindItem() throws ItemNotFoundException, DatabaseErrorException{
        ItemDTO inventory[] = new ItemDTO[1];
        inventory[0] = new ItemDTO(10.0, 0, "Orange", 12.5, 0);
        InventorySystem inventorySystem = new InventorySystem();
        int itemIdentifier = 0;
        String foundItemDescription = inventorySystem.findItem(itemIdentifier).getItemDescription();
        assertEquals(inventory[0].getItemDescription(), foundItemDescription);
    }

    /**
     * The method findItem in InventorySystem class is tested.
     * @throws DatabaseErrorException
     */
    @Test
    public void testFindItemNotExisting() throws ItemNotFoundException, DatabaseErrorException{
        InventorySystem inventorySystem = new InventorySystem();
        int itemIdentifier = 5;

        try {
            ItemDTO foundItem = inventorySystem.findItem(itemIdentifier);
        } catch (ItemNotFoundException exc) {
            assertTrue("Exception message.", exc.getMessage()
                    .contains("Item with ID: " + itemIdentifier + " not found."));
        }
    }

    @Test
    public void testFindItemDatabaseError() throws ItemNotFoundException, DatabaseErrorException {
        InventorySystem inventorySystem = new InventorySystem();
        int itemIdentifier = 4;

        try {
            ItemDTO foundItem = inventorySystem.findItem(itemIdentifier);
        } catch (DatabaseErrorException exc) {
            assertTrue("Exception message.", exc.getMessage()
                    .contains("Database error. (Shown only to developers)"));
        }
    }
    /**
     * the method saveSaleInformation from the InventorySystem is tested.
     */
    @Test
    public void testSaveSaleInformation() {
        System.out.println("saveSaleInformation");
        Sale sale = null;
        InventorySystem instance = new InventorySystem();
        instance.saveSaleInformation(sale);

        String expResult = "(Inventorysystem is updated)";
        String result = outContent.toString();
        assertTrue(result.contains(expResult));
    }



}
