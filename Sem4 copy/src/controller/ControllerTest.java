
package controller;

import integration.AccountingSystem;
import integration.DatabaseErrorException;
import integration.InventorySystem;
import integration.ItemNotFoundException;
import integration.SystemCreator;
import model.CashRegister;
import model.ItemDTO;
import model.Receipt;
import model.Sale;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
        fail("Could find item that doesnt exist with using an incorrect itemidentifier.");
        } catch (ItemNotFoundException exc) {
        assertTrue("Wrong exception messsage",
        exc.getMessage().contains("Item with ID: " + 5 + " not found."));
        }

        }



        @Test
        public void enoughPaidMoney() {
        controller.startNewSale();
        double change = controller.pay(1.0);
        assertEquals(1.0, change, 0.0);
        }

        @Test
        public void notEnoughMoneyPaid () {
        controller.startNewSale();
        double change = controller.pay(-10.0);
        assertEquals(-10.0, change, 0.0);
        }

        @Test
        public void indicateAllItemsRegistered() throws ItemNotFoundException, DatabaseErrorException, CouldNotAddItemException {

        controller.startNewSale();
        controller.addItem(0, 2);
        controller.pay(40);
        double totalPrice = controller.indicateAllItemsRegistered();
        assertEquals(16, totalPrice, 0.0);
        }

        @Test
        public void requestReceipt() {
        controller.startNewSale();
        Receipt receipt = controller.requestReceipt();
        assertNotNull(receipt);
        }
        }