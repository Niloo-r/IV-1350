package model;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    private ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();
    private ArrayList<Integer> itemQuantity = new ArrayList<Integer>();
    private double runningTotal = 0.0;
    private double change;
    private double payment;
    CashRegister cashRegister;
    boolean itemFlag = false;
    boolean discountFlag = false;
    private List<SaleObserver> saleObservers = new ArrayList<>();

    public Sale(CashRegister cashRegister){
        this.cashRegister = cashRegister;
    }

    public void addItem(ItemDTO item, int quantity) {
        if(itemList.isEmpty()) {
            itemList.add(item);
            itemList.get(0).updateQuantity(quantity);
            itemFlag = true;
        }
        for(int i = 0; i < itemList.size(); i++) {
            if(itemAlreadyScanned(item, i)) {
                itemList.get(i).updateQuantity(quantity);
                itemFlag = true;
            }
        }
        if(!itemFlag){
            item.updateQuantity(quantity);
            itemList.add(item);
        }

        itemFlag = false;
        calculateRunningTotal(item, quantity);
    }

    public double pay(double payment, double newTotalPrice) {
        //runningTotal = calcDiscountedPrice();
        change = cashRegister.calculateChange(payment, newTotalPrice);
        this.payment = payment;
        cashRegister.addPayment(payment - change);
        notifyObservers();
        return change;
    }

    private boolean itemAlreadyScanned(ItemDTO item, int i) {
        if (item.getItemIdentifier() == itemList.get(i).getItemIdentifier() && itemFlag == false){
            return true;
        }
        else
            return false;
    }

    private void calculateRunningTotal(ItemDTO foundItem, int itemQuantity) {
        this.runningTotal += foundItem.getPrice() * itemQuantity;
    }

    public double getRunningTotal() {
        if(!discountFlag) {
            return this.runningTotal;
        } else {
            return runningTotal * 0.5;
        }
    }

    public ArrayList<ItemDTO> getItemList() {
        return itemList;
    }

    public int getExistingItems() {
        return itemList.size();
    }

    public double getChange() {
        return Math.round(change * 100.0) / 100.0;
    }

    public double getAmountPaid() {
        return payment;
    }

    public ArrayList<Integer> getItemQuantityList() {
        return this.itemQuantity;
    }

    public double calcDiscountedPrice() {
        discountFlag = true;
        return this.runningTotal * 0.5;
    }

    /**
     * An observer to the saleObservers list is added.
     * @param saleObs is the observer to be added to the list.
     */
    public void addSaleObserver(SaleObserver saleObs) {
        saleObservers.add(saleObs);
    }

    /**
     * The observers that have been specified will be notified when a sale has been paid for.
     * @param observers Are the observers that will be notified.
     */
    public void addSaleObservers(List<SaleObserver> observers) {
        saleObservers.addAll(observers);
    }

    private void notifyObservers() {
        for(SaleObserver obs: saleObservers) {
            obs.newPayment(this.cashRegister.getBalance());
        }
    }
}
