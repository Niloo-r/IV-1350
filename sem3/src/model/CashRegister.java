package model;

import util.Amount;

/**
 * Represents a cash register
 */
public class CashRegister {
    private Amount balance;

    /**
     * Cash register is created with the balance 0.
     */
    public CashRegister(){
        this.balance = new Amount(0);
    }

    /**
     * gets the value of balance and return the value.
     */
    public Amount getBalance() {
        return balance;
    }

    /**
     * the balance will get updated with the specified payment.
     */
    public void addPayment(Payment payment){
        balance = balance.plus(payment.getTotal().getTotalAndTax());
    }
}
