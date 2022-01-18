package model;

import java.util.ArrayList;
import java.util.List;

public class CashRegister {
    private List<SaleObserver> saleObserver = new ArrayList<>();
    private double balance = 0.0;

    public CashRegister() {
        this.balance = 0;

    }

    public void addPayment(double payment) {
        this.balance += payment;
    }

    public double calculateChange(double payment, double cost) {
        return payment - cost;
    }

    public double getBalance() {
        return balance;
    }

    /*private void notifyObservers() {
        for (SaleObserver observer : saleObserver) {
            observer.totalRevenue(this.balance);

        }
    }*/
    public void addRegisterObserver(List<SaleObserver> observers) {
        saleObserver.addAll(observers);
    }
}
