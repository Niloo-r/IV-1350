package DTO;

import java.util.LinkedList;

import dbHandler.Item;

public class TransactionInformationDTO {
    LinkedList<Item> cart = new LinkedList<Item>();
    double payment = 0;
    double change = 0;

    public TransactionInformationDTO(LinkedList<Item> cart, double payment, double change) {
        this.cart = cart;
        this.payment = payment;
        this.change = change;
    }

    /*
     * Gets the change for the transaction.
     *
     * @return The change.
     */
    public double getChange() {
        return this.change;
    }

    /*
     * Gets the payment for the transaction.
     *
     * @return the payment
     */
    public double getPayment() {
        return this.payment;
    }

}
