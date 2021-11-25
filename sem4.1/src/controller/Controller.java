package controller;

import dbHandler.*;
import model.*;
import util.Amount;


public class Controller {
    private InventorySystem inventorySystem;
    private AccountingSystem accountingSystem;
    private model.DiscountRules discountRules;
    private ItemCatalog itemCatalog;
    private static Sale sale;
    private CashRegister cashRegister;
    private Printer printer;

    /**
     * systemCreator gets all classes that has to do with all the external system calls.
     * catalogCreator  gets all the classes that has to do with database calls
     * printer is the interface to printer
     */

    public Controller(SystemCreator systemCreator, CatalogCreator catalogCreator, Printer printer){

        this.inventorySystem = systemCreator.getInventorySystem();
        this.accountingSystem = systemCreator.getAccountingSystem();
        this.itemCatalog = catalogCreator.getItemCatalog();
        this.discountRules = catalogCreator.getDiscountCatalog();
        this.cashRegister = new CashRegister();
        this.printer = printer;
    }


    public static String displayTotal() {
        return sale.getTotal().getTotal().toString();
    }


    /**
     * a new sale is started
     */
    public void startNewSale (){
        this.sale = new Sale();
    }
    /**
     * when items are registered we will see if the item exists and if so we add it to the sale and return
     * the information about item and running total.
     * but if the item does not exists we just return the running total.
     * @return
     */

    public ItemDTO scanItem(int itemIdentifier, Amount quantity)throws
            ItemNotFoundException, CouldNotAddItemException {
        {
            try {
                ItemDTO foundItem = inventorySystem.findItem(itemIdentifier);
                if (foundItem != null) {
                    sale.scanItem(foundItem, quantity);
                    return foundItem;
                } else {
                    return null;
                }
            } catch (DatabaseErrorException exc) {
                throw new CouldNotAddItemException("Could not add the item.(Database error)", exc);
            }
        }
          /*  if (itemCatalog.itemExists(itemIdentifier)){
                Item item = itemCatalog.getItem(itemIdentifier, quantity);
                return sale.updateSale(item) + ", quantity: " + quantity.toString() +
                        ", running total: " + displayTotal();
            }
            else return "Item does not exist: running total; " + displayTotal();
        }
    }*/
    }

    public Sale getSale(){
        return this.sale;
    }

    public String displayTotalAndTax (){
        return "total including tax: " + sale.getTotal().getTotalAndTax().toString();
    }


    /**
     * In this part, the customer will perform the payment. the payment will update the balance of the cashRegister.
     * By that the external system will be updated so that the printer can creat the receipt and print it out.
     * @param paidAmount is the amount of money that the customer gives to the cashier.
     * @return is the total amount of the change that the customer should recieve.
     */

    public String pay(Amount paidAmount){
        Payment payment = new Payment(paidAmount, sale.getTotal());
        accountingSystem.savesSaleInfo(sale);
        inventorySystem.saveSaleInfo(sale);
        cashRegister.addPayment(payment);
        Receipt receipt = new Receipt(sale,payment);
        printer.printReceipt(receipt);
        sale = null;
        return "Change: " + payment.getChange().toString();
    }
}
