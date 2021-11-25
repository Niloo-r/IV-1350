package controller;

import model.CashRegister;
import model.Sale;
import org.junit.AfterClass;
import org.junit.jupiter.api.Test;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;



import dbHandler.CatalogCreator;
import dbHandler.Printer;
import dbHandler.SystemCreator;
import util.Amount;
import dbHandler.*;




    public class ControllerTest {
        public ControllerTest() {
        }


        SystemCreator systemCreator = new SystemCreator();
        CatalogCreator catalogCreator = new CatalogCreator();
        Printer printer = new Printer();
        Controller controller = new Controller( systemCreator, catalogCreator, printer);



    @org.junit.Test
    public void addExistingItem() throws ItemNotFoundException, DatabaseErrorException, CouldNotAddItemException {
        controller.startNewSale();
        ItemDTO item = controller.scanItem(0, new Amount(2));
        assertEquals(0, item.getItemIdentifier());
    }

    @org.junit.Test
    public void addNonexistingItem() throws ItemNotFoundException, DatabaseErrorException, CouldNotAddItemException {
        controller.startNewSale();
        try {
            ItemDTO item = controller.scanItem(5, new Amount(2));
            fail("Could find item that doesnt exist with using an incorrect itemidentifier.");
        } catch (ItemNotFoundException exc) {
            assertTrue("Wrong exception messsage",
                    exc.getMessage().contains("Item with ID: " + 5 + " not found."));
        }

    }


    @AfterClass
    public static void tearDownClass() {
    }
    @Test
    public void registerItem() throws CouldNotAddItemException, ItemNotFoundException {
        controller = new Controller(new SystemCreator(), new CatalogCreator(), new Printer());
        controller.startNewSale();
        int itemName = 1;
        int price = 20;
        int taxAmount = 10;
        ItemDTO actualResult = controller.scanItem(0, new Amount(2));
        Sale s1 = controller.getSale();
        assertTrue(s1.getItems().containsKey(itemName));
    }

    @Test
    public void displayTotalWithTax() throws CouldNotAddItemException, ItemNotFoundException {
        controller = new Controller(new SystemCreator(), new CatalogCreator(), new Printer());
        controller.startNewSale();
        int itemName = 3;
        Amount price = new Amount(20);
        Amount taxAmount = new Amount(10);
        controller.scanItem(itemName, new Amount(1));
        String actualResult = controller.displayTotalAndTax();
        String expectedResult = "total including tax: " + price.plus(taxAmount);
        assertEquals((String) expectedResult, actualResult, "Total including tax not equal to the expected result");
    }

    @Test
    public void pay() throws CouldNotAddItemException, ItemNotFoundException {
        controller = new Controller(new SystemCreator(), new CatalogCreator(), new Printer());
        controller.startNewSale();
        int itemName = 3;
        Amount price = new Amount(20);
        Amount taxAmount = new Amount(10);
        controller.scanItem( itemName, new Amount(1));
        Amount paidAmount = new Amount(890);
        String expectedResult = "Change: " + paidAmount.minus(price.plus(taxAmount));
        String actualResult = controller.pay(paidAmount);
        assertEquals((String) expectedResult, actualResult,"Change amount invalid!");
    }
}