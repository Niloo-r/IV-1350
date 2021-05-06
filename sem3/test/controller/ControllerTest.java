package controller;

import dbHandler.Item;
import model.Sale;
import org.junit.AfterClass;
import org.junit.Before;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;



    import dbHandler.CatalogCreator;
    import dbHandler.Printer;
    import dbHandler.SystemCreator;
import util.Amount;

public class ControllerTest {

    private Controller controller;

    @AfterClass
    public static void tearDownClass() {
    }
        @Test
        public void registerItem() {
            controller = new Controller(new SystemCreator(), new CatalogCreator(), new Printer());
            controller.startNewSale();
            String itemName = "tandkräm";
            Amount price = new Amount(20);
            Amount taxAmount = new Amount(10);
            String actualResult = controller.scanItem(itemName, new Amount(1));
            Sale s1 = controller.getSale();
            assertTrue(s1.getItems().containsKey(itemName));
        }

        @Test
        public void displayTotalWithTax() {
            controller = new Controller(new SystemCreator(), new CatalogCreator(), new Printer());
            controller.startNewSale();
            String itemName = "tandkräm";
            Amount price = new Amount(20);
            Amount taxAmount = new Amount(10);
            controller.scanItem(itemName, new Amount(1));
            String actualResult = controller.displayTotalAndTax();
            String expectedResult = "total including tax: " + price.plus(taxAmount);
            assertEquals((Object) expectedResult, actualResult, "Total including tax not equal to the expected result");
        }

        @Test
        public void pay() {
            controller = new Controller(new SystemCreator(), new CatalogCreator(), new Printer());
            controller.startNewSale();
            String itemName = "tandkräm";
            Amount price = new Amount(20);
            Amount taxAmount = new Amount(10);
            controller.scanItem(itemName, new Amount(1));
            Amount paidAmount = new Amount(890);
            String expectedResult = "Change: " + paidAmount.minus(price.plus(taxAmount));
            String actualResult = controller.pay(paidAmount);
            assertEquals((Object) expectedResult, actualResult,"Change amount invalid!");
        }
    }
