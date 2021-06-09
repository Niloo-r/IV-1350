
package controller;

import dbHandler.AccountingSystem;
import dbHandler.DatabaseErrorException;
import dbHandler.InventorySystem;
import dbHandler.ItemNotFoundException;
import dbHandler.SystemCreator;
import model.CashRegister;
import model.ItemDTO;
import model.Receipt;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This testclass will test all the methods in the controller class
 */
public class ControllerTest {
        public ControllerTest() {
        }
        SystemCreator creator = new SystemCreator();
        InventorySystem inventorySystem = creator.getInventorySystem();
        AccountingSystem accountingSystem = creator.getAccountingSystem();
        CashRegister cashRegister = new CashRegister();
        Controller controller = new Controller(inventorySystem, accountingSystem, cashRegister);


        @Test
        public void addExistingItem() throws ItemNotFoundException, DatabaseErrorException, CouldNotAddItemException {
        controller.startNewSale();
        ItemDTO item = controller.addItem(0, 2);
        assertEquals(0, item.getItemIdentifier());
        }

        @Test
        public void addNonexistingItem() throws ItemNotFoundException, DatabaseErrorException, CouldNotAddItemException {
        controller.startNewSale();
        try {
        ItemDTO item = controller.addItem(5, 1);
        fail("Could find item that does not exist using an incorrect itemidentifier.");
        } catch (ItemNotFoundException exc) {
        assertTrue("Exception messsage",
        exc.getMessage().contains("Item with ID: " + 5 + " not found."));
        }

        }

        @Test
        public void showAllItemsRegistered() throws ItemNotFoundException, DatabaseErrorException, CouldNotAddItemException {

        controller.startNewSale();
        controller.addItem(0, 2);
        controller.pay(40);
        double totalPrice = controller.showAllItemsRegistered();
        assertEquals(16, totalPrice, 0.0);
        }

        @Test
        public void receiptRequest() {
        controller.startNewSale();
        Receipt receipt = controller.receiptRequest();
        assertNotNull(receipt);
        }
        }