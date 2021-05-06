package dbHandler;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import dbHandler.Item;
import model.Sale;
import org.junit.*;
import util.Amount;

import static org.junit.Assert.*;

/**
 *
 * @author Erik
 */
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
     * Test of findItem method, of class InventorySystem. It checks if the item description (String)
     * of the inventory[0] matches the item description of found item. The findItem method checks the
     * if the itemIdentifiers match, if it does it returns an item.
     */
    @Test
    public void testFindItem() {
        ItemDTO inventory[] = new ItemDTO[2];
        inventory[0] = new ItemDTO(new Amount(10), 1, new Amount(4), 1);
        inventory[1] = new ItemDTO(new Amount(10),2, new Amount(4),1);
        InventorySystem inventorySystem = new InventorySystem();
        int itemIdentifier = 1;
        String foundItemDescription = inventorySystem.findItem(itemIdentifier).getItemDescription();
        assertEquals(inventory[0].getItemDescription(), foundItemDescription);
    }

    /**
     * Test for the method findItem, in the class InventorySystem.
     */
    @Test
    public void testFindItemNotExisting() {
        InventorySystem inventorySystem = new InventorySystem();
        int itemIdentifier = 2;
        assertEquals(null, inventorySystem.findItem(itemIdentifier));
    }

    /**
     * Test of saveSaleInformation method, of class InventorySystem.
     */
    @Test
    public void testSaveSaleInformation() {
        System.out.println("saveSaleInformation");
        Sale sale = null;
        InventorySystem instance = new InventorySystem();
        instance.saveSaleInfo(sale);

        String expResult = "Inventory system is updated";
        String result = outContent.toString();
        Assert.assertTrue(result.contains(expResult));
    }



}