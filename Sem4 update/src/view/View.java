package view;

import controller.CouldNotAddItemException;
import controller.Controller;
import dbHandler.ItemNotFoundException;

import java.io.IOException;
import java.lang.Math;
import model.ItemDTO;
import model.Receipt;

public class View {
    private Controller controller;
    private FileLogger fileLogger;



    public View(Controller controller) {
        this.controller = controller;
        controller.addSaleObserver(new TotalRevenueView());
        TotalRevenueFileOutput fileOutput = new TotalRevenueFileOutput();
        this.fileLogger = new FileLogger();
        fileOutput.setLogger(this.fileLogger);
        controller.addSaleObserver(fileOutput);

    }

    public void addItem(int itemId, int quantity){
        try {
            ItemDTO currentItem = controller.addItem(itemId, quantity);
            printItemOnScreen(currentItem, quantity);

        } catch (ItemNotFoundException exc) {
            fileLogger.log(exc.getMessage());
        }
        catch (CouldNotAddItemException exc) {
            fileLogger.log(exc.getMessage());
        }

        //allt annat exceptions 
        catch(Exception exc){
            fileLogger.log(exc.getMessage());
        }
    }

    public void runSale() {
        controller.startNewSale();
        System.out.println("New sale was started.");
    }

    public void pay(double amount) {
        double amountPaid = amount;
        double change = controller.pay(amount);
        printChange(amountPaid, change);
    }

    public void discountRequest(int customerId) {
        double newTotalPrice = controller.discountRequest();
        printDiscountedPrice(newTotalPrice);
    }

    private void printItemOnScreen(ItemDTO IDTO, int quantity) {
        double runningTotal = controller.showAllItemsRegistered();
        System.out.println("Item: " + IDTO.getItemDescription() + " x" + quantity + " Price: " + IDTO.getPrice() * quantity + " Running Total: " + runningTotal);
    }

    private void printDiscountedPrice(double price) {
        System.out.println("Price including discount: " + price);
    }

    private void printChange(double amountPaid, double change) {
        System.out.println("Amount paid : " + amountPaid + " Change: " + Math.round(change * 100.0) / 100.0);
    }

    public Receipt receiptRequest() {
        Receipt receipt = controller.receiptRequest();
        return receipt;
    }
}
