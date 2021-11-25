package model;

/**
 * An interface is created for the sales object that will handle payments.
 */
public interface SaleObserver {
    /**
     * This will be called when the payment happens.
     * @param amount is the sale that was paid for.
     */
    void newPayment (double amount);

}
