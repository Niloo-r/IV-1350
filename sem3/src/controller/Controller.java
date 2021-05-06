package controller;

import dbHandler.*;
import model.*;
import util.Amount;

import java.util.HashMap;
import java.util.List;


public class Controller {
    private InventorySystem inventorySystem;
    private AccountingSystem accountingSystem;
    private model.DiscountRules discountRules;
    private ItemCatalog itemCatalog;
    private Sale sale;
    private CashRegister cashRegister;
    private Printer printer;

    /**
    * @param systemCreator uses to get all classes that has to do with all the external system calls.
    * @param catalogCreator uses to get all the classes that has to do with database calls
    * @param printer is the interface to printer
     */

    public Controller(SystemCreator systemCreator, CatalogCreator catalogCreator, Printer printer){

        this.inventorySystem = systemCreator.getInventorySystem();
        this.accountingSystem = systemCreator.getAccountingSystem();
        this.itemCatalog = catalogCreator.getItemCatalog();
        this.discountRules = catalogCreator.getDiscountCatalog();
        this.cashRegister = new CashRegister();
        this.printer = printer;
    }

    /**
     * starting a new sale
     */
    public void startNewSale (){
        this.sale = new Sale();
    }
    /**
     * when items are registered we will see if the item exists and if so we add it to the sale and return
     * the information about item and running total.
     * but if the item does not exists we just return the running total.
     */

    public String scanItem(String itemIdentifier, Amount quantity){
        if (itemCatalog.itemExists(itemIdentifier)){
            Item item = itemCatalog.getItem(itemIdentifier, quantity);
            return sale.updateSale(item) + ", quantity: " + quantity.toString() +
                    ", running total: " + displayTotal();
        }
       else return "Item does not exist: running total; " + displayTotal();
    }

    public Sale getSale(){
        return this.sale;
    }

    public String displayTotalAndTax (){
        return "total including tax: " + sale.getTotal().getTotalAndTax().toString();
    }
    private String displayTotal(){
        return sale.getTotal().getTotal().toString();
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
