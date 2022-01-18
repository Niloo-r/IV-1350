package controller;

/**
 * Imports all the methods that are going to be needed in this class
 */

import model.*;
import view.FileLogger;
import view.TotalRevenueFileOutput;
import view.TotalRevenueView;
import dbHandler.InventorySystem;
import dbHandler.ItemNotFoundException;
import dbHandler.AccountingSystem;
import dbHandler.DatabaseErrorException;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Sale sale;
    private InventorySystem inventorySystem;
    private AccountingSystem accountingSystem;
    private CashRegister cashRegister;
    private double totalPrice;
    public TotalRevenueView TRV = new TotalRevenueView();
    private List<SaleObserver> saleObserver = new ArrayList<>();

    public Controller(InventorySystem inventorySystem, AccountingSystem accountingSystem, CashRegister cashRegister) {
        this.inventorySystem = inventorySystem;
        this.accountingSystem = accountingSystem;
        this.cashRegister = cashRegister;

    }

    public void startNewSale() {
        inventorySystem.reset();
        sale = new Sale(this.cashRegister);
        sale.addSaleObserver(TRV);
        TotalRevenueFileOutput fileOutput = new TotalRevenueFileOutput();
        fileOutput.setLogger(new FileLogger());
        sale.addSaleObserver(fileOutput);
    }

    public ItemDTO addItem(int itemIdentifier, int itemQuantity) throws
            ItemNotFoundException, CouldNotAddItemException {
        try {
            ItemDTO foundItem = inventorySystem.findItem(itemIdentifier);
            if(foundItem != null) {
                sale.addItem(foundItem, itemQuantity);
                return foundItem;
            } else {
                return null;
            }
        } catch (DatabaseErrorException exc) {
            throw new CouldNotAddItemException("Could not add the item.(Database error)", exc);
        }
    }

    public double pay (double amount) {
        double change = sale.pay(amount, totalPrice);
        return change;
    }

    public double showAllItemsRegistered() {
        totalPrice = sale.getRunningTotal();
        return sale.getRunningTotal();
    }

    public double discountRequest() {
        totalPrice = sale.calcDiscountedPrice();
        return totalPrice;
    }

    public Receipt receiptRequest() {
        Receipt receipt = new Receipt(sale, sale.getExistingItems());
        return receipt;
    }

    public void addSaleObserver(SaleObserver observer) {
        saleObserver.add(observer);
    }

}

